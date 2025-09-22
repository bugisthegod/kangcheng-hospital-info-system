package com.woniu.command.inbedcommand;

import com.woniu.command.Command;
import com.woniu.service.impl.InbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class OutHospitalCommand implements Command<Integer,Integer> {

    private InbedCommand command;

    public OutHospitalCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(InbedCommand.class);
    }

    @Override
    public Integer handle(Integer inbedid) {
        this.command.outHospital(inbedid);
        return null;
    }
}
