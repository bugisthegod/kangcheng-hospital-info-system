package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentPo {
    private Integer id;
    private String dpName;
    private String dpDesc;
    private String dpStatus;
}