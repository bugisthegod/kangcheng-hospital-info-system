package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.sun.media.sound.SoftReverb;
import com.woniu.command.departmentcommand.AddDepartmentCommand;
import com.woniu.command.departmentcommand.DeleteDepartmentCommand;
import com.woniu.command.departmentcommand.UpdateDepartmentCommand;
import com.woniu.command.subjectcommand.AddSubjectCommand;
import com.woniu.command.subjectcommand.DeleteSubjectCommand;
import com.woniu.command.subjectcommand.UpdateSubjectCommand;
import com.woniu.inlet.web.vo.SubjectVo;
import com.woniu.outlet.po.SubjectPo;
import com.woniu.service.SubjectService;
import com.woniu.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 获取科目列表（根据名称、状态条件查询）
     * @return
     */
    @GetMapping("/basic/subject/list")
    @ApiOperation("获取科室列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "sName",value ="科室名",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "sStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<SubjectVo>> getSubjectList(String sName, @Pattern(regexp = "^y|n|d$",message = "状态输入错误 状态只能为y n d") String sStatus, @RequestParam(defaultValue = "1") @Positive Integer pageNum, @RequestParam(defaultValue = "5") @Positive Integer pageSize){
        SubjectPo subjectPo = new SubjectPo();
        subjectPo.setSName(sName);
        subjectPo.setSStatus(sStatus);
        PageInfo<SubjectPo> subjectList = null;
        try {
            subjectList = subjectService.getSubjectList(subjectPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<SubjectPo> poList = subjectList.getList();
        List<SubjectVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            SubjectVo subjectVo = new SubjectVo();
            BeanUtils.copyProperties(item,subjectVo);
            voList.add(subjectVo);
        });
        PageInfo<SubjectVo> subjectVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(subjectVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/subject/getById")
    @ApiOperation("根据id获取科室")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="科室id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<SubjectVo> getSubjectById(@RequestParam("id") @Positive(message = "输入科室id有误") Integer id){
        SubjectPo subjectById = null;
        try {
            subjectById = subjectService.getSubjectById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        SubjectVo subjectVo = new SubjectVo();
        BeanUtils.copyProperties(subjectById,subjectVo);
        return new ResponseResult<>(subjectVo,"ok",200);
    }

    /**
     * 添加
     * @param subjectVo
     * @return
     */
    @PostMapping("/basic/subject/add")
    @ApiOperation("添加科室")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addSubject(@RequestBody @Valid SubjectVo subjectVo){
        AddSubjectCommand command = new AddSubjectCommand();
        try {
            SubjectPo subjectPo = new SubjectPo();
            BeanUtils.copyProperties(subjectVo,subjectPo);
            command.excute(subjectPo);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServerException){
                return new ResponseResult<>(501,e.getMessage());
            }
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param subjectVo
     * @return
     */
    @PutMapping("/basic/subject/update")
    @ApiOperation("修改科室")
    @PreAuthorize("hasAuthority('equipment:list')")
    public  ResponseResult<String> updateSubject(@RequestBody @Positive(message = "输入科室id有误") SubjectVo  subjectVo){
        UpdateSubjectCommand command = new UpdateSubjectCommand();
        try {
            SubjectPo subjectPo = new SubjectPo();
            BeanUtils.copyProperties(subjectVo,subjectPo);
            command.excute(subjectPo);
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
    @PutMapping("/basic/subject/deleteById")
    @ApiOperation("删除科室")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="科室id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteSubjectById(@RequestParam("id") Integer id){
        try {
            SubjectPo subjectById = subjectService.getSubjectById(id);
            subjectById.setSStatus("d");
            DeleteSubjectCommand command = new DeleteSubjectCommand();
            command.excute(subjectById);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

}
