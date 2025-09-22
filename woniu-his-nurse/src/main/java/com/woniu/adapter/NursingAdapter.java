package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.NursingMapper;
import com.woniu.outlet.dao.WorkerMapper;
import com.woniu.outlet.po.Nursing;
import com.woniu.outlet.po.Worker;
import com.woniu.outlet.po.WorkerExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class NursingAdapter {

    @Autowired
    private NursingMapper nursingMapper;
    @Autowired
    private WorkerMapper workerMapper;

    public Integer addNursing(Nursing nursing){
        Worker worker = workerMapper.selectByPrimaryKey(nursing.getNurseid());
        if(worker.getWRoleid()!=3){
            throw new ServiceException("没有该护士");
        }
        nursing.setTime(new Date());
        nursing.setStatus(Nursing.END);
        return nursingMapper.insertSelective(nursing);
    }

    public Integer updateNursing(Nursing nursing){
        nursing.setTime(new Date());
        return nursingMapper.updateByPrimaryKeySelective(nursing);
    }

    public Integer deleteNursing(Integer nursingid){
        Nursing nursing = nursingMapper.selectByPrimaryKey(nursingid);
        //逻辑删除
        nursing.setTime(new Date());
        nursing.setStatus(Nursing.DELETED);
        return nursingMapper.updateByPrimaryKeySelective(nursing);
    }
}
