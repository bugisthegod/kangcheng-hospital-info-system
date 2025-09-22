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
}