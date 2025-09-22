package com.woniu.outlet.dao;

import com.woniu.outlet.po.Bed;
import com.woniu.outlet.po.BedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface BedMapper {
    long countByExample(BedExample example);

    int deleteByExample(BedExample example);
    int deleteByPrimaryKey(Integer id);

    int insert(Bed record);
    int insertSelective(Bed record);

    List<Bed> selectByExample(BedExample example);
    Bed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bed record, @Param("example") BedExample example);
    int updateByExample(@Param("record") Bed record, @Param("example") BedExample example);
    int updateByPrimaryKeySelective(Bed record);
    int updateByPrimaryKey(Bed record);

    @Select("select hb.* from woniu_his_bed hb,woniu_his_ward hw,woniu_his_subject hs where hb.wardid=hw.id and hw.w_sid=hs.id and hs.id=#{subjectid} and hb.status=0")
    List<Bed> findAbleBeds(Integer subjectid);
}