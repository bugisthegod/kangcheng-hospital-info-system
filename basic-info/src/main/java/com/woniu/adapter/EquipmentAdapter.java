package com.woniu.adapter;

import com.woniu.outlet.dao.EquipmentPoMapper;
import com.woniu.outlet.dao.SubjectPoMapper;
import com.woniu.outlet.po.EquipmentPo;
import com.woniu.outlet.po.EquipmentPoExample;
import com.woniu.outlet.po.SubjectPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class EquipmentAdapter {

    @Autowired
    private EquipmentPoMapper equipmentPoMapper;

    /**
     * 添加
     * @param equipmentPo
     * @return
     */
    public Integer addEquipment(EquipmentPo equipmentPo){
        return equipmentPoMapper.insertSelective(equipmentPo);
    }

    /**
     * 修改
     * @param equipmentPo
     * @return
     */
    public Integer updateEquipment(EquipmentPo equipmentPo){
        EquipmentPoExample example  = new EquipmentPoExample();
        EquipmentPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(equipmentPo.getId());
        List<EquipmentPo> equipmentPos = equipmentPoMapper.selectByExample(example);
        if(equipmentPos.size()==0){
            throw new RuntimeException("器材不存在,无法删除");
        }
        return equipmentPoMapper.updateByPrimaryKeySelective(equipmentPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param equipmentPo
     * @return
     */
    public Integer deleteEquipment(EquipmentPo equipmentPo){
        return equipmentPoMapper.updateByPrimaryKeySelective(equipmentPo);
    }
}
