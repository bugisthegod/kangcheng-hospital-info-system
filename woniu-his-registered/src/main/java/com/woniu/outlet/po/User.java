package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String phone;
    private String password;
    private String status;

    public final static String NOTACTIVE = "1"; //未激活
    public final static String ABLED = "2"; //可用
    public final static String DISABLED = "3"; //禁用
}