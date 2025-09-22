package com.woniu.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean("chargeExchange")
    public Exchange getExchange(){
        return ExchangeBuilder.directExchange("charge_exchange").build();
    }

    @Bean("chargeQueue")
    public Queue getQueue(){
        return QueueBuilder.durable("charge_queue").build();
    }

    @Bean
    public Binding getBinding(@Qualifier("chargeExchange") Exchange exchange,@Qualifier("chargeQueue") Queue queue){
        return BindingBuilder.bind(queue).to(exchange).with("x.y").noargs();
    }
}
