package com.woniu.outlet.dao;

import com.woniu.outlet.po.Worker;
import com.woniu.outlet.po.WorkerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerMapper {
    long countByExample(WorkerExample example);

    int deleteByExample(WorkerExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Worker record);
    int insertSelective(Worker record);

    List<Worker> selectByExample(WorkerExample example);
    Worker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Worker record, @Param("example") WorkerExample example);
    int updateByExample(@Param("record") Worker record, @Param("example") WorkerExample example);
    int updateByPrimaryKeySelective(Worker record);
    int updateByPrimaryKey(Worker record);
}