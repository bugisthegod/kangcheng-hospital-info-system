package com.woniu.outlet.dao;

import com.woniu.outlet.po.OperationItemPo;
import com.woniu.outlet.po.OperationItemPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationItemPoMapper {
    long countByExample(OperationItemPoExample example);

    int deleteByExample(OperationItemPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OperationItemPo record);

    int insertSelective(OperationItemPo record);

    List<OperationItemPo> selectByExample(OperationItemPoExample example);

    OperationItemPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OperationItemPo record, @Param("example") OperationItemPoExample example);

    int updateByExample(@Param("record") OperationItemPo record, @Param("example") OperationItemPoExample example);

    int updateByPrimaryKeySelective(OperationItemPo record);

    int updateByPrimaryKey(OperationItemPo record);
}