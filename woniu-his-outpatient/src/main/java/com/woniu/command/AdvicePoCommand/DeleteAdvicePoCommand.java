package com.woniu.command.AdvicePoCommand;

import com.woniu.command.Command;
import com.woniu.service.handler.AdvicePoCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class DeleteAdvicePoCommand implements Command<Integer,Integer> {

    private AdvicePoCommandHandler handler;

    public DeleteAdvicePoCommand(){
        AdvicePoCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(AdvicePoCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(Integer id) {
        return handler.deleteAdvicePo(id);
    }
}
