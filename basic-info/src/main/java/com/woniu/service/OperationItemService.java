package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.outlet.po.OperationItemPo;

public interface OperationItemService {

    PageInfo<OperationItemPo> getOperationItemList(OperationItemPo operationItemPo, Integer pageNum, Integer pageSize);

    public OperationItemPo getOperationItemById(Integer id);
}
