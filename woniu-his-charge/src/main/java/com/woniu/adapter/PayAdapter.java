package com.woniu.adapter;

import com.woniu.client.InbedClient;
import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.InbedMapper;
import com.woniu.outlet.dao.MessageXwMapper;
import com.woniu.outlet.dao.PatientMapper;
import com.woniu.outlet.dao.PayMapper;
import com.woniu.outlet.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@Transactional
public class PayAdapter {

    @Autowired
    private PayMapper payMapper;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private MessageXwMapper messageXwMapper;
    @Autowired
    private InbedMapper inbedMapper;
    @Autowired
    @Qualifier("inbed1")
    private InbedClient inbedClient;

    public Integer AddPay(Pay pay){
        pay.setStatus(Pay.NOTPAY);
        pay.setTime(new Date());
        return payMapper.insertSelective(pay);
    }

    public void payfor(Integer payid){
        Pay pay = payMapper.selectByPrimaryKey(payid);
        if(pay==null){
            throw new ServiceException("没有该条付费记录");
        }
        if(pay.getStatus().equals(Pay.PAIED)){
            throw new ServiceException("该条记录已付费，请勿重复付费");
        }
        Integer patientid = pay.getPatientid();
        Patient patient = patientMapper.selectByPrimaryKey(patientid);
        if(patient.getMoney().compareTo(pay.getMoney())==-1){
            throw new ServiceException("余额不足");
        }
        //减病人余额
        patient.setMoney(patient.getMoney().subtract(pay.getMoney()));
        patientMapper.updateByPrimaryKeySelective(patient);

        //改缴费记录状态（事务最终一致性，消息监听方去执行）
        // pay.setStatus(Pay.PAIED);
        // payMapper.updateByPrimaryKeySelective(pay);

        //消息表增加一条
        MessageXw messageXw = new MessageXw();
        messageXw.setStatus(MessageXw.NOT_SEND);
        messageXw.setExchange("charge_exchange");
        messageXw.setRoutingKey("x.y");
        messageXw.setMessageContent(pay.getId().toString());
        messageXw.setRetryCount(5);
        messageXwMapper.insertSelective(messageXw);
    }

    public List<Pay> findPatientPays(Integer patientid) {
        PayExample example = new PayExample();
        PayExample.Criteria criteria = example.createCriteria();
        criteria.andPatientidEqualTo(patientid);
        criteria.andStatusEqualTo(Pay.NOTPAY);
        return payMapper.selectByExample(example);
    }

    public void payOutHospital(Integer patientid){
        //钱结清
        List<Pay> pays = findPatientPays(patientid);
        if(pays.size()>0){
            for (Pay pay : pays) {
                payfor(pay.getId());
            }
        }
        //床位空出来,出院
        InbedExample example = new InbedExample();
        example.createCriteria().andPatientidEqualTo(patientid);
        List<Inbed> inbeds = inbedMapper.selectByExample(example);
        if(inbeds.size()>0){
            Inbed inbed = inbeds.get(0);
            Integer inbedid = inbed.getId();
            inbedClient.recycleBed(inbedid);
            inbedClient.outHospital(inbedid);
        }

    }
}
