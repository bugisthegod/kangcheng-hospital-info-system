package com.woniu.service;

import com.woniu.outlet.po.PrescriptionPo;

import java.util.List;

public interface PrescriptionService {

    List<PrescriptionPo> getPrescription(PrescriptionPo prescriptionPo,Integer pageNum);

}
