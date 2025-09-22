package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("挂号记录表")
public class RegVo {
    @ApiModelProperty("id")
    private Integer id;

    @NotNull(message = "姓名不能为空")
    @ApiModelProperty("姓名")
    private String name;

    @NotNull(message = "性别不能为空")
    @Pattern(regexp = "^[0-1]*$",message = "性别输入有误")
    @ApiModelProperty("性别 0男 1女")
    private String gender;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0,message = "年龄输入有误")
    @Max(value = 200,message = "年龄输入有误")
    @ApiModelProperty("年龄")
    private Integer age;

    @NotNull(message = "身份证号不能为空")
    @Length(min = 18,max = 18,message = "身份证号格式有误")
    @ApiModelProperty("身份证号")
    private String idcard;

    @NotNull(message = "电话号码不能为空")
    @Length(min = 11,max = 11,message = "电话号码格式有误")
    @ApiModelProperty("电话")
    private String phone;

    @NotNull(message = "科室id不能为空")
    @Min(value = 0,message = "科室id输入有误")
    @ApiModelProperty("科室id")
    private Integer subjectid;

    @Future
    @ApiModelProperty("挂号时间")
    private Date time;

    @ApiModelProperty("状态")
    private String status;

}
