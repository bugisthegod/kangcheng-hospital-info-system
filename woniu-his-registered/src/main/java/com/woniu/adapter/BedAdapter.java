package com.woniu.adapter;

import com.woniu.outlet.dao.BedMapper;
import com.woniu.outlet.po.Bed;
import com.woniu.outlet.po.BedExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BedAdapter {

    @Autowired
    private BedMapper bedMapper;

    public List<Bed> findAbleBeds(Integer subjectid){
        return bedMapper.findAbleBeds(subjectid);
    }


}
