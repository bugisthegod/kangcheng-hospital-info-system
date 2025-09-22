package com.woniu.command.inbedcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Inbed;
import com.woniu.service.impl.InbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AllotWorkerCommand implements Command<Inbed,String> {

    private InbedCommand command;

    public AllotWorkerCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(InbedCommand.class);
    }

    @Override
    public String handle(Inbed inbed) {
        this.command.allotWorker(inbed.getId(),inbed.getDoctorid(),inbed.getNurseid());
        return null;
    }
}
