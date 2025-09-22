package com.woniu.outlet.po;

import com.woniu.validate.DrugAdd;
import com.woniu.validate.DrugUpdate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("药品实体类")
public class DrugPo {

    @ApiModelProperty("主键")
    @Positive(message = "必须为一个正整数")
    private Integer id;

    @ApiModelProperty(value = "药品编号",hidden = true)
    private String no;

    @ApiModelProperty("药品名字")
    @NotEmpty(message = "不能为空",groups = {DrugAdd.class})
    private String name;

    @ApiModelProperty("药品品牌")
    @NotEmpty(message = "不能为空",groups = {DrugAdd.class})
    private String brand;

    @ApiModelProperty("进价")
    @NotNull(message = "不能为空",groups = {DrugAdd.class})
    @DecimalMin(value = "0.01",message = "进价必须大于0.01",groups = {DrugAdd.class,DrugUpdate.class})
    private BigDecimal inprice;

    @ApiModelProperty("售价")
    @NotNull(message = "不能为空",groups = {DrugAdd.class})
    @DecimalMin(value = "0.01",message = "售价必须大于0.01",groups = {DrugAdd.class, DrugUpdate.class})
    private BigDecimal outprice;

    @ApiModelProperty("库存")
    @NotNull(message = "不能为空",groups = {DrugAdd.class})
    @Positive(message = "必须为一个正整数")
    private Integer stock;

    @ApiModelProperty(value = "库存最小值警告",hidden = true)
    private Integer lower;

    @ApiModelProperty("是否上架y/n")
    @NotEmpty(message = "不能为空",groups = {DrugAdd.class})
    private String status;

    @ApiModelProperty("是否处方药y/n")
    @NotEmpty(message = "不能为空",groups = {DrugAdd.class})
    private String isprescription;

}