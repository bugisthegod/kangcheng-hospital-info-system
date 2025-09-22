package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bed {
    private Integer id;
    private String no;
    private Integer wardid;
    private String status;
    private Integer patientid;

    public final static String EMPTY = "0"; //空床位
    public final static String FULL = "1"; //床位
    public final static String FORBID = "2"; //禁用
}