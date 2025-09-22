package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.outlet.po.SubjectPo;

public interface SubjectService {

    PageInfo<SubjectPo> getSubjectList(SubjectPo subjectPo, Integer pageNum, Integer pageSize);

    public SubjectPo getSubjectById(Integer id);
}
