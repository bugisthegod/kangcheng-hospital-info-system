package com.woniu.inlet.web;

import com.woniu.command.regbedcommand.CheckCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.RegbedVo;
import com.woniu.outlet.po.Patient;
import com.woniu.outlet.po.Regbed;
import com.woniu.service.RegbedService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegbedController {

    @Autowired
    private RegbedService regbedService;


    @GetMapping("/nurse/regbed/ncklist")
    @ApiOperation("查询未审核的住院预约")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<RegbedVo>> findUncheckedRegbed(){
        try {
            List<Regbed> regbeds = regbedService.findUncheckedRegbed();
            List<RegbedVo> regbedVos = new ArrayList<>();
            for (Regbed regbed : regbeds) {
                RegbedVo regbedVo = new RegbedVo();
                BeanUtils.copyProperties(regbed,regbedVo);
                regbedVos.add(regbedVo);
            }
            return new ResponseResult<>(regbedVos,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 护士审核预约住院
     * @param regbedid
     * @return
     */
    @GetMapping("/nurse/regbed/check")
    @ApiOperation("护士审核住院预约")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "regbedid",value ="预约记录id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> checkRegbed(Integer regbedid){
        try {
            CheckCommand command = new CheckCommand();
            command.handle(regbedid);
            return new ResponseResult<>(200,"审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 查询预约住院成功的患者信息
     */
    @GetMapping("/nurse/regbed/cklist")
    @ApiOperation("查询审核通过的住院预约")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<RegbedVo>> findCheckedRegbed(){
        try {
            List<Regbed> regbeds = regbedService.findCheckedRegbed();
            List<RegbedVo> regbedVos = new ArrayList<>();
            for (Regbed regbed : regbeds) {
                RegbedVo regbedVo = new RegbedVo();
                BeanUtils.copyProperties(regbed,regbedVo);
                regbedVos.add(regbedVo);
            }
            return new ResponseResult<>(regbedVos,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }
}
