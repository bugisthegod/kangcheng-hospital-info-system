package com.woniu.service.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.OperationItemAdapter;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.service.OperationItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationItemServiceImpl implements OperationItemService {

    @Autowired
    private OperationItemAdapter operationItemAdapter;

    @Override
    public PageInfo<OperationItemPo> getOperationItemList(OperationItemPo operationItemPo, Integer pageNum, Integer pageSize) {
        return operationItemAdapter.getOperationItemList(operationItemPo,pageNum,pageSize);
    }

    @Override
    public OperationItemPo getOperationItemById(Integer id) {
        return operationItemAdapter.getOperationItemById(id);
    }
}
