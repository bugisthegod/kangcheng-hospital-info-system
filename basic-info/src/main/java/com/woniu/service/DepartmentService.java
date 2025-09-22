package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.DepartmentPo;

public interface DepartmentService {

    public PageInfo<DepartmentPo> getDepartmentList(DepartmentPo departmentPo, Integer pageNum, Integer pageSize);

    public DepartmentPo getDepartmentById(Integer id);
}
