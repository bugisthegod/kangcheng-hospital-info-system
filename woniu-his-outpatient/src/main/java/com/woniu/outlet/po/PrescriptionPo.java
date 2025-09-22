package com.woniu.outlet.po;

import com.woniu.service.impl.PrescriptionServiceImpl;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("处方单实体类")
public class PrescriptionPo {
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "处方单编号",hidden = true)
    private String psNo;

    @ApiModelProperty(value = "病人id")
    private Integer psPatientid;

    @ApiModelProperty(value = "医生id")
    private Integer psDoctorid;

    @ApiModelProperty(value = "总价格",hidden = true)
    private BigDecimal psTotal;

    @ApiModelProperty(value = "操作时间",hidden = true)
    private Date psDate;

    @ApiModelProperty(value = "状态")
    private String psStatus;

    @ApiModelProperty("处方项")
    private List<PrescriptionItemPo> prescriptionItemPos;

    public static final String UNPAID = "1"; //未支付
    public static final String PAID = "2"; //已支付
    public static final String OVERDUE = "3"; //未支付过期
    public static final String DELETED = "0"; //被逻辑删除


}