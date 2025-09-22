package com.woniu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.EquipmentPoMapper;
import com.woniu.outlet.dao.SubjectPoMapper;
import com.woniu.outlet.po.EquipmentPo;
import com.woniu.outlet.po.EquipmentPoExample;
import com.woniu.outlet.po.SubjectPo;
import com.woniu.outlet.po.SubjectPoExample;
import com.woniu.service.EquipmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentPoMapper equipmentPoMapper;

    /**
     * 获取科目列表
     * @return
     */
    public PageInfo<EquipmentPo> getEquipmentList(EquipmentPo equipmentPo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EquipmentPoExample equipmentPoExample = new EquipmentPoExample();
        EquipmentPoExample.Criteria criteria = equipmentPoExample.createCriteria();
        if(!StringUtils.isEmpty(equipmentPo.getEqName())){
            criteria.andEqNameEqualTo(equipmentPo.getEqName());
        }
        if(!StringUtils.isEmpty(equipmentPo.getEqStatus())){
            criteria.andEqStatusEqualTo(equipmentPo.getEqStatus());
        }
        List<EquipmentPo> equipmentPos = equipmentPoMapper.selectByExample(equipmentPoExample);
        PageInfo<EquipmentPo> equipmentPoPageInfo = new PageInfo<>(equipmentPos);
        return equipmentPoPageInfo;
    }

    /**
     * 根据id获取科目信息
     * @param id
     * @return
     */
    public EquipmentPo getEquipmentById(Integer id) {
        return equipmentPoMapper.selectByPrimaryKey(id);
    }
}
