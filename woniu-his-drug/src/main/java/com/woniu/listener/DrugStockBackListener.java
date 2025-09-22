package com.woniu.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.woniu.adapter.DrugAdapter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class DrugStockBackListener {

    @Autowired
    private DrugAdapter drugAdapter;

    @Autowired
    ObjectMapper objectMapper;

    @RabbitListener(queues = "dead_prescription_queue")
    public void onMessage(Message message, Channel channel) throws Exception {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            //1 拿到信息
            byte[] body = message.getBody();
            Integer id = objectMapper.readValue(body, Integer.class);
            //2 处理业务逻辑
            drugAdapter.backDrugStock(Integer.valueOf(id));
            //3 手动签收
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            e.printStackTrace();
            //4 拒绝接受
            channel.basicNack(deliveryTag, true, true);
        }


    }
}
