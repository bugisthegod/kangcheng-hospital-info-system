package com.woniu.outlet.dao;

import com.woniu.outlet.po.PrescriptionItemPo;
import com.woniu.outlet.po.PrescriptionItemPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionItemPoMapper {
    long countByExample(PrescriptionItemPoExample example);

    int deleteByExample(PrescriptionItemPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrescriptionItemPo record);

    int insertSelective(PrescriptionItemPo record);

    List<PrescriptionItemPo> selectByExample(PrescriptionItemPoExample example);

    PrescriptionItemPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrescriptionItemPo record, @Param("example") PrescriptionItemPoExample example);

    int updateByExample(@Param("record") PrescriptionItemPo record, @Param("example") PrescriptionItemPoExample example);

    int updateByPrimaryKeySelective(PrescriptionItemPo record);

    int updateByPrimaryKey(PrescriptionItemPo record);
}