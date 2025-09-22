package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.BedPo;
import com.woniu.outlet.po.WardPo;

public interface BedService {

    PageInfo<BedPo> getBedList(BedPo bedPo, Integer pageNum, Integer pageSize);

    public BedPo getBedById(Integer id);
}
