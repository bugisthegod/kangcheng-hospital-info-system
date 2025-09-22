package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inbed {
    private Integer id;
    private Integer patientid;
    private Integer subjectid;
    private Integer wardid;
    private Integer bedid;
    private String status;
    private Integer doctorid;
    private Integer nurseid;

    public final static String WAIT = "1";  //等待分配床位
    public final static String IN = "2";  //已分配床位
    public final static String BACK = "3";  //已停止床位
    public final static String OUT = "4";  //已出院

}