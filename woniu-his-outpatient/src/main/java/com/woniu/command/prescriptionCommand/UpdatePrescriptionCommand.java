package com.woniu.command.prescriptionCommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class UpdatePrescriptionCommand implements Command<PrescriptionPo,Integer> {

    private PrescriptionCommandHandler handler;

    public UpdatePrescriptionCommand(){
        PrescriptionCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(PrescriptionCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(PrescriptionPo prescriptionPo) {
        Integer flag = handler.updatePrescription(prescriptionPo);
        return flag;
    }
}
