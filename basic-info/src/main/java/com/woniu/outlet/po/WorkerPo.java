package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerPo {
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

    public static final String NORMAL= "1"; //正常
    public static final String DISABLE= "2"; //禁用
    public static final String QUIT= "3"; //员工离职,账号失效
}