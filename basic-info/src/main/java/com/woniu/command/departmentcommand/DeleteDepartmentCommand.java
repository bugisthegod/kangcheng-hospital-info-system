package com.woniu.command.departmentcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.service.impl.DepartmentCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class DeleteDepartmentCommand implements Command<DepartmentPo,Integer> {

    private DepartmentCommandHandler handler;

    public DeleteDepartmentCommand(){
        DepartmentCommandHandler departmentCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(DepartmentCommandHandler.class);
        this.handler = departmentCommandHandler;
    }

    @Override
    public Integer excute(DepartmentPo departmentPo) {
        return handler.deleteDepartment(departmentPo);
    }
}
