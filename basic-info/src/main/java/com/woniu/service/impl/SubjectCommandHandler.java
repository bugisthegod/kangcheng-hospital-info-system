package com.woniu.service.impl;

import com.woniu.adapter.SubjectAdaper;
import com.woniu.outlet.po.SubjectPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubjectCommandHandler {

    @Autowired
    private SubjectAdaper subjectAdaper;

    /**
     * 添加
     * @param subjectPo
     * @return
     */
    public Integer addSubject(SubjectPo subjectPo){
        return subjectAdaper.addSubject(subjectPo);
    }

    /**
     * 修改
     * @param subjectPo
     * @return
     */
    public Integer updateSubject(SubjectPo subjectPo){
        return subjectAdaper.updateSubject(subjectPo);
    }

    /**
     * 删除（逻辑删除）
     * @param subjectPo
     * @return
     */
    public Integer deleteSubject(SubjectPo subjectPo){
        return subjectAdaper.deleteSubject(subjectPo);
    }
}
