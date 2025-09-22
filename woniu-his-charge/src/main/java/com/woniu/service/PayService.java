package com.woniu.service;

import com.woniu.outlet.po.Pay;

import java.util.List;

public interface PayService {


    public List<Pay> findPatientPays(Integer patientid);
}
