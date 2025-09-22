package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker {
    private Integer id;
    private String wAccount;
    private String wPassword;
    private String wCard;
    private Integer wDpid;
    private Integer wSid;
    private Integer wAge;
    private String wGender;
    private String wName;
    private String wPhone;
    private String wEmail;
    private BigDecimal wSalary;
    private String wSalt;
    private String wStatus;
    private Integer wRoleid;

    public final static Integer LEADER = 1; //院长
    public final static Integer IN_DOCTOR = 2; //住院医生
    public final static Integer IN_NURSE = 3; //住院护理护士
    public final static Integer IN_FRONT_NURSE = 4; //住院前台护士
    public final static Integer FRONT_DOCTOR = 5; //门诊医生
    public final static Integer FINANCIAL_STAFF = 6; //财务职员
    public final static Integer PHARMACIST = 7; //药师
}