package com.woniu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.DrugPoMapper;
import com.woniu.outlet.po.DrugPo;
import com.woniu.outlet.po.DrugPoExample;
import com.woniu.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugPoMapper drugPoMapper;

    @Override
    public List<DrugPo> getDrugList(DrugPo drugPo, Integer pageNum) {
        DrugPoExample example = new DrugPoExample();
        DrugPoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(drugPo.getBrand())){
            criteria.andBrandLike("%"+drugPo.getBrand()+"%");
        }
        if(!StringUtils.isEmpty(drugPo.getName())){
            criteria.andNameLike("%"+drugPo.getName()+"%");
        }
        if(!StringUtils.isEmpty(drugPo.getNo())){
            criteria.andNoEqualTo(drugPo.getNo());
        }
        if(!StringUtils.isEmpty(drugPo.getStatus())){
            criteria.andStatusEqualTo(drugPo.getStatus());
        }
        if(!StringUtils.isEmpty(drugPo.getIsprescription())){
            criteria.andIsprescriptionEqualTo(drugPo.getIsprescription());
        }
        PageHelper.startPage(pageNum,5);
        List<DrugPo> drugPos = drugPoMapper.selectByExample(example);
        PageInfo<DrugPo> pageInfo = new PageInfo<>(drugPos);
        return pageInfo.getList();
    }
}
