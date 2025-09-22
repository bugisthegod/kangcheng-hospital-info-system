package com.woniu.inlet.web.vo;

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
@ApiModel("器材实体类")
public class EquipmentVo {

    @ApiModelProperty("主键")
    @Positive(message = "必须是个正整数")
    private Integer id;

    @ApiModelProperty(value = "器材编号",hidden = true)
    private String eqNo;

    @ApiModelProperty("器材名称")
    @NotEmpty(message = "必须不为空")
    private String eqName;

    @ApiModelProperty("价格")
    @NotEmpty(message = "不得为空")
    @DecimalMin(value = "0",message = "检查项目价格必须大于0")
    private BigDecimal eqPrice;

    @ApiModelProperty("数量")
    @Positive(message = "必须是个正整数")
    private Integer eqNum;

    @ApiModelProperty("器材所属部门id")
    @Positive(message = "必须是个正整数")
    @NotNull(message = "不能为空")
    private Integer eqSid;

    @ApiModelProperty(value = "器材所属部门名字",hidden = true)
    @NotEmpty(message = "不得为空")
    private String eqSname;

    @ApiModelProperty("器材状态")
    private String eqStatus;
}