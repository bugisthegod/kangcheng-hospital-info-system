package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.prescriptionCommand.*;
import com.woniu.outlet.po.PrescriptionItemPo;
import com.woniu.outlet.po.PrescriptionPo;
import com.woniu.service.handler.PrescriptionCommandHandler;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PrescriptionController {

    @PostMapping("/outpatient/prescription/add")
    @PreAuthorize("hasAuthority('outpatient:addprescription')")
    @ApiOperation("医生开处方单")
    @ApiOperationSupport(ignoreParameters = {"id","psStatus"})
    public ResponseResult<Integer> addPrescription(@RequestBody PrescriptionPo prescriptionPo){
        Integer execute = null;
        try{
        AddPrescriptionCommand command = new AddPrescriptionCommand();
         execute = command.execute(prescriptionPo);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>(execute,"OK",200);
    }

    @PutMapping("/outpatient/prescription/update")
    @PreAuthorize("hasAuthority('outpatient:addprescription')")
    @ApiOperation("修改处方单")
    @ApiOperationSupport(ignoreParameters = {"prescriptionItemPos.psiPrice"})
    public ResponseResult<Integer> updatePrescription(@RequestBody PrescriptionPo prescriptionPo){
        Integer flag = null;
        try{
        UpdatePrescriptionCommand command = new UpdatePrescriptionCommand();
         flag = command.execute(prescriptionPo);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,"OK",999);
        }
        return new ResponseResult<>(flag,"OK",200);
    }

    @GetMapping("/outpatient/prescription/getPreById")
//    @PreAuthorize("hasAuthority('outpatient:list')")
    @ApiOperation("通过id查找处方单")
    public ResponseResult<PrescriptionPo> getPrescription(@NotNull(message = "不能为空") @Positive(message = "必须是一个正整数") Integer id){
        PrescriptionPo prescriptionPo = new PrescriptionPo();
        try{
        GetPrescriptionByIdCommand command = new GetPrescriptionByIdCommand();
         prescriptionPo = command.execute(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>(prescriptionPo,"OK",200);
    }

    @GetMapping("/outpatient/prescription/getPrescriptionItemByPid")
//    @PreAuthorize("hasAuthority('outpatient:list')")
    @ApiOperation("通过处方id查找处方项")
    public ResponseResult<List<PrescriptionItemPo>> getPrescriptionItemByPid(Integer id){
        List<PrescriptionItemPo> prescriptionItemPoList = new ArrayList<>();
        try{
        GetPrescriptionItemCommand command = new GetPrescriptionItemCommand();
        prescriptionItemPoList = command.execute(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,"OK",999);
        }
        return new ResponseResult<>(prescriptionItemPoList,"OK",200);
    }

    @GetMapping("/outpatient/prescription/prescriptionIsPaid")
    @PreAuthorize("hasAuthority('financialPaymentPrescription:list')")
    @ApiOperation("病人支付处方单")
    public ResponseResult<Integer> prescriptionIsPaid(Integer id){ //id是处方表的主键
        Integer execute = null;
        try{
            PrescriptionIsPaidCommand command = new PrescriptionIsPaidCommand();
            execute = command.execute(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,"OK",999);
        }
        return new ResponseResult<>(execute,"OK",200);
    }




}
