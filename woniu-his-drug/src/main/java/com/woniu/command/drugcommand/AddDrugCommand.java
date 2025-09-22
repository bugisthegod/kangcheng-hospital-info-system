package com.woniu.command.drugcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DrugPo;
import com.woniu.service.handler.DrugCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class AddDrugCommand implements Command<DrugPo, Integer> {

    public DrugCommandHandler handler;

    public AddDrugCommand() {
        DrugCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(DrugCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(DrugPo drugPo) {
        Integer flag = handler.addDrug(drugPo);
        return flag;
    }
}
