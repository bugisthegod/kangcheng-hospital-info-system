package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.woniu.outlet.dao")
@EnableFeignClients //开启feight客户端,无需配置熔断器和负载均衡注解
@EnableScheduling
public class WoniuHisOutpatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisOutpatientApplication.class, args);
    }

}
