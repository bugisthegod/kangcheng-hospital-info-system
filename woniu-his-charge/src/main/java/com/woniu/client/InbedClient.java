package com.woniu.client;

import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "woniu-his-nurse",qualifier = "inbed1")
public interface InbedClient {

    @GetMapping("/nurse/inbed/recycle")
    public ResponseResult<String> recycleBed(@RequestParam("inbedid") Integer inbedid);

    @GetMapping("/nurse/inbed/out")
    public ResponseResult<String> outHospital(@RequestParam("inbedid") Integer inbedid);
}
