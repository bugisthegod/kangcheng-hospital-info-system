package com.woniu.service;

import com.woniu.outlet.po.Bed;

import java.util.List;

public interface BedService {

    List<Bed> findAbleBeds(Integer subjectid);
}
