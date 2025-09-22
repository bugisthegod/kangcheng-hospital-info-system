package com.woniu.outlet.dao;

import com.woniu.outlet.po.EquipmentPo;
import com.woniu.outlet.po.EquipmentPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentPoMapper {
    long countByExample(EquipmentPoExample example);

    int deleteByExample(EquipmentPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentPo record);

    int insertSelective(EquipmentPo record);

    List<EquipmentPo> selectByExample(EquipmentPoExample example);

    EquipmentPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipmentPo record, @Param("example") EquipmentPoExample example);

    int updateByExample(@Param("record") EquipmentPo record, @Param("example") EquipmentPoExample example);

    int updateByPrimaryKeySelective(EquipmentPo record);

    int updateByPrimaryKey(EquipmentPo record);
}