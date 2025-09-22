package com.woniu.outlet.dao;

import com.woniu.outlet.po.WardPo;
import com.woniu.outlet.po.WardPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WardPoMapper {
    long countByExample(WardPoExample example);

    int deleteByExample(WardPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WardPo record);

    int insertSelective(WardPo record);

    List<WardPo> selectByExample(WardPoExample example);

    WardPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WardPo record, @Param("example") WardPoExample example);

    int updateByExample(@Param("record") WardPo record, @Param("example") WardPoExample example);

    int updateByPrimaryKeySelective(WardPo record);

    int updateByPrimaryKey(WardPo record);
}