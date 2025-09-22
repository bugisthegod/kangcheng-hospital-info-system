package com.woniu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.SubjectPoMapper;
import com.woniu.outlet.po.SubjectPo;
import com.woniu.outlet.po.SubjectPoExample;
import com.woniu.service.SubjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectPoMapper subjectPoMapper;

    /**
     * 获取科目列表
     * @return
     */
    public PageInfo<SubjectPo> getSubjectList(SubjectPo subjectPo, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SubjectPoExample subjectPoExample = new SubjectPoExample();
        SubjectPoExample.Criteria criteria = subjectPoExample.createCriteria();
        if(!StringUtils.isEmpty(subjectPo.getSName())){
            criteria.andSNameEqualTo(subjectPo.getSName());
        }
        if(!StringUtils.isEmpty(subjectPo.getSStatus())){
            criteria.andSStatusEqualTo(subjectPo.getSStatus());
        }
        List<SubjectPo> subjectPos = subjectPoMapper.selectByExample(subjectPoExample);
        PageInfo<SubjectPo> subjectPoPageInfo = new PageInfo<>(subjectPos);
        return subjectPoPageInfo;
    }

    /**
     * 根据id获取科目信息
     * @param id
     * @return
     */
    public SubjectPo getSubjectById(Integer id) {
        return subjectPoMapper.selectByPrimaryKey(id);
    }

}
