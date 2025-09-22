package com.woniu.inlet.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegbedVo {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String idcard;
    private String phone;
    private Integer subjectid;
    private String status;
    private Date intime;
    private Integer patientid;

}
