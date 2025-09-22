package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("病床实体类")
public class BedVo {
    @ApiModelProperty("主键")
    @Positive(message = "必须为一个正整数")
    private Integer id;

    @ApiModelProperty(value = "编号",hidden = true)
    private String no;

    @ApiModelProperty("病房id")
    @Positive(message = "必须为一个正整数")
    @NotNull(message = "不得为空")
    private Integer wardid;

    @ApiModelProperty("状态")
    @NotEmpty(message = "不得为空")
    private String status;

    @ApiModelProperty("病人id")
    @NotNull(message = "不得为空")
    @Positive(message = "必须为一个正整数")
    private Integer patientid;
}