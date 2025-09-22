package com.woniu.outlet.dao;

import com.woniu.outlet.po.Pay;
import com.woniu.outlet.po.PayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayMapper {
    long countByExample(PayExample example);

    int deleteByExample(PayExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Pay record);
    int insertSelective(Pay record);

    List<Pay> selectByExample(PayExample example);
    Pay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Pay record, @Param("example") PayExample example);
    int updateByExample(@Param("record") Pay record, @Param("example") PayExample example);
    int updateByPrimaryKeySelective(Pay record);
    int updateByPrimaryKey(Pay record);
}