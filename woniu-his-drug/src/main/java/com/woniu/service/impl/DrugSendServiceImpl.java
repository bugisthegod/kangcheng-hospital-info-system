package com.woniu.service.impl;

import com.woniu.adapter.DrugSendAdapter;
import com.woniu.outlet.po.DrugSendPo;
import com.woniu.service.DrugSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugSendServiceImpl implements DrugSendService {

    @Autowired
    private DrugSendAdapter adapter;

    @Override
    public List<DrugSendPo> getDrugSendList(DrugSendPo drugSendPo, Integer pageNum) {
        List<DrugSendPo> drugSendList = adapter.getDrugSendList(drugSendPo, pageNum);
        return drugSendList;
    }

    @Override
    public DrugSendPo getDrugSendById(Integer id) {
        return null;
    }
}
