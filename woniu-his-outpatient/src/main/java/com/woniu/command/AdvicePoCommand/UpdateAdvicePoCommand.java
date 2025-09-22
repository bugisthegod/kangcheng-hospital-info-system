package com.woniu.command.AdvicePoCommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.AdvicePo;
import com.woniu.service.handler.AdvicePoCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class UpdateAdvicePoCommand implements Command<AdvicePo,Integer> {

    private AdvicePoCommandHandler handler;

    public UpdateAdvicePoCommand(){
        AdvicePoCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(AdvicePoCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(AdvicePo advicePo) {
        return handler.updateAdvicePo(advicePo);
    }
}
