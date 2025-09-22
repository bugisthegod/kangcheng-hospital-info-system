package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.paycommand.AddPayCommand;
import com.woniu.command.paycommand.PayOutCommand;
import com.woniu.command.paycommand.PayforCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.vo.PayVo;
import com.woniu.outlet.po.Pay;
import com.woniu.service.PayService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class PayController {

    @Autowired
    private PayService payService;

    @PostMapping("/charge/pay/add")
    @ApiOperation("添加付费记录")
    @ApiOperationSupport(ignoreParameters = {"id","time","status"})
    //@PreAuthorize("hasAuthority('financialPayment:manager')")
    public ResponseResult<String> AddPay(@RequestBody @Validated PayVo payVo){
        try {
            Pay pay = new Pay();
            AddPayCommand command = new AddPayCommand();
            BeanUtils.copyProperties(payVo,pay);
            command.handle(pay);
            return new ResponseResult<>(200,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

    @GetMapping("/charge/pay/payfor")
    @ApiOperation("付款")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "payid",value ="付款记录id",dataType ="int"),
    })
    //@PreAuthorize("hasAuthority('financialPayment:manager')")
    public ResponseResult<String> payfor(Integer payid){
        try {
            PayforCommand command = new PayforCommand();
            command.handle(payid);
            return new ResponseResult<>(200,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

    @GetMapping("/charge/pay/payout")
    @ApiOperation("出院结算付款")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "patientid",value ="患者id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('financialPayment:manager')")
    public ResponseResult<String> payOutHospital(Integer patientid){
        try {
            PayOutCommand command = new PayOutCommand();
            command.handle(patientid);
            return new ResponseResult<>(200,"ok");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    @GetMapping("/charge/pay/findpatientpays")
    @ApiOperation("查询患者应付款项")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "patientid",value ="患者id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('financialPayment:manager')")
    public ResponseResult<List<PayVo>> findPatientPays(Integer patientid){
        try {
            List<PayVo> payVos = new ArrayList<>();
            List<Pay> pays = payService.findPatientPays(patientid);
            if(pays.size()==0){
                return new ResponseResult<>(200,"该患者没有未付款项");
            }
            for (Pay pay : pays) {
                PayVo payVo = new PayVo();
                BeanUtils.copyProperties(pay,payVo);
                payVos.add(payVo);
            }
            return new ResponseResult<>(payVos,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }
}
