package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.regbedcommand.AddRegbedCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.RegbedVo;
import com.woniu.outlet.po.Bed;
import com.woniu.outlet.po.Regbed;
import com.woniu.outlet.po.Subject;
import com.woniu.service.BedService;
import com.woniu.service.SubjectService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
public class RegbedController {

    @Autowired
    private BedService bedService;
    @Autowired
    private SubjectService subjectService;

    /**
     * 预约住院
     * @return
     */
    @GetMapping("/registered/regbed/add")
    @ApiOperation("预约住院")
    @ApiOperationSupport(ignoreParameters = {"id","status"})
    public ResponseResult<String> orderInBed(@Validated RegbedVo regbedVo,@NotEmpty(message = "token不能为空") String token){
        try {
            Regbed regbed = new Regbed();
            BeanUtils.copyProperties(regbedVo,regbed);
            AddRegbedCommand command = new AddRegbedCommand();
            regbed.setToken(token);
            command.handle(regbed);
            return new ResponseResult<>(200,"预约成功，请去预交至少300元费用");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    @GetMapping("/registered/bed/ablelist")
    @ApiOperation(value = "寻找可用床位", hidden = true)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "subjectid",value ="科室id",dataType ="string"),
    })
    public ResponseResult<List<Bed>> findAbleBeds(Integer subjectid){
        try {
            List<Bed> ableBeds = bedService.findAbleBeds(subjectid);
            return new ResponseResult<>(ableBeds,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(501,"系统异常");
        }
    }

    @GetMapping("/registered/subject/ablelist")
    @ApiOperation(value = "寻找可用科室")
    public ResponseResult<List<Subject>> findAbleSubjects(){
        try {
            List<Subject> subjects = subjectService.findAbleSubjects();
            return new ResponseResult<>(subjects,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(501,"系统异常");
        }
    }
}
