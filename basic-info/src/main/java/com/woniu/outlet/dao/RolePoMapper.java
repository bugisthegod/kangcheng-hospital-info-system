package com.woniu.outlet.dao;

import com.woniu.outlet.po.RolePo;
import com.woniu.outlet.po.RolePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePoMapper {
    long countByExample(RolePoExample example);

    int deleteByExample(RolePoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    List<RolePo> selectByExample(RolePoExample example);

    RolePo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePo record, @Param("example") RolePoExample example);

    int updateByExample(@Param("record") RolePo record, @Param("example") RolePoExample example);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);
}