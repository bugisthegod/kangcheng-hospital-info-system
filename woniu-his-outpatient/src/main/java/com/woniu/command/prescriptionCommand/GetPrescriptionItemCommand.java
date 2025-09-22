package com.woniu.command.prescriptionCommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.PrescriptionItemPo;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ApplicationContextHolder;

import java.util.List;

public class GetPrescriptionItemCommand implements Command<Integer, List<PrescriptionItemPo>> {

    private PrescriptionCommandHandler handler;

    public GetPrescriptionItemCommand(){
        PrescriptionCommandHandler commandHandler = ApplicationContextHolder.getApplicationContext().getBean(PrescriptionCommandHandler.class);
        this.handler = commandHandler;
    }

    @Override
    public List<PrescriptionItemPo> execute(Integer id) {
        List<PrescriptionItemPo> itemPoList = handler.getPrescriptionItemByPId(id);
        return itemPoList;
    }
}
