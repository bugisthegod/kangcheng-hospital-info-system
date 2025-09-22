package com.woniu.service.impl;

import com.woniu.adapter.AdviceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdviceCommand {

    @Autowired
    private AdviceAdapter adviceAdapter;

    public void doAdvice(Integer adviceid,Integer nurseid){
        adviceAdapter.doAdvice(adviceid,nurseid);
    }
}
