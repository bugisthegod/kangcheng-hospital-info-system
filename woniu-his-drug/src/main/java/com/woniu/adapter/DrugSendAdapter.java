package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.client.ChargeClient;
import com.woniu.client.PrescriptionClient;
import com.woniu.inlet.vo.PayVo;
import com.woniu.outlet.dao.DrugSendItemPoMapper;
import com.woniu.outlet.dao.DrugSendPoMapper;
import com.woniu.outlet.po.*;
import com.woniu.outlet.po.Pay;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Component
public class DrugSendAdapter {

    @Autowired
    private DrugSendPoMapper drugSendPoMapper;

    @Autowired
    private DrugSendItemPoMapper drugSendItemPoMapper;

    @Autowired
    @Qualifier("prescription")
    private PrescriptionClient prescriptionClient;

    @Autowired
    @Qualifier("charge")
    private ChargeClient chargeClient;

    public List<DrugSendPo> getDrugSendList(DrugSendPo drugSendPo,Integer pageNum){
        DrugSendPoExample example = new DrugSendPoExample();
        DrugSendPoExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(drugSendPo.getDsPatientid())){
            criteria.andDsPatientidEqualTo(drugSendPo.getDsPatientid());
        }
        if(!StringUtils.isEmpty(drugSendPo.getDsStatus())){
            criteria.andDsStatusEqualTo(drugSendPo.getDsStatus());
        }
        PageHelper.startPage(pageNum,5);
        List<DrugSendPo> drugSendPos = drugSendPoMapper.selectByExample(example);
        PageInfo<DrugSendPo> pageInfo = new PageInfo<>(drugSendPos);
        return pageInfo.getList();
    }

    /*药品发放记录添加的同时,也要给收费表加条记录*/
    public Integer addDrugSend(Integer id){
        ResponseResult<PrescriptionPo> prescriptionPoResponseResult = prescriptionClient.getPrescription(id);
        if(prescriptionPoResponseResult.getStatus()!=200){
            throw new RuntimeException("系统异常");
        }
        PrescriptionPo prescriptionPo = prescriptionPoResponseResult.getData();
        DrugSendPo drugSendPo = new DrugSendPo();
        drugSendPo.setDsTotal(prescriptionPo.getPsTotal());
        drugSendPo.setDsPatientid(prescriptionPo.getPsPatientid());
        drugSendPo.setDsDate(new Date());
        drugSendPo.setDsStatus(DrugSendPo.PAID);
        int i1 = drugSendPoMapper.insertSelective(drugSendPo);

        ResponseResult<List<PrescriptionItemPo>> responseResult = prescriptionClient.getPrescriptionItemByPid(id);
        if(responseResult.getStatus()!=200){
            throw new RuntimeException("系统异常");
        }
       responseResult.getData().forEach(item->{
            DrugSendItemPo drugSendItemPo = new DrugSendItemPo();
            drugSendItemPo.setDdDrugid(item.getPsiDrugid());
            drugSendItemPo.setDdDrugnum(item.getPsiNum());
            drugSendItemPo.setDdPrice(item.getPsiPrice());
            drugSendItemPo.setDdDrugsendid(drugSendPo.getId());
            int i = drugSendItemPoMapper.insertSelective(drugSendItemPo);
        });

        //给收费记录表加条记录
        Pay pay = new Pay();
        pay.setMoney(drugSendPo.getDsTotal());
        pay.setPatientid(drugSendPo.getDsPatientid());
        pay.setMsg(Pay.DRUG);
        pay.setTime(new Date());
        pay.setStatus(Pay.PAIED);
        PayVo payVo = new PayVo();
        BeanUtils.copyProperties(pay,payVo);
        ResponseResult<String> stringResponseResult = chargeClient.AddPay(payVo);
        return i1;
    }

    /*逻辑删除药品发放记录*/
    public Integer deleteDrugSend(Integer id){
        DrugSendPoExample example = new DrugSendPoExample();
        DrugSendPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<DrugSendPo> drugSendPos = drugSendPoMapper.selectByExample(example);
        if(drugSendPos.size()==0){
            throw new RuntimeException("药品发放记录不存在,无法删除");
        }

        DrugSendPo drugSendPo = new DrugSendPo();
        drugSendPo.setId(id);
        drugSendPo.setDsStatus(DrugSendPo.DELETED);
        return drugSendPoMapper.updateByPrimaryKeySelective(drugSendPo);
    }

}
