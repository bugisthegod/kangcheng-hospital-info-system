package com.woniu.outlet.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

}
