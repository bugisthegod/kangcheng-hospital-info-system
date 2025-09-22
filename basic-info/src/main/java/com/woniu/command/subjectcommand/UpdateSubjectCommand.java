package com.woniu.command.subjectcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.SubjectPo;
import com.woniu.service.impl.SubjectCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class UpdateSubjectCommand implements Command<SubjectPo,Integer> {

    private SubjectCommandHandler handler;

    public UpdateSubjectCommand(){
        SubjectCommandHandler subjectCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(SubjectCommandHandler.class);
        this.handler = subjectCommandHandler;
    }

    @Override
    public Integer excute(SubjectPo subjectPo) {
        return handler.updateSubject(subjectPo);
    }
}
