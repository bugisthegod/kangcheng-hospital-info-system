package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.DepartmentPoMapper;
import com.woniu.outlet.dao.SubjectPoMapper;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.outlet.po.SubjectPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SubjectAdaper {

    @Autowired
    private DepartmentPoMapper departmentPoMapper;

    @Autowired
    private SubjectPoMapper subjectPoMapper;

    /**
     * 添加
     * @param subjectPo
     * @return
     */
    public Integer addSubject(SubjectPo subjectPo){
        DepartmentPo departmentPo = departmentPoMapper.selectByPrimaryKey(subjectPo.getSDpid());
        if(departmentPo==null){
            throw new ServiceException("没有该部门");
        }
        subjectPo.setSStatus("y");
        return subjectPoMapper.insertSelective(subjectPo);
    }

    /**
     * 修改
     * @param subjectPo
     * @return
     */
    public Integer updateSubject(SubjectPo subjectPo){
        return subjectPoMapper.updateByPrimaryKeySelective(subjectPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param subjectPo
     * @return
     */
    public Integer deleteSubject(SubjectPo subjectPo){
        return subjectPoMapper.updateByPrimaryKeySelective(subjectPo);
    }
}
