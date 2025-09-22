package com.woniu.outlet.dao;

import com.woniu.outlet.po.DrugSendItemPo;
import com.woniu.outlet.po.DrugSendItemPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.ws.RespectBinding;

@Repository
public interface DrugSendItemPoMapper {
    long countByExample(DrugSendItemPoExample example);

    int deleteByExample(DrugSendItemPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DrugSendItemPo record);

    int insertSelective(DrugSendItemPo record);

    List<DrugSendItemPo> selectByExample(DrugSendItemPoExample example);

    DrugSendItemPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DrugSendItemPo record, @Param("example") DrugSendItemPoExample example);

    int updateByExample(@Param("record") DrugSendItemPo record, @Param("example") DrugSendItemPoExample example);

    int updateByPrimaryKeySelective(DrugSendItemPo record);

    int updateByPrimaryKey(DrugSendItemPo record);
}