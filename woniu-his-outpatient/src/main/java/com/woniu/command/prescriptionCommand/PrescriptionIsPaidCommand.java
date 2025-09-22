package com.woniu.command.prescriptionCommand;

import com.woniu.command.Command;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class PrescriptionIsPaidCommand implements Command<Integer,Integer> {

    private PrescriptionCommandHandler handler;

    public PrescriptionIsPaidCommand(){
        PrescriptionCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(PrescriptionCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public Integer execute(Integer id) {
        return handler.payPrescription(id);
    }
}
