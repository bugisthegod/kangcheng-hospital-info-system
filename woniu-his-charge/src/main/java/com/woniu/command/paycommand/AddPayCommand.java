package com.woniu.command.paycommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Pay;
import com.woniu.service.impl.PayCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AddPayCommand implements Command<Pay,Integer> {

    private PayCommand command;

    public AddPayCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(PayCommand.class);
    }

    @Override
    public Integer handle(Pay pay) {
        return this.command.addPay(pay);
    }
}
