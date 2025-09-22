package com.woniu.outlet.dao;

import com.woniu.outlet.po.ReliablePoExample;
import com.woniu.outlet.po.ReliablePoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReliablePoMapper {
    long countByExample(ReliablePoExample example);

    int deleteByExample(ReliablePoExample example);

    int deleteByPrimaryKey(ReliablePoKey key);

    int insert(ReliablePoKey record);

    int insertSelective(ReliablePoKey record);

    List<ReliablePoKey> selectByExample(ReliablePoExample example);

    int updateByExampleSelective(@Param("record") ReliablePoKey record, @Param("example") ReliablePoExample example);

    int updateByExample(@Param("record") ReliablePoKey record, @Param("example") ReliablePoExample example);
}