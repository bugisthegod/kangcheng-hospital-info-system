package com.woniu.outlet.dao;

import com.woniu.outlet.po.DepartmentPo;
import com.woniu.outlet.po.DepartmentPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentPoMapper {
    long countByExample(DepartmentPoExample example);

    int deleteByExample(DepartmentPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentPo record);

    int insertSelective(DepartmentPo record);

    List<DepartmentPo> selectByExample(DepartmentPoExample example);

    DepartmentPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DepartmentPo record, @Param("example") DepartmentPoExample example);

    int updateByExample(@Param("record") DepartmentPo record, @Param("example") DepartmentPoExample example);

    int updateByPrimaryKeySelective(DepartmentPo record);

    int updateByPrimaryKey(DepartmentPo record);

}