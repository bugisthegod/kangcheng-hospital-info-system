package com.woniu.command.drugcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DrugPo;
import com.woniu.service.handler.DrugCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class UpdateDrugCommand implements Command<DrugPo, Integer> {

    public DrugCommandHandler handler;

    public UpdateDrugCommand() {
        DrugCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(DrugCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(DrugPo drugPo) {
        Integer flag = handler.updateDrug(drugPo);
        return flag;
    }
}
