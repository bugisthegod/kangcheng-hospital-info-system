package com.woniu.outlet.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("处方单项实体类")
public class PrescriptionItemPo {
    @ApiModelProperty(value = "主键",hidden = true)
    private Integer id;

    @ApiModelProperty("药品id")
    private Integer psiDrugid;

    @ApiModelProperty(value = "药品名字",hidden = true)
    private String psiDrugname;

    @ApiModelProperty("数量")
    private Integer psiNum;

    @ApiModelProperty(value = "价格",hidden = true)
    private BigDecimal psiPrice;

    @ApiModelProperty(value = "处方单id",hidden = true)
    private Integer psiPsid;

}