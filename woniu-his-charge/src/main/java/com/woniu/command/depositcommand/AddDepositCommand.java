package com.woniu.command.depositcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Deposit;
import com.woniu.service.impl.DepositCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AddDepositCommand implements Command<Deposit,Integer> {

    private DepositCommand command;

    public AddDepositCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(DepositCommand.class);
    }

    @Override
    public Integer handle(Deposit deposit) {
        this.command.advancePay(deposit);
        return null;
    }
}
