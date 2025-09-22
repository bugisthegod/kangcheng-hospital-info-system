package com.woniu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WoniuHisGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisGatewayApplication.class, args);
    }

}
