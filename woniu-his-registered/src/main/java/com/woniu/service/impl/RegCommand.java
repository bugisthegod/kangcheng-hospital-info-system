package com.woniu.service.impl;

import com.woniu.adapter.RegAdapter;
import com.woniu.outlet.po.Reg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegCommand {

    @Autowired
    private RegAdapter regAdapter ;

    public void addReg(Reg reg){
        regAdapter.addReg(reg);
    }
}
