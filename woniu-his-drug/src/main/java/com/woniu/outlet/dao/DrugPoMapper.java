package com.woniu.outlet.dao;

import com.woniu.outlet.po.DrugPo;
import com.woniu.outlet.po.DrugPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugPoMapper {
    long countByExample(DrugPoExample example);

    int deleteByExample(DrugPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DrugPo record);

    int insertSelective(DrugPo record);

    List<DrugPo> selectByExample(DrugPoExample example);

    DrugPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugPo record, @Param("example") DrugPoExample example);

    int updateByExample(@Param("record") DrugPo record, @Param("example") DrugPoExample example);

    int updateByPrimaryKeySelective(DrugPo record);

    int updateByPrimaryKey(DrugPo record);
}