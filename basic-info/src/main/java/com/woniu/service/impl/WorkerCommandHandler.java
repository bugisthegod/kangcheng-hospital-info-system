package com.woniu.service.impl;

import com.woniu.adapter.WorkerAdapter;
import com.woniu.outlet.po.WorkerPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerCommandHandler {

    @Autowired
    private WorkerAdapter workerAdapter;

    public Integer addWorker(WorkerPo workerPo){
        return workerAdapter.addWorker(workerPo);
    }

    public Integer updateWorker(WorkerPo workerPo){
        return workerAdapter.updateWorker(workerPo);
    }

    public Integer deleteWorker(WorkerPo workerPo){
        return workerAdapter.deleteWorker(workerPo);
    }


}
