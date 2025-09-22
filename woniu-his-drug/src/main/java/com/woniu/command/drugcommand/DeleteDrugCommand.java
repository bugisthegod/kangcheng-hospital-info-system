package com.woniu.command.drugcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DrugPo;
import com.woniu.service.handler.DrugCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class DeleteDrugCommand implements Command<Integer, Integer> {

    public DrugCommandHandler handler;

    public DeleteDrugCommand() {
        DrugCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(DrugCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(Integer id) {
        Integer flag = handler.deleteDrug(id);
        return flag;
    }
}
