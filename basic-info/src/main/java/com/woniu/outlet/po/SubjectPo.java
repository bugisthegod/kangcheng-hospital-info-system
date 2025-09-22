package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectPo {
    private Integer id;
    private String sName;
    private Integer sDpid;
    private String sDesc;
    private String sStatus;
}