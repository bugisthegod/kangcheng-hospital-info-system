package com.woniu.outlet.po;

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
@ApiModel("药品发放单实体类")
public class DrugSendPo {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty(value = "编号",hidden = true)
    private String dsNo;
    @ApiModelProperty("病人id")
    private Integer dsPatientid;
    @ApiModelProperty(value = "病人姓名",hidden = true)
    private String dsPatientname;
    @ApiModelProperty("费用总额")
    private BigDecimal dsTotal;
    @ApiModelProperty(value = "操作时间",hidden = true)
    private Date dsDate;
    @ApiModelProperty("状态")
    private String dsStatus;

    @ApiModelProperty(value = "药品发放订单项",hidden = true)
    List<DrugSendItemPo> drugSendItemPos;

    public static final String PAID = "1";
    public static final String DELETED = "D";

}