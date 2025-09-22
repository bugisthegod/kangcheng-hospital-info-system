package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.drugcommand.AddDrugCommand;
import com.woniu.command.drugcommand.DeleteDrugCommand;
import com.woniu.command.drugcommand.GetDrugByIdCommand;
import com.woniu.command.drugcommand.UpdateDrugCommand;
import com.woniu.outlet.po.DrugPo;
import com.woniu.service.DrugService;
import com.woniu.utils.ResponseResult;
import com.woniu.validate.DrugAdd;
import com.woniu.validate.DrugUpdate;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
public class   DrugController {

    @Autowired
    public DrugService drugService;

    @GetMapping("/drug/list")
    @PreAuthorize("hasAuthority('drug:list')")
    @ApiOperation("分页查询药品")
    @ApiOperationSupport(ignoreParameters = {"id","inprice","outprice","stock","lower"})
    public ResponseResult<List<DrugPo>> getDrugList(@Validated DrugPo drugPo,@RequestParam(defaultValue = "1")@Positive(message = "必须为一个正整数") Integer pageNum){
        List<DrugPo> drugList = new ArrayList<>();
        try{
             drugList = drugService.getDrugList(drugPo, pageNum);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>(drugList,"OK",200);

    }

    @PutMapping("/drug/update")
    @PreAuthorize("hasAuthority('drug:update')")
    @ApiOperation("修改药品")
    public ResponseResult<Integer> updateDrug(@Validated({DrugUpdate.class})@RequestBody DrugPo drugPo){
            Integer flag =null;
        try{
            UpdateDrugCommand command = new UpdateDrugCommand();
            flag = command.execute(drugPo);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,e.getMessage(),999);
        }

        return new ResponseResult<>(flag,"OK",200);
    }

    @PostMapping("/drug/add")
    @PreAuthorize("hasAuthority('drug:add')")
    @ApiOperation("添加药品")
    @ApiOperationSupport(ignoreParameters = {"id"})
    public ResponseResult<Integer> addDrug(@Validated({DrugAdd.class}) DrugPo drugPo){
        Integer flag =null;
        try{
        AddDrugCommand command = new AddDrugCommand();
         flag = command.execute(drugPo);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>(flag,"OK",200);
    }

    @GetMapping("/drug/delete")
    @PreAuthorize("hasAuthority('drug:delete')")
    @ApiOperation("删除药品")
    public ResponseResult<Integer> deleteDrug( @Positive(message = "必须为一个正整数") @NotNull(message = "不得为空") Integer id){
        Integer flag =null;
        try{
            DeleteDrugCommand command = new DeleteDrugCommand();
             flag = command.execute(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>(flag,"OK",200);
    }

    @GetMapping("/drug/getDrugById")
//    @PreAuthorize("hasAuthority('drug:list')")
    @ApiOperation("通过id查询药品")
    public ResponseResult<DrugPo> getDrugById(@Positive(message = "必须为一个正整数") @NotNull(message = "不得为空") Integer id){
        DrugPo drugPo = new DrugPo();
        try{
        GetDrugByIdCommand command = new GetDrugByIdCommand();
         drugPo = command.execute(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>(drugPo,"OK",200);
    }


}
