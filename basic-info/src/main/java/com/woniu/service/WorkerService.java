package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.WorkerPo;

public interface WorkerService {

    PageInfo<WorkerPo> getWorkerList(WorkerPo workerPo, Integer pageNum, Integer pageSize);

    public WorkerPo getWorkerById(Integer id);

}
