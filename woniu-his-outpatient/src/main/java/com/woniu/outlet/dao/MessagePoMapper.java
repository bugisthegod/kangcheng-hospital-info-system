package com.woniu.outlet.dao;

import com.woniu.outlet.po.MessagePo;
import com.woniu.outlet.po.MessagePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagePoMapper {
    long countByExample(MessagePoExample example);

    int deleteByExample(MessagePoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessagePo record);

    int insertSelective(MessagePo record);

    List<MessagePo> selectByExample(MessagePoExample example);

    MessagePo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessagePo record, @Param("example") MessagePoExample example);

    int updateByExample(@Param("record") MessagePo record, @Param("example") MessagePoExample example);

    int updateByPrimaryKeySelective(MessagePo record);

    int updateByPrimaryKey(MessagePo record);
}