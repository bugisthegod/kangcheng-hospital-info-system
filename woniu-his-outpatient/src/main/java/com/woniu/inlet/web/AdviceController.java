package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.AdvicePoCommand.AddAdvicePoCommand;
import com.woniu.command.AdvicePoCommand.DeleteAdvicePoCommand;
import com.woniu.command.AdvicePoCommand.UpdateAdvicePoCommand;
import com.woniu.outlet.po.AdvicePo;
import com.woniu.service.AdvicePoService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AdviceController {

    @Autowired
    private AdvicePoService advicePoService;

    @GetMapping("/outpatient/advice/list")
    @ApiOperation("条件分页查询医嘱")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "int", example = "1"),
    })
    public ResponseResult<List<AdvicePo>> getAdviceList(@Validated AdvicePo advicePo, @NotNull(message = "不能为空") @Positive(message = "必须为一个正整数") Integer pageNum) {
        List<AdvicePo> advicePoList = new ArrayList<>();
        try {
            advicePoList = advicePoService.getAdvicePoList(advicePo, pageNum);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(null, "OK", 999);
        }
        return new ResponseResult<>(advicePoList, "OK", 200);
    }

    @PostMapping("/outpatient/advice/add")
    @ApiOperation("添加医嘱")
    @ApiOperationSupport(ignoreParameters = {"id"})
    public ResponseResult<Integer> addAdvice(AdvicePo advicePo) {
        Integer flag = null;
        try {
            AddAdvicePoCommand command = new AddAdvicePoCommand();
            flag = command.execute(advicePo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(null, "OK", 999);
        }
        return new ResponseResult<>(flag, "OK", 200);
    }

    @PutMapping("/outpatient/advice/update")
    @ApiOperation("修改医嘱")
    public ResponseResult<Integer> updateAdvice(AdvicePo advicePo) {
        Integer flag = null;
        try {
            UpdateAdvicePoCommand command = new UpdateAdvicePoCommand();
            flag = command.execute(advicePo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(null, "OK", 999);
        }
        return new ResponseResult<>(flag, "OK", 200);
    }

    @DeleteMapping("/outpatient/advice/delete")
    @ApiOperation("删除医嘱")
    public ResponseResult<Integer> deleteAdvice(Integer id) {
        Integer flag = null;
        try {
        DeleteAdvicePoCommand command = new DeleteAdvicePoCommand();
         flag = command.execute(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(null, "OK", 999);
        }
        return new ResponseResult<>(flag, "OK", 200);
    }

}
