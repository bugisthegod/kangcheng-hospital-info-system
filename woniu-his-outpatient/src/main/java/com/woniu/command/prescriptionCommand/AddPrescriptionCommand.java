package com.woniu.command.prescriptionCommand;

import com.woniu.command.AdvicePoCommand.AddAdvicePoCommand;
import com.woniu.command.Command;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class AddPrescriptionCommand implements Command<PrescriptionPo,Integer> {

    private PrescriptionCommandHandler handler;

    public AddPrescriptionCommand(){
        PrescriptionCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(PrescriptionCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(PrescriptionPo prescriptionPo) {
        Integer flag = handler.addPrescription(prescriptionPo);
        return flag;
    }
}
