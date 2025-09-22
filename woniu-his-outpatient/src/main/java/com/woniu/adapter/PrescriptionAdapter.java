package com.woniu.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.client.DrugClient;
import com.woniu.exception.DrugStockIsNotEnough;
import com.woniu.outlet.dao.MessagePoMapper;
import com.woniu.outlet.dao.PrescriptionItemPoMapper;
import com.woniu.outlet.dao.PrescriptionPoMapper;

import com.woniu.outlet.po.*;
import com.woniu.utils.MessageStatus;
import com.woniu.utils.ResponseResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class PrescriptionAdapter {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PrescriptionPoMapper prescriptionPoMapper;

    @Autowired
    private PrescriptionItemPoMapper prescriptionItemPoMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MessagePoMapper messagePoMapper;

    @Autowired
    @Qualifier("drug")
    private DrugClient drugClient;

    public List<PrescriptionPo> getPrescriptionList(PrescriptionPo prescriptionPo, Integer pageNum) {
        PrescriptionPoExample example = new PrescriptionPoExample();
        PrescriptionPoExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(prescriptionPo.getPsPatientid())) {
            criteria.andPsPatientidEqualTo(prescriptionPo.getPsPatientid());
        }
        if (!StringUtils.isEmpty(prescriptionPo.getPsDoctorid())) {
            criteria.andPsDoctoridEqualTo(prescriptionPo.getPsDoctorid());
        }
        if (!StringUtils.isEmpty(prescriptionPo.getPsStatus())) {
            criteria.andPsStatusEqualTo(prescriptionPo.getPsStatus());
        }
        if (!StringUtils.isEmpty(prescriptionPo.getPsNo())) {
            criteria.andPsNoLike("%" + prescriptionPo.getPsNo() + "%");
        }
        PageHelper.startPage(pageNum, 5);
        List<PrescriptionPo> prescriptionPos = prescriptionPoMapper.selectByExample(example);
        PageInfo<PrescriptionPo> pageInfo = new PageInfo<>(prescriptionPos);
        return pageInfo.getList();
    }

    /*添加处方单*/
    public Integer addPrescription(PrescriptionPo prescriptionPo) {
        //想算出订单项能得到的所有药品总和,生成了处方id,然后完善处方项
        List<PrescriptionItemPo> prescriptionItemPos = prescriptionPo.getPrescriptionItemPos();
        final BigDecimal[] zero = {new BigDecimal("0")};
        prescriptionItemPos.forEach(item -> {
            ResponseResult<DrugPo> drugById = drugClient.getDrugById(item.getPsiDrugid());
            zero[0] = (new BigDecimal(item.getPsiNum()).multiply(drugById
                    .getData().getOutprice())).add(zero[0]);
        });
        prescriptionPo.setPsTotal(zero[0]);
        prescriptionPo.setPsDate(new Date());
        prescriptionPo.setPsStatus(PrescriptionPo.UNPAID);
        int i = prescriptionPoMapper.insertSelective(prescriptionPo);
        prescriptionItemPos.forEach(item -> {
            item.setPsiPsid(prescriptionPo.getId());
            int i1 = prescriptionItemPoMapper.insertSelective(item);
            //减库存
            ResponseResult<DrugPo> drugPoResponseResult = drugClient.getDrugById(item.getPsiDrugid());
            if (drugPoResponseResult.getStatus() != 200) {
                throw new RuntimeException(drugPoResponseResult.getMsg());
            }
            DrugPo drug = drugPoResponseResult.getData();

            if (drug.getStock() < item.getPsiNum()) {
                throw new DrugStockIsNotEnough("库存不够啦");
            }
            drug.setStock(drug.getStock() - item.getPsiNum());
            if ((drugClient.updateDrug(drug).getStatus() != 200)) {
                throw new RuntimeException("系统异常");
            }
            drugClient.updateDrug(drug);
        });
        try {
            rabbitTemplate.convertAndSend("prescription_exchange", "pe.pq", objectMapper.writeValueAsBytes(prescriptionPo.getId()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /*删除处方单*/
    public Integer deletePrescription(Integer id) {
        PrescriptionPo prescriptionPo = prescriptionPoMapper.selectByPrimaryKey(id);
        prescriptionPo.setPsStatus(PrescriptionPo.DELETED);
        int i = prescriptionPoMapper.updateByPrimaryKey(prescriptionPo);
        return i;
    }

    /*修改处方单*/
    public Integer updatePrescription(PrescriptionPo prescriptionPo) {
        int i = prescriptionPoMapper.updateByPrimaryKeySelective(prescriptionPo);
        return i;
    }

    /*通过id来查找处方单*/
    public PrescriptionPo getPreById(Integer id) {
        PrescriptionPoExample example = new PrescriptionPoExample();
        PrescriptionPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<PrescriptionPo> prescriptionPos = prescriptionPoMapper.selectByExample(example);
        if (prescriptionPos.size() == 0) {
            throw new RuntimeException("不存在该记录");
        }

        PrescriptionPo prescriptionPo = prescriptionPoMapper.selectByPrimaryKey(id);
        return prescriptionPo;
    }

    /*通过处方单的主键来查他下面的处方单项*/
    public List<PrescriptionItemPo> getPrescriptionItem(Integer id) {
        PrescriptionItemPoExample example = new PrescriptionItemPoExample();
        PrescriptionItemPoExample.Criteria criteria = example.createCriteria();
        criteria.andPsiPsidEqualTo(id);
        List<PrescriptionItemPo> prescriptionItemPos = prescriptionItemPoMapper.selectByExample(example);
        return prescriptionItemPos;
    }

    /*病人付费,药品发放表一定添加一条记录以及收费记录一定加条记录*/
    public Integer payPrescription(Integer id) {
        PrescriptionPo prescriptionPo = new PrescriptionPo();
        prescriptionPo.setId(id);
        prescriptionPo.setPsStatus(PrescriptionPo.PAID);
        int i = prescriptionPoMapper.updateByPrimaryKeySelective(prescriptionPo);
        //将消息存入消息表中
        MessagePo messagePo = new MessagePo();
        messagePo.setMessageContent(id.toString());
        messagePo.setVersion(1L);
        messagePo.setStatus(MessageStatus.UNSEND.getStatus());
        messagePo.setRoutingKey("prescription.pay");
        messagePo.setExchange("prescriptionPaid_exchange");
        messagePo.setRetryCount(10);
        int insert = messagePoMapper.insert(messagePo);

        return i;
    }


}
