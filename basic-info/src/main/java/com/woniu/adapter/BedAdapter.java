package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.exception.ServiceException;
import com.woniu.outlet.dao.BedMapper;
import com.woniu.outlet.dao.OperationItemPoMapper;
import com.woniu.outlet.po.BedExample;
import com.woniu.outlet.po.BedPo;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.outlet.po.OperationItemPoExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class BedAdapter {

    @Autowired
    private BedMapper bedMapper;

    /**
     * 查询手术项目列表（条件查询按名称和状态）
     * @param bedPo
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<BedPo> getBedList(BedPo bedPo, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        BedExample bedExample = new BedExample();
        BedExample.Criteria criteria = bedExample.createCriteria();
        if(!StringUtils.isEmpty(bedPo.getStatus())){
            criteria.andStatusEqualTo(bedPo.getStatus());
        }
        List<BedPo> bedPos = bedMapper.selectByExample(bedExample);
        PageInfo<BedPo> bedPoPageInfo = new PageInfo<>(bedPos);
        return bedPoPageInfo;
    }

    /**
     * 根据id查询手术项目
     * @param id
     * @return
     */
    public BedPo getBedById(Integer id){
        return bedMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加
     * @param bedPo
     * @return
     */
    public Integer addBed(BedPo bedPo){
        return bedMapper.insertSelective(bedPo);
    }

    /**
     * 修改
     * @param bedPo
     * @return
     */
    public Integer updateBed(BedPo bedPo){
        BedExample example = new BedExample();
        BedExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(bedPo.getId());
        List<BedPo> bedPos = bedMapper.selectByExample(example);
        if(bedPos.size()==0){
            throw new ServiceException("床位不存在,无法修改");
        }
        return bedMapper.updateByPrimaryKeySelective(bedPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param bedPo
     * @return
     */
    public Integer deleteBed(BedPo bedPo){
        return bedMapper.updateByPrimaryKeySelective(bedPo);
    }
}
