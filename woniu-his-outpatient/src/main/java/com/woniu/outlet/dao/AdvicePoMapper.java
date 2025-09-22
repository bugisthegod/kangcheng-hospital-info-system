package com.woniu.outlet.dao;

import com.woniu.outlet.po.AdvicePo;
import com.woniu.outlet.po.AdvicePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvicePoMapper {
    long countByExample(AdvicePoExample example);

    int deleteByExample(AdvicePoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdvicePo record);

    int insertSelective(AdvicePo record);

    List<AdvicePo> selectByExample(AdvicePoExample example);

    AdvicePo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdvicePo record, @Param("example") AdvicePoExample example);

    int updateByExample(@Param("record") AdvicePo record, @Param("example") AdvicePoExample example);

    int updateByPrimaryKeySelective(AdvicePo record);

    int updateByPrimaryKey(AdvicePo record);
}