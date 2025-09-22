package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.operationitemcommand.AddOperationItemCommand;
import com.woniu.command.operationitemcommand.DeleteOperationItemCommand;
import com.woniu.command.operationitemcommand.UpdateOperationItemCommand;
import com.woniu.command.wardcommand.AddWardCommand;
import com.woniu.command.wardcommand.DeleteWardCommand;
import com.woniu.command.wardcommand.UpdateWardCommand;
import com.woniu.inlet.web.vo.WardVo;
import com.woniu.outlet.po.WardPo;
import com.woniu.service.WardService;
import com.woniu.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WardController {

    @Autowired
    private WardService wardService;

    /**
     * 获取病房列表（根据科室名称、状态条件查询）
     * @return
     */
    @GetMapping("/basic/ward/list")
    @ApiOperation("获取病房列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "wSid",value ="科室id",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "wStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<WardVo>> getWardList(@Positive Integer wSid, @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d") String wStatus, @RequestParam(defaultValue = "1") @Positive Integer pageNum, @RequestParam(defaultValue = "5") @Positive Integer pageSize){
        WardPo wardPo = new WardPo();
        wardPo.setWSid(wSid);
        wardPo.setWStatus(wStatus);
        PageInfo<WardPo> wardList = null;
        try {
            wardList = wardService.getWardList(wardPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<WardPo> poList = wardList.getList();
        List<WardVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            WardVo wardVo = new WardVo();
            BeanUtils.copyProperties(item,wardVo);
            voList.add(wardVo);
        });
        PageInfo<WardVo> wardVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(wardVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/ward/getById")
    @ApiOperation("根据id获取病房")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="病房id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<WardVo> getWardById(@RequestParam("id") @Positive Integer id){
        WardPo wardById = null;
        try {
            wardById = wardService.getWardById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        WardVo wardVo = new WardVo();
        BeanUtils.copyProperties(wardById,wardVo);
        return new ResponseResult<>(wardVo,"ok",200);
    }

    /**
     * 添加
     * @param wardVo
     * @return
     */
    @PostMapping("/basic/ward/add")
    @ApiOperation("添加病房")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addWard(@RequestBody @Valid WardVo wardVo){
        AddWardCommand command = new AddWardCommand();
        try {
            WardPo wardPo = new WardPo();
            BeanUtils.copyProperties(wardVo,wardPo);
            command.excute(wardPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param wardVo
     * @return
     */
    @PutMapping("/basic/ward/update")
    @ApiOperation("修改病房")
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> updateWard(@RequestBody @Valid WardVo wardVo){
        UpdateWardCommand command = new UpdateWardCommand();
        try {
            WardPo wardPo = new WardPo();
            BeanUtils.copyProperties(wardVo,wardPo);
            command.excute(wardPo);
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
    @PutMapping("/basic/ward/deleteById")
    @ApiOperation("删除病房")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="病房id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteWard(@RequestParam("id") @Positive Integer id){
        try {
            WardPo wardById = wardService.getWardById(id);
            wardById.setWStatus("d");
            DeleteWardCommand command = new DeleteWardCommand();
            command.excute(wardById);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }
}
