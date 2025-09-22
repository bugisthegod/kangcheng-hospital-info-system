package com.woniu.client;

import com.woniu.inlet.vo.PayVo;
import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "woniu-his-charge",qualifier = "charge")
public interface ChargeClient {

    @PostMapping("/charge/pay/add")
    ResponseResult<String> AddPay( @RequestBody PayVo payVo);

}
