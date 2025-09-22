package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("病房实体类")
public class WardVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty(value = "病房编号",hidden = true)
    private String wNo;

    @ApiModelProperty(value = "病房等级",hidden = true)
    private String wLevel;

    @ApiModelProperty(value = "病房所属区域",hidden = true)
    private String wArea;

    @ApiModelProperty(value = "病房费用/单位:日",hidden = true)
    private BigDecimal wPrice;

    @ApiModelProperty(value = "数量",hidden = true)
    private Integer wNum;

    @ApiModelProperty(value = "病房所属科室id")
    @Positive
    @NotNull(message = "病房所属科室id不能为空")
    private Integer wSid;

    @ApiModelProperty(value = "病房所属科室名字",hidden = true)
    private String wSname;

    @ApiModelProperty("状态")
    @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d")
    private String wStatus;
}