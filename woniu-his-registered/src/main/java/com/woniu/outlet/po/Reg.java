package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reg {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String idcard;
    private String phone;
    private Integer subjectid;
    private Date time;
    private String status;
    private Integer patientid;

    private String token; //用于校验

    public final static String NOTUSED = "1"; //未使用
    public final static String USED = "2"; //已使用
    public final static String BACKED = "3"; //退号
}