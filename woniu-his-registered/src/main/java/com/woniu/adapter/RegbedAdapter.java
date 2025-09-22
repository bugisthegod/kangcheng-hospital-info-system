package com.woniu.adapter;

import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.PatientMapper;
import com.woniu.outlet.dao.RegbedMapper;
import com.woniu.outlet.dao.SubjectMapper;
import com.woniu.outlet.po.Patient;
import com.woniu.outlet.po.PatientExample;
import com.woniu.outlet.po.Regbed;
import com.woniu.outlet.po.Subject;
import com.woniu.utils.JwtTokenUtil;
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
    @Autowired
    private SubjectMapper subjectMapper;

    public void addRegbed(Regbed regbed){

        boolean flag = false;
        try {
            flag = JwtTokenUtil.checkSign(regbed.getToken());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("token无效或过期");
        }
        if(flag){
            //查询是否有该科室
            Subject subject = subjectMapper.selectByPrimaryKey(regbed.getSubjectid());
            if(subject==null){
                throw new ServiceException("没有该科室！");
            }
            //查询是否有该病人
            PatientExample example = new PatientExample();
            example.createCriteria().andIdcardEqualTo(regbed.getIdcard());
            List<Patient> patients = patientMapper.selectByExample(example);
            Patient patient = new Patient();
            if(patients.size()==0){
                //添加一个到患者表
                patient.setName(regbed.getName());
                patient.setGender(regbed.getGender());
                patient.setAge(regbed.getAge());
                patient.setIdcard(regbed.getIdcard());
                patient.setPhone(regbed.getPhone());
                patient.setMoney(new BigDecimal("0"));
                patient.setStatus("1");
                patientMapper.insertSelective(patient);
            }else{
                patient = patients.get(0);
            }
            regbed.setStatus(Regbed.UNCHECKED);
            regbed.setPatientid(patient.getId());
            regbedMapper.insertSelective(regbed);
        }
    }
}
