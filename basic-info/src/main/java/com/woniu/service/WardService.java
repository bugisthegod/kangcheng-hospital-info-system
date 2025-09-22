package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.WardPo;

public interface WardService {

    PageInfo<WardPo> getWardList(WardPo wardPo, Integer pageNum, Integer pageSize);

    public WardPo getWardById(Integer id);
}
