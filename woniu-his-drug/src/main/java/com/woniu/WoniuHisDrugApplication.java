package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.woniu.outlet.dao")
@EnableFeignClients
public class WoniuHisDrugApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisDrugApplication.class, args);
    }

}
