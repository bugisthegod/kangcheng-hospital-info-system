package com.woniu.command.prescriptionCommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class DeletePrescriptionCommand implements Command<Integer,Integer> {

    private PrescriptionCommandHandler handler;

    public DeletePrescriptionCommand(){
        PrescriptionCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(PrescriptionCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(Integer id) {
        Integer flag = handler.deletePrescription(id);
        return flag;
    }
}
