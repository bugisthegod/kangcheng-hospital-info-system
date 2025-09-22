package com.woniu.service.impl;

import com.woniu.adapter.BedAdapter;
import com.woniu.outlet.po.Bed;
import com.woniu.service.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BedServiceImpl implements BedService {

    @Autowired
    private BedAdapter bedAdapter;

    @Override
    public List<Bed> findAbleBeds(Integer subjectid) {
        return bedAdapter.findAbleBeds(subjectid);
    }
}
