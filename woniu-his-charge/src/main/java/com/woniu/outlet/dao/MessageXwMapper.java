package com.woniu.outlet.dao;

import com.woniu.outlet.po.MessageXw;
import com.woniu.outlet.po.MessageXwExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageXwMapper {
    long countByExample(MessageXwExample example);

    int deleteByExample(MessageXwExample example);
    int deleteByPrimaryKey(Long id);

    int insert(MessageXw record);
    int insertSelective(MessageXw record);

    List<MessageXw> selectByExample(MessageXwExample example);
    MessageXw selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageXw record, @Param("example") MessageXwExample example);
    int updateByExample(@Param("record") MessageXw record, @Param("example") MessageXwExample example);
    int updateByPrimaryKeySelective(MessageXw record);
    int updateByPrimaryKey(MessageXw record);
}