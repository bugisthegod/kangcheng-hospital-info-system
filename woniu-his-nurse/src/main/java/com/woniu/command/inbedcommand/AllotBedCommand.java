package com.woniu.command.inbedcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Inbed;
import com.woniu.service.impl.InbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AllotBedCommand implements Command<Inbed, String> {

    private InbedCommand command;

    public AllotBedCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(InbedCommand.class);
    }

    @Override
    public String handle(Inbed inbed) {
        this.command.allotBed(inbed.getId(),inbed.getBedid());
        return null;
    }
}
