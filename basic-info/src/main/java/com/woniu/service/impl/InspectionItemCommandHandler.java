package com.woniu.service.impl;

import com.woniu.adapter.InspectionItemAdapter;
import com.woniu.outlet.po.InspectionItemPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InspectionItemCommandHandler {

    @Autowired
    private InspectionItemAdapter inspectionItemAdapter;

    /**
     * 添加
     * @param inspectionItemPo
     * @return
     */
    public Integer addInspectionItem(InspectionItemPo inspectionItemPo){
        return inspectionItemAdapter.addInspectionItem(inspectionItemPo);
    }

    /**
     * 修改
     * @param inspectionItemPo
     * @return
     */
    public Integer updateInspectionItem(InspectionItemPo inspectionItemPo){
        return inspectionItemAdapter.updateInspectionItem(inspectionItemPo);
    }

    /**
     * 删除（逻辑删除）
     * @param inspectionItemPo
     * @return
     */
    public Integer deleteInspectionItem(InspectionItemPo inspectionItemPo){
        return inspectionItemAdapter.deleteInspectionItem(inspectionItemPo);
    }

}
