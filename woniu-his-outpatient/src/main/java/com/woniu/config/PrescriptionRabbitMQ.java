package com.woniu.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrescriptionRabbitMQ {

    //声明交换机
    @Bean("prescriptionExchange")
    public Exchange getPrescriptionExchange(){
        return ExchangeBuilder.directExchange("prescription_exchange").durable(true).build();
    }

    //声明队列
    @Bean("prescriptionQueue")
    public Queue getPrescriptionQueue() {
        return QueueBuilder.durable("prescription_queue").withArgument("x-dead-letter-exchange", "dead_prescription_exchange")
                .withArgument("x-dead-letter-routing-key", "pres.xx")
                .withArgument("x-message-ttl", 86400000)
                .build();
    }

    //绑定正常队列和交换机
    @Bean("binding")
    public Binding binding(@Qualifier("prescriptionExchange") Exchange prescriptionExchange, @Qualifier("prescriptionQueue") Queue prescriptionQueue) {
        return BindingBuilder.bind(prescriptionQueue).to(prescriptionExchange).with("pe.pq").noargs();
    }

    //死亡交换机
    @Bean("deadPrescriptionExchange")
    public TopicExchange getDeadPrescriptionExchange() {
        return ExchangeBuilder.topicExchange("dead_prescription_exchange").durable(true).build();
    }

    @Bean("deadPrescriptionQueue")
    public Queue getDeadPrescriptionQueue() {
        return QueueBuilder.durable("dead_prescription_queue").build();
    }

    @Bean("deadBinding")
    public Binding deadBindind(@Qualifier("deadPrescriptionExchange") TopicExchange deadPrescriptionExchange, @Qualifier("deadPrescriptionQueue") Queue deadPrescriptionQueue) {
        return BindingBuilder.bind(deadPrescriptionQueue).to(deadPrescriptionExchange).with("pres.#");
    }


}
