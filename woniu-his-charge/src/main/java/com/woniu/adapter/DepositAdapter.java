package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.DepositMapper;
import com.woniu.outlet.dao.PatientMapper;
import com.woniu.outlet.po.Deposit;
import com.woniu.outlet.po.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional
public class DepositAdapter {

    @Autowired
    private DepositMapper depositMapper;
    @Autowired
    private PatientMapper patientMapper;

    public void addDeposit(Deposit deposit){
        //增加一条记录
        deposit.setTime(new Date());
        depositMapper.insertSelective(deposit);
        //病人的余额增加
        Patient patient = patientMapper.selectByPrimaryKey(deposit.getPatientid());
        if(patient==null){
            throw new ServiceException("该患者不存在");
        }
        patient.setMoney(patient.getMoney().add(deposit.getMoney()));
        patientMapper.updateByPrimaryKeySelective(patient);
    }
}
