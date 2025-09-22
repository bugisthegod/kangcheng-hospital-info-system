package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.woniu.outlet.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class WoniuHisNurseApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisNurseApplication.class, args);
    }

}
