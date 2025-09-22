package com.woniu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@MapperScan("com.woniu.outlet.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class WoniuHisRegisteredApplication {

    public static void main(String[] args) {
        SpringApplication.run(WoniuHisRegisteredApplication.class, args);
    }


    // @Bean
    // public Converter<String, Date> convertStringToDate(){
    //     return new Converter<String, Date>() {
    //         @Override
    //         public Date convert(String source) {
    //             Date date = null;
    //             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //             try {
    //                 if(!source.isEmpty()){
    //                     date=sdf.parse(source);
    //                 }
    //             } catch (ParseException e) {
    //                 e.printStackTrace();
    //             }
    //             return date;
    //         }
    //     };
    // }
}
