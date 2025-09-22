package com.woniu.command.inbedcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Inbed;
import com.woniu.service.impl.InbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AddInbedCommand implements Command<Integer,Integer> {

    private InbedCommand command;

    public AddInbedCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(InbedCommand.class);
    }

    @Override
    public Integer handle(Integer regbedid) {
        this.command.addInbed(regbedid);
        return null;
    }
}
