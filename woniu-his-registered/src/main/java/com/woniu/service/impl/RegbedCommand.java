package com.woniu.service.impl;

import com.woniu.adapter.RegbedAdapter;
import com.woniu.outlet.po.Regbed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegbedCommand {

    @Autowired
    private RegbedAdapter regbedAdapter;

    public void addRegbed(Regbed regbed){
        regbedAdapter.addRegbed(regbed);
    }
}
