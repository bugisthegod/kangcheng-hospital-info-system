package com.woniu.outlet.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("药品实体类")
public class DrugPo {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty(value = "药品编号",hidden = true)
    private String no;

    @ApiModelProperty("药品名字")
    private String name;

    @ApiModelProperty("药品品牌")
    private String brand;

    @ApiModelProperty("进价")
    private BigDecimal inprice;

    @ApiModelProperty("售价")
    private BigDecimal outprice;

    @ApiModelProperty("库存")
    private Integer stock;

    @ApiModelProperty(value = "库存最小值警告",hidden = true)
    private Integer lower;

    @ApiModelProperty("是否上架y/n")
    private String status;

    @ApiModelProperty("是否处方药y/n")
    private String isprescription;

}