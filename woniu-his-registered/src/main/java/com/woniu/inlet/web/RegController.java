package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.regcommand.AddRegCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.RegVo;
import com.woniu.outlet.po.Reg;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
public class RegController {

    /**
     * 挂号
     * @return
     */
    @GetMapping("/registered/reg/add")
    @ApiOperation("挂号")
    @ApiOperationSupport(ignoreParameters = {"id","status"})
    public ResponseResult<String> doReg(@Validated RegVo regVo,@NotEmpty(message = "token不能为空") String token){
        try {
            Reg reg = new Reg();
            BeanUtils.copyProperties(regVo,reg);
            AddRegCommand command = new AddRegCommand();
            reg.setToken(token);
            command.handle(reg);
            return new ResponseResult<>(200,"挂号成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }
}
