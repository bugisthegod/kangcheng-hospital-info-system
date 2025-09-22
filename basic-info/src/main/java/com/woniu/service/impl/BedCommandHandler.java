package com.woniu.service.impl;

import com.woniu.adapter.BedAdapter;
import com.woniu.adapter.OperationItemAdapter;
import com.woniu.outlet.po.BedPo;
import com.woniu.outlet.po.OperationItemPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BedCommandHandler {

    @Autowired
    private BedAdapter bedAdapter;

    /**
     * 添加
     * @param bedPo
     * @return
     */
    public Integer addBed(BedPo bedPo){
        return bedAdapter.addBed(bedPo);
    }

    /**
     * 修改
     * @param bedPo
     * @return
     */
    public Integer updateBed(BedPo bedPo){
        return bedAdapter.updateBed(bedPo);
    }

    /**
     * 删除（逻辑删除）
     * @param bedPo
     * @return
     */
    public Integer deleteBed(BedPo bedPo){
        return bedAdapter.deleteBed(bedPo);
    }

}
