package com.woniu.inlet.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("缴费记录")
public class PayVo {
    @ApiModelProperty("id")
    private Integer id;

    @NotNull(message = "患者id不能为空")
    @Positive(message = "患者id输入有误")
    @ApiModelProperty("患者id")
    private Integer patientid;

    @NotNull(message = "金额不能为空")
    @Min(value = 1,message = "金额应为正数")
    @ApiModelProperty("金额")
    private BigDecimal money;

    @NotEmpty(message = "缴费用途不能为空")
    @ApiModelProperty("备注（用途）")
    private String msg;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("时间")
    private Date time;

}
