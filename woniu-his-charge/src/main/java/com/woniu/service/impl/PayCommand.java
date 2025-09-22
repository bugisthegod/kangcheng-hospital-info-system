package com.woniu.service.impl;

import com.woniu.adapter.PayAdapter;
import com.woniu.outlet.po.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayCommand {

    @Autowired
    private PayAdapter payAdapter;

    public Integer addPay(Pay pay){
        return payAdapter.AddPay(pay);
    }

    public void payfor(Integer payid){
        payAdapter.payfor(payid);
    }

    public void payOutHospital(Integer patientid){
        payAdapter.payOutHospital(patientid);
    }
}
