package com.woniu.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.outlet.dao.MessagePoMapper;
import com.woniu.outlet.po.MessagePo;
import com.woniu.outlet.po.MessagePoExample;
import com.woniu.utils.MessageStatus;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
public class TimerConfig {

    @Autowired
    @Qualifier("rabbitTemplate1")
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MessagePoMapper messagePoMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() throws JsonProcessingException {
        //查询消息次数大于0且状态为为发送的消息,有就发送到队列中
        MessagePoExample example = new MessagePoExample();
        MessagePoExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(MessageStatus.UNSEND.getStatus());
        criteria.andRetryCountGreaterThan(0);

        List<MessagePo> messagePos = messagePoMapper.selectByExample(example);
        if (messagePos.size() == 0) {
            return;
        }

        for (MessagePo messagePo : messagePos) {
            MessagePostProcessor postProcessor = new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setCorrelationId(messagePo.getId().toString());
                    return message;
                }
            };

            rabbitTemplate.convertAndSend(messagePo.getExchange(), messagePo.getRoutingKey(),objectMapper.writeValueAsBytes(messagePo.getMessageContent()), postProcessor,new CorrelationData(messagePo.getId().toString()));
            //即使发送失败,message也可能不会抛出错误
            messagePo.setRetryCount(messagePo.getRetryCount() - 1);
            messagePoMapper.updateByPrimaryKeySelective(messagePo);
        }
    }

}
