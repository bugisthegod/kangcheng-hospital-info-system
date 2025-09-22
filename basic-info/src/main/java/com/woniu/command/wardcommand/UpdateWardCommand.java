package com.woniu.command.wardcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.outlet.po.WardPo;
import com.woniu.service.impl.OperationItemCommandHandler;
import com.woniu.service.impl.WardCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class UpdateWardCommand implements Command<WardPo,Integer> {

    private WardCommandHandler handler;

    public UpdateWardCommand(){
        WardCommandHandler wardCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(WardCommandHandler.class);
        this.handler = wardCommandHandler;
    }

    @Override
    public Integer excute(WardPo wardPo) {
        return handler.updateWard(wardPo);
    }
}
