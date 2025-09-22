package com.woniu.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrescriptionPaidRabbitMQ {

    @Bean("prescriptionPaidExchange")
    public Exchange getPrescriptionPaidExchange(){
        return ExchangeBuilder.directExchange("prescriptionPaid_exchange").build();
    }

    @Bean("prescriptionPaidQueue")
    public Queue getPrescriptionPaidQueue(){
        return QueueBuilder.durable("prescriptionPaid_queue").build();
    }

    @Bean
    public Binding getprescriptionPaidBinding(@Qualifier("prescriptionPaidExchange") Exchange prescriptionPaidExchange,@Qualifier("prescriptionPaidQueue")Queue prescriptionPaidQueue){
        return BindingBuilder.bind(prescriptionPaidQueue).to(prescriptionPaidExchange).with("prescription.pay").noargs();
    }

}
