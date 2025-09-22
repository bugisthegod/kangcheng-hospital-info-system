package com.woniu.inlet.web.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("检查项目实体类")
public class InspectionItemVo {

    @ApiModelProperty("主键")
    @Positive(message = "必须是一个正整数")
    private Integer id;

    @ApiModelProperty(value = "检查项目编号",hidden = true)
    private String iiNo;

    @ApiModelProperty("检查项目名字")
    @NotEmpty(message = "不得为空")
    private String iiName;

    @ApiModelProperty("检查项目价格")
    @NotEmpty(message = "不得为空")
    @DecimalMin(value = "0",message = "检查项目价格必须大于0")
    private BigDecimal iiPrice;

    @ApiModelProperty("检查项目科室id")
    @Positive(message = "必须是一个正整数")
    @NotNull(message = "不得为空")
    private Integer iiSid;

    @ApiModelProperty(value = "检查项目科室名字",hidden = true)
    private String iiSname;

    @ApiModelProperty("状态")
    private String iiStatus;
}