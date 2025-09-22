package com.woniu.service.handler;

import com.woniu.adapter.PrescriptionAdapter;
import com.woniu.outlet.po.PrescriptionItemPo;
import com.woniu.outlet.po.PrescriptionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrescriptionCommandHandler {

    @Autowired
    private PrescriptionAdapter adapter;

    public Integer addPrescription(PrescriptionPo prescriptionPo){
        return adapter.addPrescription(prescriptionPo);
    }

    public Integer updatePrescription(PrescriptionPo prescriptionPo){
        return adapter.updatePrescription(prescriptionPo);
    }

    public Integer deletePrescription(Integer id){
        return adapter.deletePrescription(id);
    }

    public PrescriptionPo getPreById(Integer id){return adapter.getPreById(id);}

    public List<PrescriptionItemPo> getPrescriptionItemByPId(Integer id){return adapter.getPrescriptionItem(id);}

    public Integer payPrescription(Integer id){
        return adapter.payPrescription(id);
    }



}
