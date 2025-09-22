package com.woniu.command.paycommand;

import com.woniu.command.Command;
import com.woniu.service.impl.PayCommand;
import com.woniu.utils.ApplicationContextHolder;

public class PayforCommand implements Command<Integer,Integer> {

    private PayCommand command;

    public PayforCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(PayCommand.class);
    }

    @Override
    public Integer handle(Integer payid) {
        this.command.payfor(payid);
        return null;
    }
}
