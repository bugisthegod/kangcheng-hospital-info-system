package com.woniu.command.nursingcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.Nursing;
import com.woniu.service.impl.NursingCommand;
import com.woniu.utils.ApplicationContextHolder;

public class AddNursingCommand implements Command<Nursing,Integer> {

    private NursingCommand command;

    public AddNursingCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(NursingCommand.class);
    }

    @Override
    public Integer handle(Nursing nursing) {
        return this.command.addNursing(nursing);
    }
}
