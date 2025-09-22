package com.woniu.service.impl;

import com.woniu.adapter.InbedAdapter;
import com.woniu.outlet.po.Inbed;
import com.woniu.service.InbedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InbedServiceImpl implements InbedService {

    @Autowired
    private InbedAdapter inbedAdapter;

    @Override
    public List<Inbed> findWaitInbed() {
        return inbedAdapter.findWaitInbed();
    }
}
