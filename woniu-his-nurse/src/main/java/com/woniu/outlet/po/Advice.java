package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advice {
    private Integer id;
    private Integer patientid;
    private Integer doctorid;
    private String msg;
    private String status;
    private Integer nurseid;
    private Date time;

    public final static String ON = "1"; //生效中
    public final static String OFF = "2"; //已停止
}