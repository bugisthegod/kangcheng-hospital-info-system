package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.InspectionItemPoMapper;
import com.woniu.outlet.po.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class InspectionItemAdapter {

    @Autowired
    private InspectionItemPoMapper inspectionItemPoMapper;

    /**
     * 查询检查项目列表（条件查询按名称和状态）
     * @param inspectionItemPo
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<InspectionItemPo> getInspectionItemList(InspectionItemPo inspectionItemPo,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        InspectionItemPoExample inspectionItemPoExample = new InspectionItemPoExample();
        InspectionItemPoExample.Criteria criteria = inspectionItemPoExample.createCriteria();
        if(!StringUtils.isEmpty(inspectionItemPo.getIiName())){
            criteria.andIiNameEqualTo(inspectionItemPo.getIiName());
        }
        if(!StringUtils.isEmpty(inspectionItemPo.getIiStatus())){
            criteria.andIiStatusEqualTo(inspectionItemPo.getIiStatus());
        }
        List<InspectionItemPo> inspectionItemPos = inspectionItemPoMapper.selectByExample(inspectionItemPoExample);
        PageInfo<InspectionItemPo> inspectionItemPoPageInfo = new PageInfo<>(inspectionItemPos);
        return inspectionItemPoPageInfo;
    }

    /**
     * 根据id查询检查项目
     * @param id
     * @return
     */
    public InspectionItemPo getInspectionItemById(Integer id){
        return inspectionItemPoMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加
     * @param inspectionItemPo
     * @return
     */
    public Integer addInspectionItem(InspectionItemPo inspectionItemPo){
        InspectionItemPoExample example = new InspectionItemPoExample();
        InspectionItemPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(inspectionItemPo.getId());
        List<InspectionItemPo> inspectionItemPos = inspectionItemPoMapper.selectByExample(example);
        if(inspectionItemPos.size()==0){
            throw new RuntimeException("检查项目不存在,无法修改");
        }
        return inspectionItemPoMapper.insertSelective(inspectionItemPo);
    }

    /**
     * 修改
     * @param inspectionItemPo
     * @return
     */
    public Integer updateInspectionItem(InspectionItemPo inspectionItemPo){
        return inspectionItemPoMapper.updateByPrimaryKeySelective(inspectionItemPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param inspectionItemPo
     * @return
     */
    public Integer deleteInspectionItem(InspectionItemPo inspectionItemPo){
        return inspectionItemPoMapper.updateByPrimaryKeySelective(inspectionItemPo);
    }
}
