package com.woniu.service.impl;

import com.woniu.adapter.PatientAdapter;
import com.woniu.outlet.po.Patient;
import com.woniu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientAdapter patientAdapter;

    @Override
    public Patient findPatientById(Integer patientid) {
        return patientAdapter.findPatientById(patientid);
    }
}
