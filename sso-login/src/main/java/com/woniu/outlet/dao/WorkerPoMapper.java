package com.woniu.outlet.dao;

import com.woniu.outlet.po.WorkerPo;
import com.woniu.outlet.po.WorkerPoExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerPoMapper {
    long countByExample(WorkerPoExample example);

    int deleteByExample(WorkerPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WorkerPo record);

    int insertSelective(WorkerPo record);

    List<WorkerPo> selectByExample(WorkerPoExample example);

    WorkerPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WorkerPo record, @Param("example") WorkerPoExample example);

    int updateByExample(@Param("record") WorkerPo record, @Param("example") WorkerPoExample example);

    int updateByPrimaryKeySelective(WorkerPo record);

    int updateByPrimaryKey(WorkerPo record);

    @Select("SELECT p.p_percode FROM woniu_his_perms p INNER JOIN woniu_his_role_perms rp ON rp.permsid=p.id " +
            " INNER JOIN  woniu_his_role r ON r.id=rp.roleid " +
            " INNER JOIN woniu_his_worker w ON w.w_roleid= r.id WHERE w.w_account=#{username}")
    List<String> findPermsByName(String username);
}