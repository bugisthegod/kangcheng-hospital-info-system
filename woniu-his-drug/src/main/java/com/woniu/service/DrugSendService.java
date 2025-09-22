package com.woniu.service;

import com.woniu.outlet.po.DrugSendPo;

import java.util.List;

public interface DrugSendService {

    List<DrugSendPo> getDrugSendList(DrugSendPo drugSendPo,Integer pageNum);

    DrugSendPo getDrugSendById(Integer id);

}
