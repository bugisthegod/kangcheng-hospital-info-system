package com.woniu.service;

import com.woniu.outlet.po.Advice;

import java.util.List;

public interface AdviceService {

    List<Advice> findPatientAdvice(Integer patientid);
}
