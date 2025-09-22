package com.woniu.client;

import com.woniu.outlet.po.Bed;
import com.woniu.utils.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "woniu-his-registered",qualifier = "registered1")
public interface BedClient {

    @GetMapping("/registered/bed/ablelist")
    public ResponseResult<List<Bed>> findAbleBeds(@RequestParam("subjectid") Integer subjectid);
}
