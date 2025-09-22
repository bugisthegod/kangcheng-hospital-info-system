package com.woniu.service;

import com.woniu.outlet.po.AdvicePo;

import java.util.List;

public interface AdvicePoService {

    List<AdvicePo> getAdvicePoList(AdvicePo advicePo,Integer pageNum);

}
