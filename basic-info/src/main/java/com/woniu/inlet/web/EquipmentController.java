package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.departmentcommand.AddDepartmentCommand;
import com.woniu.command.departmentcommand.DeleteDepartmentCommand;
import com.woniu.command.departmentcommand.UpdateDepartmentCommand;
import com.woniu.command.equipmentcommand.AddEquipmentCommand;
import com.woniu.command.equipmentcommand.DeleteEquipmentCommand;
import com.woniu.command.equipmentcommand.UpdateEquipmentCommand;
import com.woniu.inlet.web.vo.EquipmentVo;
import com.woniu.outlet.dao.EquipmentPoMapper;
import com.woniu.outlet.po.EquipmentPo;
import com.woniu.outlet.po.EquipmentPoExample;
import com.woniu.service.EquipmentService;
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
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentPoMapper equipmentPoMapper;

    /**
     * 获取设备列表（根据名称、状态条件查询）
     * @return
     */
    @GetMapping("/basic/equipment/list")
    @ApiOperation("获取设备列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "eqName",value ="设备名",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "eqStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<EquipmentVo>> getEquipmentList(@NotEmpty(message = "不得为空") String eqName, String eqStatus, @Positive(message = "必须是一个正整数") @RequestParam(defaultValue = "1") Integer pageNum,@Positive(message = "必须是一个正整数") @RequestParam(defaultValue = "5") Integer pageSize){
        EquipmentPo equipmentPo = new EquipmentPo();
        equipmentPo.setEqName(eqName);
        equipmentPo.setEqStatus(eqStatus);
        PageInfo<EquipmentPo> equipmentList = null;
        try {
            equipmentList = equipmentService.getEquipmentList(equipmentPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<EquipmentPo> poList = equipmentList.getList();
        List<EquipmentVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            EquipmentVo equipmentVo = new EquipmentVo();
            BeanUtils.copyProperties(item,equipmentVo);
            voList.add(equipmentVo);
        });
        PageInfo<EquipmentVo> equipmentVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(equipmentVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/equipment/getById")
    @ApiOperation("根据id获取设备")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="设备id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<EquipmentVo> getEquipmentById(@Positive(message = "必须为一个正整数") @RequestParam("id") Integer id){
        EquipmentPo equipmentById = null;
        try {
            equipmentById = equipmentService.getEquipmentById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        EquipmentVo equipmentVo = new EquipmentVo();
        BeanUtils.copyProperties(equipmentById,equipmentVo);
        return new ResponseResult<>(equipmentVo,"ok",200);
    }

    /**
     * 添加
     * @param equipmentVo
     * @return
     */
    @PostMapping("/basic/equipment/add")
    @ApiOperation("添加设备")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addEquipment(@Validated @RequestBody EquipmentVo equipmentVo){
        AddEquipmentCommand command = new AddEquipmentCommand();
        try {
            EquipmentPo equipmentPo = new EquipmentPo();
            BeanUtils.copyProperties(equipmentVo,equipmentPo);
            command.excute(equipmentPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param equipmentVo
     * @return
     */
    @PutMapping("/basic/equipment/update")
    @ApiOperation("修改设备")
    @PreAuthorize("hasAuthority('equipment:list')")
    public  ResponseResult<String> updateEquipment(@Validated @RequestBody EquipmentVo equipmentVo){
        UpdateEquipmentCommand command = new UpdateEquipmentCommand();
        try {
            EquipmentPo equipmentPo = new EquipmentPo();
            BeanUtils.copyProperties(equipmentVo,equipmentPo);
            command.excute(equipmentPo);
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
    @PutMapping("/basic/equipment/deleteById")
    @ApiOperation("删除设备")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="设备id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteEquipmentById(@Positive(message = "必须为一个正整数") @NotNull(message = "不得为空") @RequestParam("id") Integer id){
        try {
            EquipmentPoExample example = new EquipmentPoExample();
            EquipmentPoExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            List<EquipmentPo> equipmentPos = equipmentPoMapper.selectByExample(example);
            if(equipmentPos.size()==0){
                throw new RuntimeException("器材不存在,无法删除");
            }

            EquipmentPo equipmentById = equipmentService.getEquipmentById(id);
            equipmentById.setEqStatus("d");
            DeleteEquipmentCommand command = new DeleteEquipmentCommand();
            command.excute(equipmentById);
        } catch (Exception e) {
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

}
