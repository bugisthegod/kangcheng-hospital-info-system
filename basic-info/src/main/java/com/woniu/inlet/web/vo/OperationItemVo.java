package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("手术项目实体类")
public class OperationItemVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty(value ="编号",hidden = true)
    private String oiNo;

    @ApiModelProperty("手术项目名字")
    @NotEmpty(message = "手术项目名不能为空")
    private String oiName;

    @ApiModelProperty("手术费用")
    @NotNull(message = "手术费用不能为空")
    @Min(value = 0,message = "手术费用只能是正数")
    private BigDecimal oiSurgerycost;

    @ApiModelProperty(value = "人工费用",hidden = true)
    private BigDecimal oiLaborcost;

    @ApiModelProperty(value = "手术项目所属科室id",hidden = true)
    private Integer oiSid;

    @ApiModelProperty(value = "手术项目所属科室名字",hidden = true)
    private String oiSname;

    @ApiModelProperty(value = "状态")
    @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d")
    private String oiStatus;
}