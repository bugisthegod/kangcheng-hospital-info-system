package com.woniu.service.impl;

import com.woniu.adapter.InbedAdapter;
import com.woniu.outlet.po.Inbed;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Component
public class InbedCommand {

    @Autowired
    private InbedAdapter inbedAdapter;

    public void addInbed(Integer regbedid){
        inbedAdapter.addInbed(regbedid);
    }

    public void allotBed(Integer inbedid,Integer bedid){
        inbedAdapter.allotInbed(inbedid, bedid);
    }

    public void recycleBed(Integer inbedid){
        inbedAdapter.recycleBed(inbedid);
    }

    public void allotWorker(Integer inbedid,Integer doctorid,Integer nurseid){
        inbedAdapter.allotWorker(inbedid, doctorid, nurseid);
    }

    public BigDecimal outHospitalSettle(Integer inbedid){
        return inbedAdapter.outHospitalSettle(inbedid);
    }

    public void outHospital(Integer inbedid){
        inbedAdapter.outHospital(inbedid);
    }
}
