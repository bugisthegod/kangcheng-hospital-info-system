package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.WorkerPoMapper;
import com.woniu.outlet.po.WorkerPo;
import com.woniu.outlet.po.WorkerPoExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WorkerAdapter {

    @Autowired
    private WorkerPoMapper workerPoMapper;

    public PageInfo<WorkerPo> getWorkerList(WorkerPo workerPo, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        WorkerPoExample workerPoExample = new WorkerPoExample();
        WorkerPoExample.Criteria criteria = workerPoExample.createCriteria();
        if(!StringUtils.isEmpty(workerPo.getWName())){
            criteria.andWNameEqualTo(workerPo.getWName());
        }
        if(!StringUtils.isEmpty(workerPo.getWStatus())){
            criteria.andWStatusEqualTo(workerPo.getWStatus());
        }
        List<WorkerPo> workerPos = workerPoMapper.selectByExample(workerPoExample);
        PageInfo<WorkerPo> workerPoPageInfo = new PageInfo<>(workerPos);
        return workerPoPageInfo;
    }


    public WorkerPo getWorkerById(Integer id){
        return workerPoMapper.selectByPrimaryKey(id);
    }


    public Integer addWorker(WorkerPo workerPo){
        workerPo.setWStatus("y");
        return workerPoMapper.insertSelective(workerPo);
    }


    public Integer updateWorker(WorkerPo workerPo){
        return workerPoMapper.updateByPrimaryKeySelective(workerPo);
    }


    public Integer deleteWorker(WorkerPo workerPo){
        return workerPoMapper.updateByPrimaryKeySelective(workerPo);
    }
}
