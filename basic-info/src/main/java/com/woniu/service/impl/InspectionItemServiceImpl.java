package com.woniu.service.impl;

import com.github.pagehelper.PageInfo;
import com.woniu.adapter.InspectionItemAdapter;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.service.InspectionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectionItemServiceImpl implements InspectionItemService {

    @Autowired
    private InspectionItemAdapter inspectionItemAdapter;

    @Override
    public PageInfo<InspectionItemPo> getInspectionItemList(InspectionItemPo inspectionItemPo, Integer pageNum, Integer pageSize) {
        return inspectionItemAdapter.getInspectionItemList(inspectionItemPo,pageNum,pageSize);
    }

    @Override
    public InspectionItemPo getInspectionItemById(Integer id) {
        return inspectionItemAdapter.getInspectionItemById(id);
    }
}
