package com.woniu.client;


import com.woniu.outlet.po.DrugPo;
import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "woniu-his-drug",qualifier = "drug",fallback = DrugClientFallBack.class)
public interface DrugClient {

    @GetMapping("/drug/getDrugById")
    ResponseResult<DrugPo> getDrugById(@RequestParam("id") Integer id);

    @PutMapping("/drug/update")
    ResponseResult<Integer> updateDrug(@RequestBody DrugPo drugPo);

}
