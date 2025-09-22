package com.woniu.outlet.dao;

import com.woniu.outlet.po.Reg;
import com.woniu.outlet.po.RegExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RegMapper {
    long countByExample(RegExample example);

    int deleteByExample(RegExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Reg record);
    int insertSelective(Reg record);

    List<Reg> selectByExample(RegExample example);
    Reg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reg record, @Param("example") RegExample example);
    int updateByExample(@Param("record") Reg record, @Param("example") RegExample example);
    int updateByPrimaryKeySelective(Reg record);
    int updateByPrimaryKey(Reg record);
}