package com.woniu.outlet.dao;

import com.woniu.outlet.po.BedPo;
import com.woniu.outlet.po.BedExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BedMapper {
    long countByExample(BedExample example);

    int deleteByExample(BedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BedPo record);

    int insertSelective(BedPo record);

    List<BedPo> selectByExample(BedExample example);

    BedPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BedPo record, @Param("example") BedExample example);

    int updateByExample(@Param("record") BedPo record, @Param("example") BedExample example);

    int updateByPrimaryKeySelective(BedPo record);

    int updateByPrimaryKey(BedPo record);
}