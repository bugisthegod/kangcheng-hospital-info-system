package com.woniu.service.impl;

import com.woniu.adapter.InspectionItemAdapter;
import com.woniu.adapter.OperationItemAdapter;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.outlet.po.OperationItemPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperationItemCommandHandler {

    @Autowired
    private OperationItemAdapter operationItemAdapter;

    /**
     * 添加
     * @param operationItemPo
     * @return
     */
    public Integer addOperationItem(OperationItemPo operationItemPo){
        return operationItemAdapter.addOperationItem(operationItemPo);
    }

    /**
     * 修改
     * @param operationItemPo
     * @return
     */
    public Integer updateOperationItem(OperationItemPo operationItemPo){
        return operationItemAdapter.updateOperationItem(operationItemPo);
    }

    /**
     * 删除（逻辑删除）
     * @param operationItemPo
     * @return
     */
    public Integer deleteOperationItem(OperationItemPo operationItemPo){
        return operationItemAdapter.deleteOperationItem(operationItemPo);
    }

}
