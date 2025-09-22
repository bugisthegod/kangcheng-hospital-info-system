package com.woniu.service.impl;

import com.woniu.adapter.DepartmentAdapter;
import com.woniu.outlet.po.DepartmentPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentCommandHandler {

    @Autowired
    private DepartmentAdapter departmentAdapter;

    /**
     * 添加
     * @param departmentPo
     * @return
     */
    public Integer addDepartment(DepartmentPo departmentPo){
        return departmentAdapter.addDepartment(departmentPo);
    }

    /**
     * 修改
     * @param departmentPo
     * @return
     */
    public Integer updateDepartment(DepartmentPo departmentPo){
        return departmentAdapter.updateDepartment(departmentPo);
    }

    /**
     * 删除（逻辑删除）
     * @param departmentPo
     * @return
     */
    public Integer deleteDepartment(DepartmentPo departmentPo){
        return departmentAdapter.deleteDepartment(departmentPo);
    }


}
