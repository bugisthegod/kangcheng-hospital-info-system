package com.woniu.service.handler;

import com.woniu.adapter.DrugAdapter;
import com.woniu.adapter.DrugSendAdapter;
import com.woniu.outlet.po.DrugPo;
import com.woniu.outlet.po.DrugSendPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugSendCommandHandler {

    @Autowired
    public DrugSendAdapter drugSendAdapter;


    public Integer deleteDrugSend(Integer id) {
        return drugSendAdapter.deleteDrugSend(id);
    }
}
