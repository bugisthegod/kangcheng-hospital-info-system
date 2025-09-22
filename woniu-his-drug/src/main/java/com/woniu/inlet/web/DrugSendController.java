package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.drugsendcommand.DeleteDrugSendCommand;
import com.woniu.outlet.po.DrugPo;
import com.woniu.outlet.po.DrugSendPo;
import com.woniu.service.DrugSendService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DrugSendController {

    @Autowired
    private DrugSendService drugSendService;

    @GetMapping("/drugsend/list")
    @PreAuthorize("hasAuthority('drugSend:list')")
    @ApiOperation("药品发放列表")
    @ApiOperationSupport(ignoreParameters = {"drugSendItemPos","id"})
    public ResponseResult<List<DrugSendPo>> getDrugSendPoList(DrugSendPo drugSendPo, Integer pageNum) {
        List<DrugSendPo> drugSendList = new ArrayList<>();
        try {
            drugSendList = drugSendService.getDrugSendList(drugSendPo, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(drugSendList, "系统异常", 999);
        }
        return new ResponseResult<>();
    }

    @DeleteMapping("/drugsend/delete")
    @PreAuthorize("hasAuthority('drugSend:list')")
    @ApiOperation("删除药品发放记录")
    public ResponseResult<Integer> deleteDrugSend(Integer id){
        Integer execute = null;
        try{
            DeleteDrugSendCommand command = new DeleteDrugSendCommand();
            execute = command.execute(id);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>(execute,"OK",200);
    }



}
