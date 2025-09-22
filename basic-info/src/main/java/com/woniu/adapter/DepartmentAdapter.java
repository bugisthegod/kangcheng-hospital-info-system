package com.woniu.adapter;

import com.woniu.outlet.dao.DepartmentPoMapper;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.outlet.po.DepartmentPoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DepartmentAdapter {

    @Autowired
    private DepartmentPoMapper departmentPoMapper;

    /**
     * 添加
     * @param departmentPo
     * @return
     */
    public Integer addDepartment(DepartmentPo departmentPo){
        return departmentPoMapper.insertSelective(departmentPo);
    }

    /**
     * 修改
     * @param departmentPo
     * @return
     */
    public Integer updateDepartment(DepartmentPo departmentPo){
        DepartmentPoExample example = new DepartmentPoExample();
        DepartmentPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(departmentPo.getId());
        List<DepartmentPo> departmentPos = departmentPoMapper.selectByExample(example);
        if(departmentPos.size()==0){
            throw new RuntimeException("部门不存在,无法修改");
        }
        return departmentPoMapper.updateByPrimaryKeySelective(departmentPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param departmentPo
     * @return
     */
    public Integer deleteDepartment(DepartmentPo departmentPo){
        return departmentPoMapper.updateByPrimaryKeySelective(departmentPo);
    }

}
