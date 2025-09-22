package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InspectionItemPo {
    private Integer id;
    private String iiNo;
    private String iiName;
    private BigDecimal iiPrice;
    private Integer iiSid;
    private String iiSname;
    private String iiStatus;
}