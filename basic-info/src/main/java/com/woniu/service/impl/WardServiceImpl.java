package com.woniu.service.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.WardAdapter;
import com.woniu.outlet.po.WardPo;
import com.woniu.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardServiceImpl implements WardService {

    @Autowired
    private WardAdapter wardAdapter;

    @Override
    public PageInfo<WardPo> getWardList(WardPo wardPo, Integer pageNum, Integer pageSize) {
        return wardAdapter.getWardList(wardPo,pageNum,pageSize);
    }

    @Override
    public WardPo getWardById(Integer id) {
        return wardAdapter.getWardById(id);
    }
}
