package com.woniu.service.impl;

import com.woniu.adapter.AdvicePoAdapter;
import com.woniu.outlet.po.AdvicePo;
import com.woniu.service.AdvicePoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvicePoServiceImpl implements AdvicePoService {

    @Autowired
    private AdvicePoAdapter adapter;

    @Override
    public List<AdvicePo> getAdvicePoList(AdvicePo advicePo, Integer pageNum) {
        return adapter.getAdvicePo(advicePo,pageNum);
    }
}
