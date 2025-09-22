package com.woniu.service.impl;

import com.woniu.adapter.SubjectAdapter;
import com.woniu.outlet.po.Subject;
import com.woniu.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectAdapter subjectAdapter;

    @Override
    public List<Subject> findAbleSubjects() {
        return subjectAdapter.findAbleSubjects();
    }
}
