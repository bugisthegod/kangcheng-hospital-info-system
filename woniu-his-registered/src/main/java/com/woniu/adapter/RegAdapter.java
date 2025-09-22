package com.woniu.adapter;

import com.woniu.client.PayClient;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.PayVo;
import com.woniu.outlet.dao.PatientMapper;
import com.woniu.outlet.dao.RegMapper;
import com.woniu.outlet.dao.SubjectMapper;
import com.woniu.outlet.po.Patient;
import com.woniu.outlet.po.PatientExample;
import com.woniu.outlet.po.Reg;
import com.woniu.outlet.po.Subject;
import com.woniu.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class RegAdapter {

    @Autowired
    private RegMapper regMapper;
    @Autowired
    private PayClient payClient;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private SubjectMapper subjectMapper;


    public void addReg(Reg reg){
        String token = reg.getToken();
        boolean flag = false;
        try {
            flag = JwtTokenUtil.checkSign(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("token无效或过期");
        }
        if(flag){
            //查询是否有该科室
            Subject subject = subjectMapper.selectByPrimaryKey(reg.getSubjectid());
            if(subject==null){
                throw new ServiceException("没有该科室！");
            }
            //查询是否有该病人
            PatientExample example = new PatientExample();
            example.createCriteria().andIdcardEqualTo(reg.getIdcard());
            List<Patient> patients = patientMapper.selectByExample(example);
            Patient patient = new Patient();
            if(patients.size()==0){
                //添加一个到患者表
                patient.setName(reg.getName());
                patient.setGender(reg.getGender());
                patient.setAge(reg.getAge());
                patient.setIdcard(reg.getIdcard());
                patient.setPhone(reg.getPhone());
                patient.setMoney(new BigDecimal("0"));
                patient.setStatus("1");
                patientMapper.insertSelective(patient);
            }else{
                patient = patients.get(0);
            }
            reg.setStatus(Reg.NOTUSED);
            reg.setPatientid(patient.getId());
            regMapper.insertSelective(reg);

            PayVo payVo = new PayVo();
            payVo.setPatientid(patient.getId());
            payVo.setMsg("挂号");
            payVo.setMoney(new BigDecimal("4.5"));
            //添加收费记录
            payClient.AddPay(payVo);
        }else{
            throw new ServiceException("token错误");
        }
    }
}
