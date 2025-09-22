package com.woniu.service.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.BedAdapter;
import com.woniu.adapter.WardAdapter;
import com.woniu.outlet.po.BedPo;
import com.woniu.outlet.po.WardPo;
import com.woniu.service.BedService;
import com.woniu.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedAdapter bedAdapter;

    @Override
    public PageInfo<BedPo> getBedList(BedPo bedPo, Integer pageNum, Integer pageSize) {
        return bedAdapter.getBedList(bedPo,pageNum,pageSize);
    }

    @Override
    public BedPo getBedById(Integer id) {
        return bedAdapter.getBedById(id);
    }
}
