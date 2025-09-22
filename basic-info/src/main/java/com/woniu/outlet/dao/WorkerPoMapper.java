package com.woniu.outlet.dao;

import com.woniu.outlet.po.WorkerPo;
import com.woniu.outlet.po.WorkerPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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

    @Select("SELECT rp.rp_percode FROM woniu_his_role_perms rp INNER JOIN woniu_his_role r ON rp.id=r.r_rolepermsid " +
            " INNER JOIN woniu_his_worker w ON w.id=r.workerid WHERE w.w_account=#{username}")
    List<String> findPermsByName(String username);
}