package com.woniu.service;

import com.woniu.outlet.po.DrugPo;

import java.util.List;

public interface DrugService {

    List<DrugPo> getDrugList(DrugPo drugPo,Integer pageNum);


}
