package com.woniu.config;

import com.woniu.outlet.dao.MessageXwMapper;
import com.woniu.outlet.po.MessageXw;
import com.woniu.outlet.po.MessageXwExample;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
public class TimerConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MessageXwMapper messageXwMapper;

    @Scheduled(fixedRate = 5000)
    public void sendMessage(){
        MessageXwExample example = new MessageXwExample();
        MessageXwExample.Criteria criteria = example.createCriteria();
        criteria.andRetryCountGreaterThan(0);
        criteria.andStatusEqualTo(MessageXw.NOT_SEND);
        //查询未发送且重复次数大于0的
        List<MessageXw> messageXws = messageXwMapper.selectByExample(example);
        if(messageXws.size()==0){
            return;
        }

        for (MessageXw messageXw : messageXws) {
            MessagePostProcessor processor = new MessagePostProcessor() {
                @Override
                public org.springframework.amqp.core.Message postProcessMessage(org.springframework.amqp.core.Message message) throws AmqpException {
                    message.getMessageProperties().setCorrelationId(messageXw.getId().toString());
                    return message;
                }
            };

            //发消息
            rabbitTemplate.convertAndSend(messageXw.getExchange()
                    ,messageXw.getRoutingKey(),messageXw.getMessageContent(),processor,new CorrelationData(messageXw.getId().toString()));

            //重发次数减一（不管成功失败都会减一），改消息表的状态在路由回调中进行
            messageXw.setRetryCount(messageXw.getRetryCount()-1);
            messageXwMapper.updateByPrimaryKeySelective(messageXw);
        }

    }
}
