package com.woniu.outlet.dao;

import com.woniu.outlet.po.ReliableXwExample;
import com.woniu.outlet.po.ReliableXwKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReliableXwMapper {
    long countByExample(ReliableXwExample example);

    int deleteByExample(ReliableXwExample example);
    int deleteByPrimaryKey(ReliableXwKey key);

    int insert(ReliableXwKey record);
    int insertSelective(ReliableXwKey record);

    List<ReliableXwKey> selectByExample(ReliableXwExample example);

    int updateByExampleSelective(@Param("record") ReliableXwKey record, @Param("example") ReliableXwExample example);
    int updateByExample(@Param("record") ReliableXwKey record, @Param("example") ReliableXwExample example);
}