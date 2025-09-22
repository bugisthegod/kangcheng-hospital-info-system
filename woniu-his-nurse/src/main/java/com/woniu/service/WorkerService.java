package com.woniu.service;

import com.woniu.outlet.po.Worker;

import java.util.List;

public interface WorkerService {

    public List<Worker> findAbleDoctor();

    public List<Worker> findAbleNurse();
}
