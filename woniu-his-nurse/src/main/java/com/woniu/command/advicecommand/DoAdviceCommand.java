package com.woniu.command.advicecommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Advice;
import com.woniu.service.impl.AdviceCommand;
import com.woniu.utils.ApplicationContextHolder;

public class DoAdviceCommand implements Command<Advice,String> {

    private AdviceCommand command;

    public DoAdviceCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(AdviceCommand.class);
    }

    @Override
    public String handle(Advice advice) {
        this.command.doAdvice(advice.getId(),advice.getNurseid());
        return null;
    }
}
