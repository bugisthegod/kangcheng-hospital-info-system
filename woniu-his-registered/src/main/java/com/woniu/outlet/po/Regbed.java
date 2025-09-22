package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regbed {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String idcard;
    private String phone;
    private Integer subjectid;
    private String status;
    private Date intime;
    private Integer patientid;

    private String token;  //校验用

    public final static String UNCHECKED = "1"; //未审核
    public final static String CHECKED = "2"; //已审核
    public final static String IN = "3"; //已入住
}