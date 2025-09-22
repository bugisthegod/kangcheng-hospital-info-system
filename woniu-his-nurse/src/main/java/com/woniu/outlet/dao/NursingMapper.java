package com.woniu.outlet.dao;

import com.woniu.outlet.po.Nursing;
import com.woniu.outlet.po.NursingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NursingMapper {
    long countByExample(NursingExample example);

    int deleteByExample(NursingExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Nursing record);
    int insertSelective(Nursing record);

    List<Nursing> selectByExample(NursingExample example);
    Nursing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Nursing record, @Param("example") NursingExample example);
    int updateByExample(@Param("record") Nursing record, @Param("example") NursingExample example);
    int updateByPrimaryKeySelective(Nursing record);
    int updateByPrimaryKey(Nursing record);
}