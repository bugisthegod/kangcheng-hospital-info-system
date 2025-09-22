package com.woniu.service.impl;

import com.woniu.adapter.OperationItemAdapter;
import com.woniu.adapter.WardAdapter;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.outlet.po.WardPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WardCommandHandler {

    @Autowired
    private WardAdapter wardAdapter;

    /**
     * 添加
     * @param wardPo
     * @return
     */
    public Integer addWard(WardPo wardPo){
        return wardAdapter.addWard(wardPo);
    }

    /**
     * 修改
     * @param wardPo
     * @return
     */
    public Integer updateWard(WardPo wardPo){
        return wardAdapter.updateWard(wardPo);
    }

    /**
     * 删除（逻辑删除）
     * @param wardPo
     * @return
     */
    public Integer deleteWard(WardPo wardPo){
        return wardAdapter.deleteWard(wardPo);
    }

}
