package com.woniu.adapter;

import com.woniu.client.PayClient;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.PayVo;
import com.woniu.outlet.dao.AdviceMapper;
import com.woniu.outlet.dao.BedMapper;
import com.woniu.outlet.dao.InbedMapper;
import com.woniu.outlet.dao.RegbedMapper;
import com.woniu.outlet.po.*;
import com.woniu.utils.ResponseResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class InbedAdapter {

    @Autowired
    private InbedMapper inbedMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    @Qualifier("pay1")
    private PayClient payClient;

    @Autowired
    private AdviceMapper adviceMapper;

    @Autowired
    private RegbedMapper regbedMapper;



    public void addInbed(Integer regbedid){
        Regbed regbed = regbedMapper.selectByPrimaryKey(regbedid);
        if(regbed==null){
            throw new ServiceException("没有该条预约记录");
        }
        if(regbed.getStatus().equals(Regbed.UNCHECKED)){
            throw new ServiceException("该预约记录未通过审核");
        }
        //预约信息改成已入住
        regbed.setStatus(Regbed.IN);
        regbedMapper.updateByPrimaryKeySelective(regbed);
        //添加一条入院信息
        Inbed inbed = new Inbed();
        inbed.setPatientid(regbed.getPatientid());
        inbed.setSubjectid(regbed.getSubjectid());
        inbed.setStatus(Inbed.WAIT);
        inbedMapper.insertSelective(inbed);
    }

    public void allotInbed(Integer inbedid,Integer bedid){
        Bed bed = bedMapper.selectByPrimaryKey(bedid);
        if(bed.getStatus().equals(Bed.FULL)){
            throw new ServiceException("该床位有人入住");
        }
        // InbedExample example = new InbedExample();
        // InbedExample.Criteria criteria = example.createCriteria();
        // criteria.andPatientidEqualTo(patientid);
        // List<Inbed> inbeds = inbedMapper.selectByExample(example);
        // if(inbeds.size()==0){
        //     throw new ServiceException("该病人未办理入院登记");
        // }
        Inbed inbed = inbedMapper.selectByPrimaryKey(inbedid);
        if(inbed.getBedid()!=null){
            throw new ServiceException("该病人已有床位");
        }
        inbed.setWardid(bed.getWardid());
        inbed.setBedid(bedid);
        inbed.setStatus(Inbed.IN);
        //分配床位
        inbedMapper.updateByPrimaryKeySelective(inbed);
        //床位状态修改
        bed.setStatus(Bed.FULL);
        bed.setPatientid(inbed.getPatientid());
        bedMapper.updateByPrimaryKeySelective(bed);
    }

    public void recycleBed(Integer inbedid){
        // InbedExample example = new InbedExample();
        // InbedExample.Criteria criteria = example.createCriteria();
        // criteria.andPatientidEqualTo(patientid);
        // List<Inbed> inbeds = inbedMapper.selectByExample(example);
        // if(inbeds.size()==0){
        //     throw new ServiceException("该病人未办理入院登记");
        // }
        Inbed inbed = inbedMapper.selectByPrimaryKey(inbedid);
        Integer bedid = inbed.getBedid();
        if(bedid == null){
            throw new ServiceException("该病人未分配床位");
        }
        //停止病人床位
        inbed.setStatus(Inbed.BACK);
        inbed.setWardid(null);
        inbed.setBedid(null);
        inbedMapper.updateByPrimaryKey(inbed);
        //床位的状态修改
        Bed bed = bedMapper.selectByPrimaryKey(bedid);
        bed.setStatus(Bed.EMPTY);
        bed.setPatientid(null);
        bedMapper.updateByPrimaryKey(bed);
    }

    public void allotWorker(Integer inbedid,Integer doctorid,Integer nurseid){
        if(doctorid==null&&nurseid==null){
            throw new ServiceException("请至少填写一项指派");
        }
        Inbed inbed = inbedMapper.selectByPrimaryKey(inbedid);

        if(inbed.getDoctorid()!=null){
            if(doctorid!=null){
                if(inbed.getDoctorid()==doctorid){
                    throw new ServiceException("请勿重复指派医生");
                }
            }
        }
        inbed.setDoctorid(doctorid);

        if(inbed.getNurseid()!=null){
            if(nurseid!=null){
                if(inbed.getNurseid()==nurseid){
                    throw new ServiceException("请勿重复指派护士");
                }
            }
        }
        inbed.setNurseid(nurseid);

        inbedMapper.updateByPrimaryKeySelective(inbed);
    }

    public BigDecimal outHospitalSettle(Integer inbedid){
        Inbed inbed = inbedMapper.selectByPrimaryKey(inbedid);
        //先停止医嘱
        AdviceExample example = new AdviceExample();
        example.createCriteria().andPatientidEqualTo(inbed.getPatientid());
        List<Advice> advices = adviceMapper.selectByExample(example);
        if(advices.size()>0){
            for (Advice advice : advices) {
                advice.setStatus(Advice.OFF);
                adviceMapper.updateByPrimaryKeySelective(advice);
            }
        }
        //费用结算
        Integer patientid = inbed.getPatientid();
        ResponseResult<List<PayVo>> res = payClient.findPatientPays(patientid);
        if(res.getStatus()!=200){
            throw new ServiceException("系统异常");
        }
        List<PayVo> patientPayVos = res.getData();
        //List<Pay> pays = new ArrayList<>();
        BigDecimal cost = new BigDecimal("0");
        if(patientPayVos.size()>0){
            // Pay pay = new Pay();
            // for (PayVo payVo : patientPayVos) {
            //     BeanUtils.copyProperties(payVo,pay);
            //     pays.add(pay);
            // }
            for (PayVo payVo : patientPayVos) {
                cost = cost.add(payVo.getMoney());
            }
        }
        return cost;
    }


    public void outHospital(Integer inbedid){
        Inbed inbed = new Inbed();
        inbed.setId(inbedid);
        inbed.setStatus(Inbed.OUT);
        inbedMapper.updateByPrimaryKeySelective(inbed);
    }

    public List<Inbed> findWaitInbed(){
        InbedExample example = new InbedExample();
        example.createCriteria().andStatusEqualTo(Inbed.WAIT);
        return inbedMapper.selectByExample(example);
    }
}
