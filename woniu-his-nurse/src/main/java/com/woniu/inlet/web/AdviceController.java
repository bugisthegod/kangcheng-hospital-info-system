package com.woniu.inlet.web;

import com.woniu.command.advicecommand.DoAdviceCommand;
import com.woniu.exception.ServiceException;
import com.woniu.outlet.po.Advice;
import com.woniu.service.AdviceService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdviceController {

    @Autowired
    private AdviceService adviceService;


    @GetMapping("/nurse/advice/do")
    @ApiOperation("执行医嘱")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "adviceid",value ="医嘱id",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "nurseid",value ="执行护士id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> doAdvice(Integer adviceid,Integer nurseid){
        try {
            Advice advice = new Advice();
            advice.setId(adviceid);
            advice.setNurseid(nurseid);
            DoAdviceCommand command = new DoAdviceCommand();
            command.handle(advice);
            return new ResponseResult<>(200,"执行成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 查询病人医嘱
     * @return
     */
    @GetMapping("/nurse/advice/patientlist")
    @ApiOperation("查询病人医嘱")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "patientid",value ="医嘱id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<Advice>> findPatientAdvice(Integer patientid){
        try {
            List<Advice> adviceList = adviceService.findPatientAdvice(patientid);
            return new ResponseResult<>(adviceList,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


}
