package com.woniu.command.drugcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DrugPo;
import com.woniu.service.handler.DrugCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class GetDrugByIdCommand implements Command<Integer, DrugPo> {

    public DrugCommandHandler handler;

    public GetDrugByIdCommand() {
        DrugCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(DrugCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public DrugPo execute(Integer id) {
        DrugPo drugPo = handler.getDrugById(id);
        return drugPo;
    }
}
