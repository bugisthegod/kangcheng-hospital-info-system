package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.sun.org.apache.xpath.internal.operations.String;
import com.woniu.adapter.NursingAdapter;
import com.woniu.command.nursingcommand.AddNursingCommand;
import com.woniu.command.nursingcommand.DeleteNursingCommand;
import com.woniu.command.nursingcommand.UpdateNursingCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.NursingVo;
import com.woniu.outlet.po.Nursing;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
public class NursingController {

    @Autowired
    private NursingAdapter nursingAdapter;

    /**
     * 添加护理记录
     * @return
     */
    @GetMapping("/nurse/nursing/add")
    @ApiOperation("添加护理记录")
    @ApiOperationSupport(ignoreParameters = {"id","status"})
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> addNursing(@Valid NursingVo nursingVo){
        try {
            Nursing nursing = new Nursing();
            AddNursingCommand command = new AddNursingCommand();
            BeanUtils.copyProperties(nursingVo,nursing);
            command.handle(nursing);
            return new ResponseResult<>(200,"添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

    /**
     * 编辑护理记录
     * @param nursingVo
     * @return
     */
    @GetMapping("/nurse/nursing/update")
    @ApiOperation("编辑护理记录")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> updateNursing(@Valid NursingVo nursingVo){
        try {
            Nursing nursing = new Nursing();
            UpdateNursingCommand command = new UpdateNursingCommand();
            BeanUtils.copyProperties(nursingVo,nursing);
            command.handle(nursing);
            return new ResponseResult<>(200,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

    /**
     * 删除护理记录(逻辑删除)
     * @return
     */
    @GetMapping("/nurse/nursing/delete")
    @ApiOperation("删除护理记录")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> deleteNursing(@Positive Integer nursingid){
        try {
            DeleteNursingCommand command = new DeleteNursingCommand();
            command.handle(nursingid);
            return new ResponseResult<>(200,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }
}
