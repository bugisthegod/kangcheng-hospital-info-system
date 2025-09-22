package com.woniu.command.paycommand;

import com.woniu.command.Command;
import com.woniu.service.impl.PayCommand;
import com.woniu.utils.ApplicationContextHolder;

public class PayOutCommand implements Command<Integer,String> {

    private PayCommand command;

    public PayOutCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(PayCommand.class);
    }

    @Override
    public String handle(Integer patientid) {
        this.command.payOutHospital(patientid);
        return null;
    }
}
