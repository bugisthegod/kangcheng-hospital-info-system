package com.woniu.client;

import com.woniu.inlet.web.vo.PayVo;
import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "woniu-his-charge",qualifier = "pay1")
public interface PayClient {

    @GetMapping("/charge/pay/add")
    public ResponseResult<String> AddPay(PayVo payVo);
}
