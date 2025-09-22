package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nursing {
    private Integer id;
    private Integer patientid;
    private Integer nurseid;
    private String msg;
    private Date time;
    private String status;


    public final static String END = "1"; //已完成
    public final static String DELETED = "2"; //已删除
}