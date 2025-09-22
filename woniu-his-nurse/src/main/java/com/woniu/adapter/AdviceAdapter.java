package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.AdviceMapper;
import com.woniu.outlet.po.Advice;
import com.woniu.outlet.po.AdviceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class AdviceAdapter {

    @Autowired
    private AdviceMapper adviceMapper;


    public void doAdvice(Integer adviceid,Integer nurseid){
        Advice advice = adviceMapper.selectByPrimaryKey(adviceid);
        if(advice==null){
            throw new ServiceException("没有该医嘱");
        }
        // if (advice.getStatus().equals(Advice.DO)){
        //     throw new ServiceException("该医嘱已被执行");
        // }
        //advice.setStatus(Advice.DO);
        if(Advice.OFF.equals(advice.getStatus())){
            throw new ServiceException("该医嘱已被停止");
        }
        advice.setNurseid(nurseid);
        advice.setTime(new Date());
        adviceMapper.updateByPrimaryKeySelective(advice);
    }


    public List<Advice> findPatientAdvice(Integer patientid){
        AdviceExample example = new AdviceExample();
        example.createCriteria().andPatientidEqualTo(patientid);
        List<Advice> adviceList = adviceMapper.selectByExample(example);
        if(adviceList.size()==0){
            throw new ServiceException("未查询到该病人医嘱");
        }
        return adviceList;
    }
}
