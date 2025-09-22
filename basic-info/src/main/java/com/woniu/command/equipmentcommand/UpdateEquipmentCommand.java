package com.woniu.command.equipmentcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.EquipmentPo;
import com.woniu.outlet.po.SubjectPo;
import com.woniu.service.impl.EquipmentCommandHandler;
import com.woniu.service.impl.SubjectCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class UpdateEquipmentCommand implements Command<EquipmentPo,Integer> {

    private EquipmentCommandHandler handler;

    public UpdateEquipmentCommand(){
        EquipmentCommandHandler equipmentCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(EquipmentCommandHandler.class);
        this.handler = equipmentCommandHandler;
    }

    @Override
    public Integer excute(EquipmentPo equipmentPo) {
        return handler.updateEquipment(equipmentPo);
    }
}
