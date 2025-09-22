package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentPo {
    private Integer id;
    private String eqNo;
    private String eqName;
    private BigDecimal eqPrice;
    private Integer eqNum;
    private Integer eqSid;
    private String eqSname;
    private String eqStatus;
}