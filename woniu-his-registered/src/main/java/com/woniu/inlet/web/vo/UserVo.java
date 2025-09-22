package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("挂号系统用户表")
public class UserVo {
    @ApiModelProperty("id")
    private Integer id;

    @NotNull(message = "电话号码不能为空！")
    @Length(min = 11,max = 11,message = "电话号码长度有误")
    @ApiModelProperty("电话号码")
    private String phone;

    @NotNull(message = "密码不能为空！")
    @Length(min = 3,max = 8,message = "密码长度在3位到8位！")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("状态")
    private String status;

}
