package com.woniu.service.handler;

import com.woniu.adapter.AdvicePoAdapter;
import com.woniu.outlet.po.AdvicePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdvicePoCommandHandler {

    @Autowired
    private AdvicePoAdapter adapter;

    public Integer addAdvicePo(AdvicePo advicePo){
        return adapter.addAdvicePo(advicePo);
    }

    public Integer updateAdvicePo(AdvicePo advicePo){
        return adapter.updateAdvicePo(advicePo);
    }

    public Integer deleteAdvicePo(Integer id){
        return adapter.deleteAdvicePo(id);
    }

}
