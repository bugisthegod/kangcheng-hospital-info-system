package com.woniu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.DepartmentPoMapper;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.outlet.po.DepartmentPoExample;
import com.woniu.service.DepartmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentPoMapper departmentPoMapper;

    /**
     * 获取部门列表
     * @return
     */
    public PageInfo<DepartmentPo> getDepartmentList(DepartmentPo departmentPo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        DepartmentPoExample departmentPoExample = new DepartmentPoExample();
        DepartmentPoExample.Criteria criteria = departmentPoExample.createCriteria();
        if(!StringUtils.isEmpty(departmentPo.getDpName())){
            criteria.andDpNameEqualTo(departmentPo.getDpName());
        }
        if(!StringUtils.isEmpty(departmentPo.getDpStatus())){
            criteria.andDpStatusEqualTo(departmentPo.getDpStatus());
        }
        List<DepartmentPo> departmentPos = departmentPoMapper.selectByExample(departmentPoExample);
        PageInfo<DepartmentPo> departments = new PageInfo<>(departmentPos);
        return departments;
    }

    /**
     * 根据id获取部门信息
     * @param id
     * @return
     */
    public DepartmentPo getDepartmentById(Integer id) {
        return departmentPoMapper.selectByPrimaryKey(id);
    }


}
