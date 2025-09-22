package com.woniu.outlet.dao;

import com.woniu.outlet.po.Deposit;
import com.woniu.outlet.po.DepositExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositMapper {
    long countByExample(DepositExample example);

    int deleteByExample(DepositExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Deposit record);
    int insertSelective(Deposit record);

    List<Deposit> selectByExample(DepositExample example);
    Deposit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Deposit record, @Param("example") DepositExample example);
    int updateByExample(@Param("record") Deposit record, @Param("example") DepositExample example);
    int updateByPrimaryKeySelective(Deposit record);
    int updateByPrimaryKey(Deposit record);
}