package com.woniu.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerVo {
    private Integer id;

    private Integer wDpid;
    private Integer wSid;
    private Integer wAge;
    private String wGender;
    private String wName;
    private String wPhone;
    private String wEmail;

    private Integer wRoleid;
}
