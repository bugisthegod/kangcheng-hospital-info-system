package com.woniu.service;

import com.woniu.outlet.po.Regbed;

import java.util.List;

public interface RegbedService {

    public List<Regbed> findUncheckedRegbed();

    public List<Regbed> findCheckedRegbed();
}
