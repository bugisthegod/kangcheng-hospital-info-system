package com.woniu.outlet.dao;

import com.woniu.outlet.po.DrugSendPo;
import com.woniu.outlet.po.DrugSendPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugSendPoMapper {
    long countByExample(DrugSendPoExample example);

    int deleteByExample(DrugSendPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DrugSendPo record);

    int insertSelective(DrugSendPo record);

    List<DrugSendPo> selectByExample(DrugSendPoExample example);

    DrugSendPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugSendPo record, @Param("example") DrugSendPoExample example);

    int updateByExample(@Param("record") DrugSendPo record, @Param("example") DrugSendPoExample example);

    int updateByPrimaryKeySelective(DrugSendPo record);

    int updateByPrimaryKey(DrugSendPo record);
}