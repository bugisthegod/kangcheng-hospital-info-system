package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WardPo {
    private Integer id;
    private String wNo;
    private String wLevel;
    private String wArea;
    private BigDecimal wPrice;
    private Integer wNum;
    private Integer wSid;
    private String wSname;
    private String wStatus;
}