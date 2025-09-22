package com.woniu.outlet.dao;

import com.woniu.outlet.po.Regbed;
import com.woniu.outlet.po.RegbedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegbedMapper {
    long countByExample(RegbedExample example);

    int deleteByExample(RegbedExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Regbed record);
    int insertSelective(Regbed record);

    List<Regbed> selectByExample(RegbedExample example);
    Regbed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Regbed record, @Param("example") RegbedExample example);
    int updateByExample(@Param("record") Regbed record, @Param("example") RegbedExample example);
    int updateByPrimaryKeySelective(Regbed record);
    int updateByPrimaryKey(Regbed record);
}