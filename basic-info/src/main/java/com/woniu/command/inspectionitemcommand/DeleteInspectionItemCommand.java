package com.woniu.command.inspectionitemcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.EquipmentPo;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.service.impl.EquipmentCommandHandler;
import com.woniu.service.impl.InspectionItemCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class DeleteInspectionItemCommand implements Command<InspectionItemPo,Integer> {

    private InspectionItemCommandHandler handler;

    public DeleteInspectionItemCommand(){
        InspectionItemCommandHandler inspectionItemCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(InspectionItemCommandHandler.class);
        this.handler = inspectionItemCommandHandler;
    }

    @Override
    public Integer excute(InspectionItemPo inspectionItemPo) {
        return handler.deleteInspectionItem(inspectionItemPo);
    }
}
