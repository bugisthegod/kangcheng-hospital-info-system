package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.woniu.outlet.dao")
@EnableDiscoveryClient
public class WoniuHisChargeConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisChargeConsumerApplication.class, args);
    }

}
