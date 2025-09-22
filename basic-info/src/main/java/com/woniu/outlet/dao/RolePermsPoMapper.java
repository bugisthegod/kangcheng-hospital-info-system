package com.woniu.outlet.dao;

import com.woniu.outlet.po.RolePermsPo;
import com.woniu.outlet.po.RolePermsPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolePermsPoMapper {
    long countByExample(RolePermsPoExample example);

    int deleteByExample(RolePermsPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePermsPo record);

    int insertSelective(RolePermsPo record);

    List<RolePermsPo> selectByExample(RolePermsPoExample example);

    RolePermsPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePermsPo record, @Param("example") RolePermsPoExample example);

    int updateByExample(@Param("record") RolePermsPo record, @Param("example") RolePermsPoExample example);

    int updateByPrimaryKeySelective(RolePermsPo record);

    int updateByPrimaryKey(RolePermsPo record);
}