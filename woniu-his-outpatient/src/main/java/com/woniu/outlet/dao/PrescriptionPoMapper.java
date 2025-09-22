package com.woniu.outlet.dao;

import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.outlet.po.PrescriptionPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PrescriptionPoMapper {
    long countByExample(PrescriptionPoExample example);

    int deleteByExample(PrescriptionPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PrescriptionPo record);

    int insertSelective(PrescriptionPo record);

    List<PrescriptionPo> selectByExample(PrescriptionPoExample example);

    PrescriptionPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PrescriptionPo record, @Param("example") PrescriptionPoExample example);

    int updateByExample(@Param("record") PrescriptionPo record, @Param("example") PrescriptionPoExample example);

    int updateByPrimaryKeySelective(PrescriptionPo record);

    int updateByPrimaryKey(PrescriptionPo record);
}