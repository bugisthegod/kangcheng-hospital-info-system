package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.EquipmentPo;

public interface EquipmentService {

    PageInfo<EquipmentPo> getEquipmentList(EquipmentPo equipmentPo, Integer pageNum, Integer pageSize);

    public EquipmentPo getEquipmentById(Integer id);
}
