package com.woniu.command.operationitemcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.service.impl.InspectionItemCommandHandler;
import com.woniu.service.impl.OperationItemCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class AddOperationItemCommand implements Command<OperationItemPo,Integer> {

    private OperationItemCommandHandler handler;

    public AddOperationItemCommand(){
        OperationItemCommandHandler operationItemCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(OperationItemCommandHandler.class);
        this.handler = operationItemCommandHandler;
    }

    @Override
    public Integer excute(OperationItemPo operationItemPo) {
        return handler.addOperationItem(operationItemPo);
    }
}
