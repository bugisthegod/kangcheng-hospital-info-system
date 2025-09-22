package com.woniu.inlet.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("预交费记录")
public class DepositVo {
    @ApiModelProperty(value="id")
    private Integer id;

    @NotNull(message = "患者id不能为空")
    @Min(value = 0,message = "患者id输入有误")
    @ApiModelProperty("患者id")
    private Integer patientid;

    @NotNull(message = "预缴金额不能为空")
    @Min(value = 1,message = "预缴金额应为正数")
    @ApiModelProperty("预缴金额")
    private BigDecimal money;


    @ApiModelProperty(value="时间")
    private Date time;

}
