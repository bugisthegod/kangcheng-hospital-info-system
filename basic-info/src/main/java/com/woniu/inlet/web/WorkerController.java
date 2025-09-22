package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.workercommand.AddWorkerCommand;
import com.woniu.command.workercommand.DeleteWorkerCommand;
import com.woniu.command.workercommand.UpdateWorkerCommand;
import com.woniu.inlet.web.vo.WorkerVo;
import com.woniu.outlet.po.WorkerPo;
import com.woniu.service.WorkerService;
import com.woniu.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.woniu.outlet.po.WorkerPo;
import com.woniu.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@RestController
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/basic/worker/list")
    @ApiOperation("获取工作人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "wName",value ="员工姓名",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "wStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<WorkerVo>> getWorkerList(String wName, @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d") String wStatus, @RequestParam(defaultValue = "1") @Positive Integer pageNum, @RequestParam(defaultValue = "1") @Positive Integer pageSize){
        WorkerPo workerPo = new WorkerPo();
        workerPo.setWName(wName);
        workerPo.setWStatus(wStatus);
        PageInfo<WorkerPo> workerList = null;
        try {
            workerList = workerService.getWorkerList(workerPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<WorkerPo> poList = workerList.getList();
        List<WorkerVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            WorkerVo workerVo = new WorkerVo();
            BeanUtils.copyProperties(item,workerVo);
            voList.add(workerVo);
        });
        PageInfo<WorkerVo> workerVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(workerVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/worker/getById")
    @ApiOperation("根据id获取员工信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="员工id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<WorkerVo> getWorkerById(@RequestParam("id") @Positive Integer id){
        WorkerPo workerById = null;
        try {
            workerById = workerService.getWorkerById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        WorkerVo workerVo = new WorkerVo();
        BeanUtils.copyProperties(workerById,workerVo);
        return new ResponseResult<>(workerVo,"ok",200);
    }

    /**
     * 添加
     * @param workerVo
     * @return
     */
    @PostMapping("/basic/worker/add")
    @ApiOperation("添加员工")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addWorker(@RequestBody @Valid WorkerVo workerVo){
        AddWorkerCommand command = new AddWorkerCommand();
        try {
            WorkerPo workerPo = new WorkerPo();
            BeanUtils.copyProperties(workerVo,workerPo);
            command.excute(workerPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param workerVo
     * @return
     */
    @PutMapping("/basic/worker/update")
    @ApiOperation("修改员工")
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> updateWorker(@RequestBody @Valid WorkerVo workerVo){
        UpdateWorkerCommand command = new UpdateWorkerCommand();
        try {
            WorkerPo workerPo = new WorkerPo();
            BeanUtils.copyProperties(workerVo,workerPo);
            command.excute(workerPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 删除（逻辑删除）
     * @param id
     * @return
     */
    @PutMapping("/basic/worker/deleteById")
    @ApiOperation("删除员工")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="员工id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteWorker(@RequestParam("id") @Positive Integer id){
        try {
            WorkerPo workerById = workerService.getWorkerById(id);
            workerById.setWStatus("d");
            DeleteWorkerCommand command = new DeleteWorkerCommand();
            command.excute(workerById);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }
}
