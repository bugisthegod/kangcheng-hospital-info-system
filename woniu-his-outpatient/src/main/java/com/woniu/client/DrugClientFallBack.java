package com.woniu.client;

import com.woniu.outlet.po.DrugPo;
import com.woniu.utils.ResponseResult;
import org.springframework.stereotype.Component;

//@Component
public class DrugClientFallBack implements DrugClient{
    @Override
    public ResponseResult<DrugPo> getDrugById(Integer id) {
        return new ResponseResult<>(null,"进入fallback了",999);
    }

    @Override
    public ResponseResult<Integer> updateDrug(DrugPo drugPo) {
        return new ResponseResult<>(null,"进入fallback了",999);
    }
}
