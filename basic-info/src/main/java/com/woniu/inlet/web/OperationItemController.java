package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.operationitemcommand.AddOperationItemCommand;
import com.woniu.command.operationitemcommand.DeleteOperationItemCommand;
import com.woniu.command.operationitemcommand.UpdateOperationItemCommand;
import com.woniu.inlet.web.vo.OperationItemVo;
import com.woniu.outlet.po.OperationItemPo;
import com.woniu.service.OperationItemService;
import com.woniu.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class OperationItemController {

    @Autowired
    private OperationItemService operationItemService;

    /**
     * 获取手术项目列表（根据名称、状态条件查询）
     * @return
     */
    @GetMapping("/basic/operationItem/list")
    @ApiOperation("获取手术项目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "oiName",value ="手术项目名",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "oiStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<OperationItemVo>> getOperationItemList(String oiName, @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d") String oiStatus, @RequestParam(defaultValue = "1") @Positive Integer pageNum, @RequestParam(defaultValue = "5") @Positive Integer pageSize){
        OperationItemPo operationItemPo = new OperationItemPo();
        operationItemPo.setOiName(oiName);
        operationItemPo.setOiStatus(oiStatus);
        PageInfo<OperationItemPo> operationItemList = null;
        try {
            operationItemList = operationItemService.getOperationItemList(operationItemPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<OperationItemPo> poList = operationItemList.getList();
        List<OperationItemVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            OperationItemVo operationItemVo = new OperationItemVo();
            BeanUtils.copyProperties(item,operationItemVo);
            voList.add(operationItemVo);
        });
        PageInfo<OperationItemVo> operationItemVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(operationItemVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/operationItem/getById")
    @ApiOperation("根据id获取手术项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="手术项目id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<OperationItemVo> getOperationItemById(@RequestParam("id") @Positive(message = "输入手术id有误") Integer id){
        OperationItemPo operationItemById = null;
        try {
            operationItemById = operationItemService.getOperationItemById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        OperationItemVo operationItemVo = new OperationItemVo();
        BeanUtils.copyProperties(operationItemById,operationItemVo);
        return new ResponseResult<>(operationItemVo,"ok",200);
    }

    /**
     * 添加
     * @param operationItemVo
     * @return
     */
    @PostMapping("/basic/operationItem/add")
    @ApiOperation("添加手术项目")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addOperationItem(@RequestBody @Valid OperationItemVo operationItemVo){
        AddOperationItemCommand command = new AddOperationItemCommand();
        try {
            OperationItemPo operationItemPo = new OperationItemPo();
            BeanUtils.copyProperties(operationItemVo,operationItemPo);
            command.excute(operationItemPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param operationItemVo
     * @return
     */
    @PutMapping("/basic/operationItem/update")
    @ApiOperation("修改手术项目")
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> updateOperationItem(@RequestBody @Valid OperationItemVo operationItemVo){
        UpdateOperationItemCommand command = new UpdateOperationItemCommand();
        try {
            OperationItemPo operationItemPo = new OperationItemPo();
            BeanUtils.copyProperties(operationItemVo,operationItemPo);
            command.excute(operationItemPo);
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
    @PutMapping("/basic/operationItem/deleteById")
    @ApiOperation("删除手术项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="手术项目id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteOperationItem(@RequestParam("id") @Positive(message = "输入手术id有误") Integer id){
        try {
            OperationItemPo operationItemById = operationItemService.getOperationItemById(id);
            operationItemById.setOiStatus("d");
            DeleteOperationItemCommand command = new DeleteOperationItemCommand();
            command.excute(operationItemById);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }
}
