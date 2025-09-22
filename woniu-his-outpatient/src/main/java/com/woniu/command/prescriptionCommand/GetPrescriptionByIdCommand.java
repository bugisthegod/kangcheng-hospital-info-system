package com.woniu.command.prescriptionCommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

public class GetPrescriptionByIdCommand implements Command<Integer,PrescriptionPo> {

    private PrescriptionCommandHandler handler;

    public GetPrescriptionByIdCommand(){
        PrescriptionCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(PrescriptionCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public PrescriptionPo execute(Integer id) {
        PrescriptionPo preById = handler.getPreById(id);
        return preById;
    }
}
