package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.InspectionItemPo;

public interface InspectionItemService {

    PageInfo<InspectionItemPo> getInspectionItemList(InspectionItemPo inspectionItemPo, Integer pageNum, Integer pageSize);

    public InspectionItemPo getInspectionItemById(Integer id);
}
