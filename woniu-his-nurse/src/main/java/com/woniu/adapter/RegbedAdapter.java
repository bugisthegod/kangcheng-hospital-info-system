package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.PatientMapper;
import com.woniu.outlet.dao.RegbedMapper;
import com.woniu.outlet.po.Patient;
import com.woniu.outlet.po.Regbed;
import com.woniu.outlet.po.RegbedExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Component
@Transactional
public class RegbedAdapter {

    @Autowired
    private RegbedMapper regbedMapper;
    @Autowired
    private PatientMapper patientMapper;

    public void checkRegbed(Integer regbedid){
        Regbed regbed = regbedMapper.selectByPrimaryKey(regbedid);
        if(regbed==null){
            throw new ServiceException("没有该预约记录");
        }
        Patient patient = patientMapper.selectByPrimaryKey(regbed.getPatientid());
        if(patient.getMoney().compareTo(new BigDecimal("300"))==-1){
            throw new ServiceException("预交费不足300，无法通过");
        }
        regbed.setStatus(Regbed.CHECKED);
        regbedMapper.updateByPrimaryKeySelective(regbed);
    }

    public List<Regbed> findUncheckedRegbed(){
        RegbedExample example = new RegbedExample();
        example.createCriteria().andStatusEqualTo(Regbed.UNCHECKED);
        List<Regbed> regbeds = regbedMapper.selectByExample(example);
        return regbeds;
    }

    public List<Regbed> findCheckedRegbed(){
        RegbedExample example = new RegbedExample();
        example.createCriteria().andStatusEqualTo(Regbed.CHECKED);
        List<Regbed> regbeds = regbedMapper.selectByExample(example);
        return regbeds;
    }
}
