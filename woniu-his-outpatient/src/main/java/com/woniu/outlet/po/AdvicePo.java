package com.woniu.outlet.po;

import com.fasterxml.jackson.annotation.JsonFilter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("门诊/住院医嘱表实体类")
public class AdvicePo {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty("病人id")
    @NotNull(message = "不能为空")
    @Positive(message = "必须为一个正整数")
    private Integer patientid;

    @ApiModelProperty("医生id")
    @NotNull(message = "不能为空")
    @Positive(message = "必须为一个正整数")
    private Integer doctorid;

    @ApiModelProperty("医嘱描述")
    private String msg;

    @ApiModelProperty(value = "状态",hidden = true)
    private String status;

    @ApiModelProperty(value = "护士id",hidden = true)
    private Integer nurseid;

    @ApiModelProperty(value = "操作时间",hidden = true)
    private Date time;

    public static final String ON = "0"; //进行中
    public static final String OFF = "1"; //已停止

}