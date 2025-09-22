package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.woniu.outlet.dao")
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients
public class WoniuHisChargeApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisChargeApplication.class, args);
    }

}
