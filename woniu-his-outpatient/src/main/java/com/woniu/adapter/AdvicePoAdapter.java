package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.AdvicePoMapper;
import com.woniu.outlet.po.AdvicePo;
import com.woniu.outlet.po.AdvicePoExample;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class AdvicePoAdapter {

    @Autowired
    private AdvicePoMapper advicePoMapper;

    public List<AdvicePo> getAdvicePo(AdvicePo advicePo,Integer pageNum){
        AdvicePoExample example = new AdvicePoExample();
        AdvicePoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(advicePo.getPatientid())){
            criteria.andPatientidEqualTo(advicePo.getPatientid());
        }
        PageHelper.startPage(pageNum,5);
        List<AdvicePo> advicePos = advicePoMapper.selectByExample(example);
        PageInfo<AdvicePo> pageInfo = new PageInfo<>(advicePos);
        return pageInfo.getList();
    }

    public Integer addAdvicePo(AdvicePo advicePo) {
        advicePo.setTime(new Date());
        advicePo.setStatus(AdvicePo.ON);
        return advicePoMapper.insertSelective(advicePo);
    }

    public Integer updateAdvicePo(AdvicePo advicePo) {
        return advicePoMapper.updateByPrimaryKeySelective(advicePo);
    }

    public Integer deleteAdvicePo(Integer id){
        return advicePoMapper.deleteByPrimaryKey(id);
    }


}
