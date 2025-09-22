package com.woniu.inlet.web.vo;

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
@ApiModel("缴费记录")
public class PayVo {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("患者id")
    private Integer patientid;
    @ApiModelProperty("金额")
    private BigDecimal money;
    @ApiModelProperty("备注（用途）")
    private String msg;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("时间")
    private Date time;

}
