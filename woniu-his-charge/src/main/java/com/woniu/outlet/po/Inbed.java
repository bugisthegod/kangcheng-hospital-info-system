package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inbed {
    private Integer id;
    private Integer patientid;
    private Integer subjectid;
    private Integer wardid;
    private Integer bedid;
    private String status;
    private Integer doctorid;
    private Integer nurseid;
}