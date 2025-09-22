package com.woniu.outlet.dao;

import com.woniu.outlet.po.Advice;
import com.woniu.outlet.po.AdviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceMapper {
    long countByExample(AdviceExample example);

    int deleteByExample(AdviceExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Advice record);
    int insertSelective(Advice record);

    List<Advice> selectByExample(AdviceExample example);
    Advice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Advice record, @Param("example") AdviceExample example);
    int updateByExample(@Param("record") Advice record, @Param("example") AdviceExample example);
    int updateByPrimaryKeySelective(Advice record);
    int updateByPrimaryKey(Advice record);
}