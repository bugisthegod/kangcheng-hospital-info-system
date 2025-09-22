package com.woniu.command.drugsendcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DrugSendPo;
import com.woniu.service.handler.DrugCommandHandler;
import com.woniu.service.handler.DrugSendCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class DeleteDrugSendCommand implements Command<Integer,Integer> {

    private DrugSendCommandHandler handler;

    public DeleteDrugSendCommand(){
        DrugSendCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(DrugSendCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(Integer id) {
        Integer flag = handler.deleteDrugSend(id);
        return flag;
    }
}
