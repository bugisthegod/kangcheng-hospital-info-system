package com.woniu.service.handler;

import com.woniu.adapter.DrugAdapter;
import com.woniu.outlet.po.DrugPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugCommandHandler {

    @Autowired
    public DrugAdapter drugAdapter;

    public Integer updateDrug(DrugPo drugPo){
        return  drugAdapter.updateDrug(drugPo);
    }

    public Integer addDrug(DrugPo drugPo){
        return drugAdapter.addDrug(drugPo);
    }

    public Integer deleteDrug(Integer id){return drugAdapter.deleteDrug(id);}

    public DrugPo getDrugById(Integer id){return drugAdapter.getDrugById(id);}



}
