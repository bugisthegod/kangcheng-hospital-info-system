package com.woniu.service.impl;

import com.woniu.adapter.DepositAdapter;
import com.woniu.outlet.po.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class DepositCommand {

    @Autowired
    private DepositAdapter depositAdapter;


    public void advancePay(Deposit deposit){
        depositAdapter.addDeposit(deposit);
    }
}
