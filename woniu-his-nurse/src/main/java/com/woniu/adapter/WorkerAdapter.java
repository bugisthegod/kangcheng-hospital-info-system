package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.WorkerMapper;
import com.woniu.outlet.po.Worker;
import com.woniu.outlet.po.WorkerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WorkerAdapter {

    @Autowired
    private WorkerMapper workerMapper;


    public List<Worker> findAbleDoctor(){
        WorkerExample example = new WorkerExample();
        example.createCriteria().andWRoleidEqualTo(Worker.IN_DOCTOR).andWStatusEqualTo("y");
        List<Worker> workers = workerMapper.selectByExample(example);
        if(workers.size()==0){
            throw new ServiceException("当前没有可指派医生");
        }
        return workers;
    }

    public List<Worker> findAbleNurse(){
        WorkerExample example = new WorkerExample();
        example.createCriteria().andWRoleidEqualTo(Worker.IN_NURSE).andWStatusEqualTo("y");
        List<Worker> workers = workerMapper.selectByExample(example);
        if(workers.size()==0){
            throw new ServiceException("当前没有可指派护士");
        }
        return workers;
    }
}
