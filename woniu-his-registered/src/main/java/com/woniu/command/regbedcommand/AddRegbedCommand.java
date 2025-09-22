package com.woniu.command.regbedcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Regbed;
import com.woniu.service.impl.RegbedCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AddRegbedCommand implements Command<Regbed,Integer> {

    private RegbedCommand command;

    public AddRegbedCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(RegbedCommand.class);
    }

    @Override
    public Integer handle(Regbed regbed) {
        this.command.addRegbed(regbed);
        return null;
    }
}
