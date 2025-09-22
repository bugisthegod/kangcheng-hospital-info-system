package com.woniu.service.impl;

import com.woniu.adapter.PayAdapter;
import com.woniu.outlet.po.Pay;
import com.woniu.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayAdapter payAdapter;

    @Override
    public List<Pay> findPatientPays(Integer patientid) {
        return payAdapter.findPatientPays(patientid);
    }
}
