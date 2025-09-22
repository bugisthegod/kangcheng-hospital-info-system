package com.woniu.adapter;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.outlet.dao.InspectionItemPoMapper;
import com.woniu.outlet.dao.OperationItemPoMapper;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.outlet.po.InspectionItemPoExample;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.outlet.po.OperationItemPoExample;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OperationItemAdapter {

    @Autowired
    private OperationItemPoMapper operationItemPoMapper;

    /**
     * 查询手术项目列表（条件查询按名称和状态）
     * @param
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<OperationItemPo> getOperationItemList(OperationItemPo operationItemPo, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        OperationItemPoExample operationItemPoExample = new OperationItemPoExample();
        OperationItemPoExample.Criteria criteria = operationItemPoExample.createCriteria();
        if(!StringUtils.isEmpty(operationItemPo.getOiName())){
            criteria.andOiNameEqualTo(operationItemPo.getOiName());
        }
        if(!StringUtils.isEmpty(operationItemPo.getOiStatus())){
            criteria.andOiStatusEqualTo(operationItemPo.getOiStatus());
        }
        List<OperationItemPo> operationItemPos = operationItemPoMapper.selectByExample(operationItemPoExample);
        PageInfo<OperationItemPo> operationItemPoPageInfo = new PageInfo<>(operationItemPos);
        return operationItemPoPageInfo;
    }

    /**
     * 根据id查询手术项目
     * @param id
     * @return
     */
    public OperationItemPo getOperationItemById(Integer id){
        return operationItemPoMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加
     * @param operationItemPo
     * @return
     */
    public Integer addOperationItem(OperationItemPo operationItemPo){
        operationItemPo.setOiStatus("y");
        return operationItemPoMapper.insertSelective(operationItemPo);
    }

    /**
     * 修改
     * @param operationItemPo
     * @return
     */
    public Integer updateOperationItem(OperationItemPo operationItemPo){
        return operationItemPoMapper.updateByPrimaryKeySelective(operationItemPo);
    }

    /**
     * 删除（逻辑删除"d"）
     * @param operationItemPo
     * @return
     */
    public Integer deleteOperationItem(OperationItemPo operationItemPo){
        return operationItemPoMapper.updateByPrimaryKeySelective(operationItemPo);
    }
}
