package com.woniu.adapter;

import com.woniu.outlet.dao.PatientMapper;
import com.woniu.outlet.po.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PatientAdapter {

    @Autowired
    private PatientMapper patientMapper;

    public Patient findPatientById(Integer patientid){
        return patientMapper.selectByPrimaryKey(patientid);
    }
}
