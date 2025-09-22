package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    private Integer id;
    private Integer patientid;
    private BigDecimal money;
    private String msg;
    private String status;
    private Date time;

    public final static String NOTPAY = "1"; //未支付
    public final static String PAIED = "2"; //已支付
    public final static String OUT = "3"; //未支付，已过期

    public static final String DRUG = "药品";
    public static final String OPERATION = "手术";
    public static final String INSPECT = "检查";
    public static final String REGISTER = "挂号";
}