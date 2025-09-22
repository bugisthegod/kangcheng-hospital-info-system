package com.woniu.config;

import com.woniu.outlet.dao.MessageXwMapper;
import com.woniu.outlet.po.MessageXw;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqCallBackConfig {

    @Autowired
    private MessageXwMapper messageXwMapper;


    @Bean
    public RabbitTemplate getRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);

        //交换机回调（都会执行）
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if(ack){
                    //发送成功情况,需要改消息表的状态，那边把id装起来这边拿就行
                    long messageId = Long.parseLong(correlationData.getId());
                    MessageXw messageXw = messageXwMapper.selectByPrimaryKey(messageId);
                    //当交换机正确，路由错误时，路由的回调会先执行，这里判断是不是路由错误过来的，不是则改状态，否则不需要改
                    if(!messageXw.getStatus().equals(MessageXw.ROUTE_ERROR)){
                        messageXw.setStatus(MessageXw.SEND);
                        messageXwMapper.updateByPrimaryKeySelective(messageXw);
                    }
                }else{

                }
            }
        });

        //路由到队列失败才执行的回调（交换机正确才会执行），先于交换机回调执行
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                String messageXwId = message.getMessageProperties().getCorrelationId();
                MessageXw messageXw = new MessageXw();
                messageXw.setId(Long.parseLong(messageXwId));
                //状态改成路由错误
                messageXw.setStatus(MessageXw.ROUTE_ERROR);
                messageXwMapper.updateByPrimaryKeySelective(messageXw);
            }
        });

        return rabbitTemplate;
    }
}
