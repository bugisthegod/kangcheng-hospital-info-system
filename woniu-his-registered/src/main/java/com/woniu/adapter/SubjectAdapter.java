package com.woniu.adapter;

import com.woniu.outlet.dao.SubjectMapper;
import com.woniu.outlet.po.Subject;
import com.woniu.outlet.po.SubjectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class SubjectAdapter {

    @Autowired
    private SubjectMapper subjectMapper;


    public List<Subject> findAbleSubjects(){
        SubjectExample example = new SubjectExample();
        return subjectMapper.selectByExample(example);

    }
}
