package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.OperationItemPoMapper;
import com.woniu.outlet.dao.WardPoMapper;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.outlet.po.OperationItemPoExample;
import com.woniu.outlet.po.WardPo;
import com.woniu.outlet.po.WardPoExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class WardAdapter {

    @Autowired
    private WardPoMapper wardPoMapper;

    /**
     * 查询手术项目列表（条件查询按名称和状态）
     * @param wardPo
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<WardPo> getWardList(WardPo wardPo, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        WardPoExample wardPoExample = new WardPoExample();
        WardPoExample.Criteria criteria = wardPoExample.createCriteria();
        if(!StringUtils.isEmpty(wardPo.getWSname())){
            criteria.andWSnameEqualTo(wardPo.getWSname());
        }
        if(!StringUtils.isEmpty(wardPo.getWStatus())){
            criteria.andWStatusEqualTo(wardPo.getWStatus());
        }
        List<WardPo> wardPos = wardPoMapper.selectByExample(wardPoExample);
        PageInfo<WardPo> wardPoPageInfo = new PageInfo<>(wardPos);
        return wardPoPageInfo;
    }

    /**
     * 根据id查询手术项目
     * @param id
     * @return
     */
    public WardPo getWardById(Integer id){
        return wardPoMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加
     * @param wardPo
     * @return
     */
    public Integer addWard(WardPo wardPo){
        wardPo.setWStatus("y");
        return wardPoMapper.insertSelective(wardPo);
    }

    /**
     * 修改
     * @param wardPo
     * @return
     */
    public Integer updateWard(WardPo wardPo){
        return wardPoMapper.updateByPrimaryKeySelective(wardPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param wardPo
     * @return
     */
    public Integer deleteWard(WardPo wardPo){
        return wardPoMapper.updateByPrimaryKeySelective(wardPo);
    }
}
