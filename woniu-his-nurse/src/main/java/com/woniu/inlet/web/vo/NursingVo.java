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
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("护理记录")
public class NursingVo {
    @ApiModelProperty(value="id")
    private Integer id;

    @NotNull(message = "患者id不能为空")
    @Positive(message = "患者id输入有误")
    @ApiModelProperty(value="患者id")
    private Integer patientid;

    @NotNull(message = "护士id不能为空")
    @Positive(message = "护士id输入有误")
    @ApiModelProperty(value="护士id")
    private Integer nurseid;

    @NotEmpty(message = "护理信息不能为空")
    @ApiModelProperty(value="护理信息")
    private String msg;


    @ApiModelProperty(value="时间",hidden = true)
    private Date time;

    @Pattern(regexp = "^2|1$",message = "状态输入有误 1已完成 2已删除")
    @ApiModelProperty(value="状态 1已完成 2已删除")
    private String status;


}
