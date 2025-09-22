package com.woniu.service.impl;

import com.woniu.adapter.RegbedAdapter;
import com.woniu.outlet.po.Regbed;
import com.woniu.service.RegbedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegbedServiceImpl implements RegbedService {

    @Autowired
    private RegbedAdapter regbedAdapter;

    @Override
    public List<Regbed> findUncheckedRegbed(){
        return regbedAdapter.findUncheckedRegbed();
    }

    @Override
    public List<Regbed> findCheckedRegbed() {
        return regbedAdapter.findCheckedRegbed();
    }
}
