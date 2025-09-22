package com.woniu.command.bedcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.BedPo;
import com.woniu.outlet.po.WardPo;
import com.woniu.service.impl.BedCommandHandler;
import com.woniu.service.impl.WardCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class DeleteBedCommand implements Command<BedPo,Integer> {

    private BedCommandHandler handler;

    public DeleteBedCommand(){
        BedCommandHandler bedCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(BedCommandHandler.class);
        this.handler = bedCommandHandler;
    }

    @Override
    public Integer excute(BedPo bedPo) {
        return handler.deleteBed(bedPo);
    }
}
