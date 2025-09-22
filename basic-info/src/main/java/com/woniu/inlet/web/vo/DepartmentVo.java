package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("部门实体类")
public class DepartmentVo {

    @ApiModelProperty("主键")
    @Positive(message = "必须是一个正整数")
    private Integer id;

    @ApiModelProperty("部门名字")
    @NotEmpty(message = "不得为空")
    private String dpName;

    @ApiModelProperty("描述")
    @NotEmpty(message = "不得为空")
    private String dpDesc;

    @ApiModelProperty("部门状态")
    private String dpStatus;
}