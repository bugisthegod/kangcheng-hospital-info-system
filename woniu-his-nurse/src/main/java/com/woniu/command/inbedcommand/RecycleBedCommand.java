package com.woniu.command.inbedcommand;

import com.woniu.command.Command;
import com.woniu.service.impl.InbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class RecycleBedCommand implements Command<Integer,Integer> {

    private InbedCommand command;

    public RecycleBedCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(InbedCommand.class);
    }

    @Override
    public Integer handle(Integer integer) {
        this.command.recycleBed(integer);
        return null;
    }
}
