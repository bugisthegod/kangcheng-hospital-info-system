package com.woniu.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.woniu.adapter.DrugSendAdapter;
import com.woniu.outlet.dao.ReliablePoMapper;
import com.woniu.outlet.po.ReliablePoKey;
import io.swagger.models.auth.In;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AddDrugSendListener {

    @Autowired
    private DrugSendAdapter adapter;

    @Autowired
    private ReliablePoMapper reliablePoMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "prescriptionPaid_queue")
    public void recieveMessage(Message message, Channel channel) throws IOException {

        try {
            ReliablePoKey reliablePoKey = new ReliablePoKey();
            reliablePoKey.setMessageid(Integer.parseInt(message.getMessageProperties().getCorrelationId()));
            int insert = reliablePoMapper.insertSelective(reliablePoKey);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        long tag = message.getMessageProperties().getDeliveryTag();
        try {
            Integer messageId = objectMapper.readValue(message.getBody(), Integer.class);
            Integer flag = adapter.addDrugSend(messageId);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            e.printStackTrace();
            channel.basicNack(tag, false, true);
        }
    }

}
