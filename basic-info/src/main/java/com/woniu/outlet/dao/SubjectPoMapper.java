package com.woniu.outlet.dao;

import com.woniu.outlet.po.SubjectPo;
import com.woniu.outlet.po.SubjectPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectPoMapper {
    long countByExample(SubjectPoExample example);

    int deleteByExample(SubjectPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SubjectPo record);

    int insertSelective(SubjectPo record);

    List<SubjectPo> selectByExample(SubjectPoExample example);

    SubjectPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SubjectPo record, @Param("example") SubjectPoExample example);

    int updateByExample(@Param("record") SubjectPo record, @Param("example") SubjectPoExample example);

    int updateByPrimaryKeySelective(SubjectPo record);

    int updateByPrimaryKey(SubjectPo record);
}