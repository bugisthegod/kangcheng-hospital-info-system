package com.woniu.command.regcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Reg;
import com.woniu.service.impl.RegCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AddRegCommand implements Command<Reg,Integer> {

    private RegCommand command;

    public AddRegCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(RegCommand.class);
    }

    @Override
    public Integer handle(Reg reg) {
        this.command.addReg(reg);
        return null;
    }
}
