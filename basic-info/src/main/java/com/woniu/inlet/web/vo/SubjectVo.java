package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("科室实体类")
public class SubjectVo {
    @ApiModelProperty("主键")
    private Integer id;


    @ApiModelProperty("科室名字")
    @NotEmpty(message = "科室名不能为空")
    private String sName;


    @ApiModelProperty("科室所属部门id")
    @Positive(message = "部门id输入有误")
    @NotNull(message = "部门id不能为空")
    private Integer sDpid;


    @ApiModelProperty("描述")
    private String sDesc;


    @ApiModelProperty(value = "状态")
    @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d")
    private String sStatus;
}