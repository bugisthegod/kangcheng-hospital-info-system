package com.woniu.outlet.dao;

import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.outlet.po.InspectionItemPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionItemPoMapper {
    long countByExample(InspectionItemPoExample example);

    int deleteByExample(InspectionItemPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InspectionItemPo record);

    int insertSelective(InspectionItemPo record);

    List<InspectionItemPo> selectByExample(InspectionItemPoExample example);

    InspectionItemPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InspectionItemPo record, @Param("example") InspectionItemPoExample example);

    int updateByExample(@Param("record") InspectionItemPo record, @Param("example") InspectionItemPoExample example);

    int updateByPrimaryKeySelective(InspectionItemPo record);

    int updateByPrimaryKey(InspectionItemPo record);
}