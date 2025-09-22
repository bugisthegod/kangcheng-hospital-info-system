package com.woniu.service.impl;

import com.woniu.adapter.WorkerAdapter;
import com.woniu.outlet.po.Worker;
import com.woniu.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerAdapter workerAdapter;

    @Override
    public List<Worker> findAbleDoctor() {
        return workerAdapter.findAbleDoctor();
    }

    @Override
    public List<Worker> findAbleNurse() {
        return workerAdapter.findAbleNurse();
    }
}
