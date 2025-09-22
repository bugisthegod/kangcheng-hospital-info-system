package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("员工实体类")
public class WorkerVo {
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("账号")
    @NotNull
    @Length(min = 3,max = 20,message = "账户长度有误")
    private String wAccount;

    @ApiModelProperty("员工身份证id")
    @NotNull
    @Length(min = 18,max = 18)
    private String wCard;

    @ApiModelProperty("员工部门id")
    private Integer wDpid;

    @ApiModelProperty("员工科室id")
    private Integer wSid;

    @ApiModelProperty("年龄")
    private Integer wAge;

    @ApiModelProperty("性别")
    @Pattern(regexp = "^0|1$",message = "性别错误")
    private String wGender;

    @ApiModelProperty("员工姓名")
    @NotNull
    private String wName;

    @ApiModelProperty("员工电话")
    private String wPhone;

    @ApiModelProperty("员工邮箱")
    @Email
    private String wEmail;

    @ApiModelProperty("员工薪资")
    private BigDecimal wSalary;

    @ApiModelProperty("状态")
    @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d")
    private String wStatus;

    @ApiModelProperty("角色id")
    @Positive
    private Integer wRoleid;

}
