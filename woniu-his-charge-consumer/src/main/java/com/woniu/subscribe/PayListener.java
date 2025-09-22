package com.woniu.subscribe;

import com.rabbitmq.client.Channel;
import com.woniu.outlet.dao.PayMapper;
import com.woniu.outlet.dao.ReliableXwMapper;
import com.woniu.outlet.po.Pay;
import com.woniu.outlet.po.ReliableXwKey;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class PayListener {

    @Autowired
    private PayMapper payMapper;
    @Autowired
    private ReliableXwMapper reliableXwMapper;

    @RabbitListener(queues = "charge_queue")
    public void payCallBack(Channel channel, Message message) throws IOException {

        //消息去重表插入一条
        try {
            int messageId = Integer.parseInt(message.getMessageProperties().getCorrelationId());
            ReliableXwKey reliableXwKey = new ReliableXwKey();
            reliableXwKey.setMessageid(messageId);
            reliableXwMapper.insertSelective(reliableXwKey);
        } catch (NumberFormatException e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            return ;
        }


        try{
            int payid = Integer.parseInt(new String(message.getBody()));
            Pay pay = new Pay();
            pay.setId(payid);
            pay.setStatus(Pay.PAIED);
            payMapper.updateByPrimaryKeySelective(pay);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
            e.printStackTrace();
        }
    }
}
