package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BedPo {
    private Integer id;
    private String no;
    private Integer wardid;
    private String status;
    private Integer patientid;
}