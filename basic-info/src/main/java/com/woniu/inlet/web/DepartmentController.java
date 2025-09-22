package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.departmentcommand.AddDepartmentCommand;
import com.woniu.command.departmentcommand.DeleteDepartmentCommand;
import com.woniu.command.departmentcommand.UpdateDepartmentCommand;
import com.woniu.inlet.web.vo.DepartmentVo;
import com.woniu.outlet.dao.DepartmentPoMapper;
import com.woniu.outlet.po.DepartmentPo;
import com.woniu.outlet.po.DepartmentPoExample;
import com.woniu.service.DepartmentService;
import com.woniu.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentPoMapper departmentPoMapper;

    /**
     * 获取部门列表（根据名称、状态条件查询）
     * @return
     */
    @GetMapping("/basic/department/list")
    @ApiOperation("获取部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "dpName",value ="部门名",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "dpStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<DepartmentVo>> getDepartmentList(@NotEmpty(message = "不得为空") String dpName, @NotEmpty(message = "不得为空") String dpStatus, @Positive(message = "必须是一个正整数")@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") @Positive(message = "不得为空") Integer pageSize){
        DepartmentPo departmentPo = new DepartmentPo();
        departmentPo.setDpName(dpName);
        departmentPo.setDpStatus(dpStatus);
        PageInfo<DepartmentPo> departmentList = null;
        try {
            departmentList = departmentService.getDepartmentList(departmentPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<DepartmentPo> poList = departmentList.getList();
        List<DepartmentVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            DepartmentVo departmentVo = new DepartmentVo();
            BeanUtils.copyProperties(item,departmentVo);
            voList.add(departmentVo);
        });
        PageInfo<DepartmentVo> departmentVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(departmentVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/department/getById")
    @ApiOperation("根据id获取部门")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="部门id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<DepartmentVo> getDepartmentById(@Positive(message = "必须为一个正整数")@RequestParam("id") Integer id){
        DepartmentPo departmentById = null;
        try {
            departmentById = departmentService.getDepartmentById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        DepartmentVo departmentVo = new DepartmentVo();
        BeanUtils.copyProperties(departmentById,departmentVo);
        return new ResponseResult<>(departmentVo,"ok",200);
    }

    /**
     * 添加
     * @param departmentVo
     * @return
     */
    @PostMapping("/basic/department/add")
    @ApiOperation("添加部门")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addDepartment(@Validated @RequestBody DepartmentVo departmentVo){
        AddDepartmentCommand command = new AddDepartmentCommand();
        try {
            DepartmentPo departmentPo = new DepartmentPo();
            BeanUtils.copyProperties(departmentVo,departmentPo);
            command.excute(departmentPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param departmentVo
     * @return
     */
    @PutMapping("/basic/department/update")
    @ApiOperation("修改部门")
    @PreAuthorize("hasAuthority('equipment:list')")
    public  ResponseResult<String> updateDepartment(@Validated @RequestBody DepartmentVo departmentVo){
        UpdateDepartmentCommand command = new UpdateDepartmentCommand();
        try {
            DepartmentPo departmentPo = new DepartmentPo();
            BeanUtils.copyProperties(departmentVo,departmentPo);
            command.excute(departmentPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 删除（逻辑删除）
     * @param id
     * @return
     */
    @PutMapping("/basic/department/deleteById")
    @ApiOperation("删除部门")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="部门id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteDepartmentById(@Positive(message = "必须是个正整数")@NotNull(message = "不得为空") @RequestParam("id") Integer id){
        try {
            DepartmentPoExample example = new DepartmentPoExample();
            DepartmentPoExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            List<DepartmentPo> departmentPos = departmentPoMapper.selectByExample(example);
            if(departmentPos.size()==0){
                throw new RuntimeException("部门不存在,无法删除");
            }

            DepartmentPo departmentById = departmentService.getDepartmentById(id);
            departmentById.setDpStatus("d");
            DeleteDepartmentCommand command = new DeleteDepartmentCommand();
            command.excute(departmentById);
        } catch (Exception e) {
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

}
