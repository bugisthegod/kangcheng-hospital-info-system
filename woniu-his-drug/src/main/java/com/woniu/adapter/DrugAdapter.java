package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.client.PrescriptionClient;
import com.woniu.outlet.dao.DrugPoMapper;
import com.woniu.outlet.po.DrugPo;
import com.woniu.outlet.po.DrugPoExample;
import com.woniu.outlet.po.PrescriptionItemPo;
import com.woniu.outlet.po.PrescriptionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrugAdapter {

    @Autowired
    private DrugPoMapper drugPoMapper;

    @Autowired
    @Qualifier("prescription")
    private PrescriptionClient prescriptionClient;

    public List<DrugPo> getDrugPoList(DrugPo drugPo,Integer pageNum){
        DrugPoExample example = new DrugPoExample();
        DrugPoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(drugPo.getName())){
            criteria.andNameLike("%"+drugPo.getName()+"%");
        }
        if(!StringUtils.isEmpty(drugPo.getBrand())){
            criteria.andBrandEqualTo(drugPo.getBrand());
        }
        if(!StringUtils.isEmpty(drugPo.getStatus())){
            criteria.andStatusEqualTo(drugPo.getStatus());
        }
        PageHelper.startPage(pageNum,5);
        List<DrugPo> drugPos = drugPoMapper.selectByExample(example);
        PageInfo<DrugPo> pageInfo = new PageInfo<>(drugPos);
        return pageInfo.getList();
    }

    public DrugPo getDrugById(Integer id) {
        DrugPo drugPo = drugPoMapper.selectByPrimaryKey(id);
        return drugPo;
    }

    public Integer updateDrug(DrugPo drugPo) {
        DrugPoExample example = new DrugPoExample();
        DrugPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(drugPo.getId());
        List<DrugPo> drugPos = drugPoMapper.selectByExample(example);
        if(drugPos.size()==0){
            throw new RuntimeException("药品不存在,无法修改");
        }
        int i = drugPoMapper.updateByPrimaryKeySelective(drugPo);
        return i;
    }

    public Integer addDrug(DrugPo drugPo) {
        int i = drugPoMapper.insertSelective(drugPo);
        return i;
    }

    public Integer deleteDrug(Integer id) {
        DrugPoExample example = new DrugPoExample();
        DrugPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<DrugPo> drugPos = drugPoMapper.selectByExample(example);
        if(drugPos.size()==0){
            throw new RuntimeException("药品不存在,无法删除");
        }

        int i = drugPoMapper.deleteByPrimaryKey(id);
        return i;
    }

    public void backDrugStock(Integer id) {
        //先查处方单转台是否是未支付,是就直接一个回滚库存
        PrescriptionPo prescriptionPo = prescriptionClient.getPrescription(id).getData();
        if (!PrescriptionPo.UNPAID.equals(prescriptionPo.getPsStatus())) { //状态不等于未付款就啥事不做
            return;
        }
        List<PrescriptionItemPo> prescriptionItemPoList = new ArrayList<>();
        prescriptionItemPoList = prescriptionClient.getPrescriptionItemByPid(id).getData();
        //回滚库存
        prescriptionItemPoList.forEach(item -> {
            DrugPo drugPo = drugPoMapper.selectByPrimaryKey(item.getPsiDrugid());
            drugPo.setStock(drugPo.getStock() + item.getPsiNum());
            int i = drugPoMapper.updateByPrimaryKeySelective(drugPo);
        });
        prescriptionPo.setPsStatus(PrescriptionPo.OVERDUE);
        prescriptionClient.updatePrescription(prescriptionPo);
    }


}
