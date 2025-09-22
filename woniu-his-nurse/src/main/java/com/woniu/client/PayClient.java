package com.woniu.client;

import com.woniu.inlet.web.vo.PayVo;
import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "woniu-his-charge",qualifier = "pay1")
public interface PayClient {

    @GetMapping("/charge/pay/findpatientpays")
    public ResponseResult<List<PayVo>> findPatientPays(@RequestParam("patientid") Integer patientid);
}
