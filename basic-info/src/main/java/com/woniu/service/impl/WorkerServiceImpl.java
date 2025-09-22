package com.woniu.service.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.WorkerAdapter;
import com.woniu.outlet.po.WorkerPo;
import com.woniu.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerAdapter workerAdapter;


    @Override
    public PageInfo<WorkerPo> getWorkerList(WorkerPo workerPo, Integer pageNum, Integer pageSize) {
        return workerAdapter.getWorkerList(workerPo, pageNum, pageSize);
    }

    @Override
    public WorkerPo getWorkerById(Integer id) {
        return workerAdapter.getWorkerById(id);
    }
}


