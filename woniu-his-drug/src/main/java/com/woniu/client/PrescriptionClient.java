package com.woniu.client;

import com.woniu.outlet.po.PrescriptionItemPo;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "woniu-his-outpatient",qualifier = "prescription")
public interface PrescriptionClient {


    @PutMapping("/outpatient/prescription/update")
    ResponseResult<Integer> updatePrescription(@RequestBody PrescriptionPo prescriptionPo);

    @GetMapping("/outpatient/prescription/getPrescriptionItemByPid")
    ResponseResult<List<PrescriptionItemPo>> getPrescriptionItemByPid(@RequestParam("id") Integer id);

    @GetMapping("/outpatient/prescription/getPreById")
    ResponseResult<PrescriptionPo> getPrescription( @RequestParam("id") Integer id);

}
