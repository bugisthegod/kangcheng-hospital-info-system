package com.woniu.command.nursingcommand;

import com.woniu.command.Command;
import com.woniu.service.impl.NursingCommand;
import com.woniu.utils.ApplicationContextHolder;

public class DeleteNursingCommand implements Command<Integer, Integer> {

    private NursingCommand command;

    public DeleteNursingCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(NursingCommand.class);
    }

    @Override
    public Integer handle(Integer id) {
        return command.deleteNursing(id);
    }
}
