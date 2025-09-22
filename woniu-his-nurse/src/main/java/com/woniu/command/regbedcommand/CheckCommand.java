package com.woniu.command.regbedcommand;

import com.woniu.command.Command;
import com.woniu.service.impl.RegbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class CheckCommand implements Command<Integer,String> {

    private RegbedCommand command;

    public CheckCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(RegbedCommand.class);
    }

    @Override
    public String handle(Integer regbedid) {
        this.command.checkRegbed(regbedid);
        return null;
    }
}
