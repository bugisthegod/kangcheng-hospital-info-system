package com.woniu.command.departmentcommand;

import com.woniu.command.Command;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.service.impl.DepartmentCommandHandler;
import com.woniu.util.ApplicationContextHolder;

public class UpdateDepartmentCommand implements Command<DepartmentPo,Integer> {

    private DepartmentCommandHandler handler;

    public UpdateDepartmentCommand(){
        DepartmentCommandHandler departmentCommandHandler = ApplicationContextHolder.getApplicationContext().getBean(DepartmentCommandHandler.class);
        this.handler = departmentCommandHandler;
    }

    @Override
    public Integer excute(DepartmentPo departmentPo) {
        return handler.updateDepartment(departmentPo);
    }
}
