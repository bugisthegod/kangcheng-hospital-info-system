package com.woniu.util;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHolder {

    private static ApplicationContext APPLICATION_CONTEXT = null;

    public ApplicationContextHolder(ApplicationContext ac){
        APPLICATION_CONTEXT = ac;
    }

    public static ApplicationContext getApplicationContext(){
        return APPLICATION_CONTEXT;
    }


}
