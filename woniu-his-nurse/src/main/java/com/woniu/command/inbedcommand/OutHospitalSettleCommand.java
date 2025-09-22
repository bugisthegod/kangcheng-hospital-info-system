package com.woniu.command.inbedcommand;

import com.woniu.command.Command;
import com.woniu.service.impl.InbedCommand;
import com.woniu.utils.ApplicationContextHolder;

import java.math.BigDecimal;

public class OutHospitalSettleCommand implements Command<Integer, BigDecimal> {

    private InbedCommand command;

    public OutHospitalSettleCommand(){
        this.command = ApplicationContextHolder.getApplicationContext().getBean(InbedCommand.class);
    }

    @Override
    public BigDecimal handle(Integer inbedid) {
        return this.command.outHospitalSettle(inbedid);
    }
}
