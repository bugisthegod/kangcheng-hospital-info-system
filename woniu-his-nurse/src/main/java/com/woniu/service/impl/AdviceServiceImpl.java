package com.woniu.service.impl;

import com.woniu.adapter.AdviceAdapter;
import com.woniu.outlet.po.Advice;
import com.woniu.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceAdapter adviceAdapter;


    @Override
    public List<Advice> findPatientAdvice(Integer patientid) {
        return adviceAdapter.findPatientAdvice(patientid);
    }
}
