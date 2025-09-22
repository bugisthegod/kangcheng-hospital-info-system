package com.woniu.service.impl;

import com.woniu.adapter.EquipmentAdapter;
import com.woniu.outlet.po.EquipmentPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EquipmentCommandHandler {

    @Autowired
    private EquipmentAdapter equipmentAdapter;

    /**
     * 添加
     * @param departmentPo
     * @return
     */
    public Integer addEquipment(EquipmentPo equipmentPo){
        return equipmentAdapter.addEquipment(equipmentPo);
    }

    /**
     * 修改
     * @param equipmentPo
     * @return
     */
    public Integer updateEquipment(EquipmentPo equipmentPo){
        return equipmentAdapter.updateEquipment(equipmentPo);
    }

    /**
     * 删除（逻辑删除）
     * @param equipmentPo
     * @return
     */
    public Integer deleteEquipment(EquipmentPo equipmentPo){
        return equipmentAdapter.deleteEquipment(equipmentPo);
    }

}
