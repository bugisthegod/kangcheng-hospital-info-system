package com.woniu.service.impl;

import com.woniu.adapter.NursingAdapter;
import com.woniu.outlet.po.Nursing;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
public class NursingCommand {

    @Autowired
    private NursingAdapter nursingAdapter;

    public Integer addNursing(Nursing nursing){
        return nursingAdapter.addNursing(nursing);
    }

    public Integer updateNursing(Nursing nursing){
        return nursingAdapter.updateNursing(nursing);
    }

    public Integer deleteNursing(Integer nursingid){
        return nursingAdapter.deleteNursing(nursingid);
    }
}
