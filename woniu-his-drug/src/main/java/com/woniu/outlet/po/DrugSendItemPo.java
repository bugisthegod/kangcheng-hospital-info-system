package com.woniu.outlet.po;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugSendItemPo {
    private Integer id;

    private Integer ddDrugid;

    private String ddDrugname;

    private Integer ddDrugnum;

    private BigDecimal ddPrice;

    private Integer ddDrugsendid;

}