package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.depositcommand.AddDepositCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.vo.DepositVo;
import com.woniu.outlet.po.Deposit;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    /**
     * 预交费
     * @param depositVo
     * @return
     */
    @GetMapping("/charge/deposit/advance")
    @ApiOperation("预交费")
    @ApiOperationSupport(ignoreParameters = {"id","time"})
    @PreAuthorize("hasAuthority('financialPaymentInHospitalized:list')")
    public ResponseResult<String> advancePay(@Validated DepositVo depositVo){
        try {
            Deposit deposit = new Deposit();
            AddDepositCommand command = new AddDepositCommand();
            BeanUtils.copyProperties(depositVo,deposit);
            command.handle(deposit);
            return new ResponseResult<>(200,"预交成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(501,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }
}
