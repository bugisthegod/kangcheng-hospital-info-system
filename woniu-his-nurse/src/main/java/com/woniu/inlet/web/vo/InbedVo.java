package com.woniu.inlet.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("病房入住记录")
public class InbedVo {
    @ApiModelProperty(value="id")
    private Integer id;
    @ApiModelProperty(value="患者id")
    private Integer patientid;
    @ApiModelProperty(value="科室id")
    private Integer subjectid;
    @ApiModelProperty(value="病房id")
    private Integer wardid;
    @ApiModelProperty(value="床位id")
    private Integer bedid;
    @ApiModelProperty(value="状态")
    private String status;
    @ApiModelProperty(value="经治医生id")
    private Integer doctorid;
    @ApiModelProperty(value="经治护士id")
    private Integer nurseid;
}
