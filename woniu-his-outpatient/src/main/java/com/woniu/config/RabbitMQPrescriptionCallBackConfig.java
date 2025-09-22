package com.woniu.config;

import com.woniu.outlet.dao.MessagePoMapper;
import com.woniu.outlet.po.MessagePo;
import com.woniu.utils.MessageStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQPrescriptionCallBackConfig {

    private Long messageId = 0L;

    @Autowired
    private MessagePoMapper messagePoMapper;

    @Bean("rabbitTemplate1")
    public RabbitTemplate getRabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(factory);
        //消息正确的发送到交换机
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                //如果成功,就将消息状态修改为成功状态
                log.info("发送成功");
                if (ack) {
                    MessagePo messagePo = new MessagePo();
                    messageId = Long.parseLong(correlationData.getId());
                    messagePo.setId(messageId);
                    messagePo.setStatus(MessageStatus.SUCCESS.getStatus());
                    messagePoMapper.updateByPrimaryKeySelective(messagePo);
                }
            }
        });
        rabbitTemplate.setMandatory(true);
        //消息从交换机发送到队列失败
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                MessagePo messagePo = new MessagePo();
                messagePo.setId(messageId);
                messagePo.setStatus(MessageStatus.UNSEND.getStatus());
                messagePoMapper.updateByPrimaryKeySelective(messagePo);
            }
        });

        return rabbitTemplate;
    }


}
