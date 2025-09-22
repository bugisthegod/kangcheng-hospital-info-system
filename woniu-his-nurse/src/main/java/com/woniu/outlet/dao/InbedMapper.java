package com.woniu.outlet.dao;

import com.woniu.outlet.po.Inbed;
import com.woniu.outlet.po.InbedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InbedMapper {
    long countByExample(InbedExample example);

    int deleteByExample(InbedExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Inbed record);
    int insertSelective(Inbed record);

    List<Inbed> selectByExample(InbedExample example);
    Inbed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Inbed record, @Param("example") InbedExample example);
    int updateByExample(@Param("record") Inbed record, @Param("example") InbedExample example);
    int updateByPrimaryKeySelective(Inbed record);
    int updateByPrimaryKey(Inbed record);
}