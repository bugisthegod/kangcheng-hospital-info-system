package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationItemPo {
    private Integer id;
    private String oiNo;
    private String oiName;
    private BigDecimal oiSurgerycost;
    private BigDecimal oiLaborcost;
    private Integer oiSid;
    private String oiSname;
    private String oiStatus;
}