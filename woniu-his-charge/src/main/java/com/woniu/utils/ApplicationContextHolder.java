package com.woniu.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder {

    private static ApplicationContext   APPLICATION_CONTEXT = null;

    public ApplicationContextHolder(ApplicationContext con){
        APPLICATION_CONTEXT = con;
    }

    public static ApplicationContext getApplicationContext(){
        return APPLICATION_CONTEXT;
    }

}
