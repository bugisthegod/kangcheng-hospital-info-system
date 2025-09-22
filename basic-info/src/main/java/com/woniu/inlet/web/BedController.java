package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.bedcommand.AddBedCommand;
import com.woniu.command.bedcommand.DeleteBedCommand;
import com.woniu.command.bedcommand.UpdateBedCommand;
import com.woniu.inlet.web.vo.BedVo;
import com.woniu.outlet.dao.BedMapper;
import com.woniu.outlet.po.BedExample;
import com.woniu.outlet.po.BedPo;
import com.woniu.service.BedService;
import com.woniu.util.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

@RestController

public class BedController {

    @Autowired
    private BedService bedService;

    @Autowired
    private BedMapper bedMapper;

    /**
     * 获取病床列表（根据状态条件查询）
     * @return
     */
    @GetMapping("/basic/bed/list")
    @ApiOperation("获取病床列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "status",value ="状态 0空 1有人 2禁用",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<BedVo>> getBedList(String status, @Positive(message = "页数必须是一个正整数") @RequestParam(defaultValue = "1") Integer pageNum,  @Positive(message = "页数必须是一个正整数") @RequestParam(defaultValue = "5")Integer pageSize){
        BedPo bedPo = new BedPo();
        bedPo.setStatus(status);
        PageInfo<BedPo> bedList = null;
        try {
            bedList = bedService.getBedList(bedPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<BedPo> poList = bedList.getList();
        List<BedVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            BedVo bedVo = new BedVo();
            BeanUtils.copyProperties(item,bedVo);
            voList.add(bedVo);
        });
        PageInfo<BedVo> bedVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(bedVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/bed/getById")
    @ApiOperation("根据id获取病床")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="病床id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<BedVo> getBedById(@Positive(message = "必须为一个正整数")@RequestParam("id") Integer id){
        BedPo bedById = null;
        try {
            bedById = bedService.getBedById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        BedVo bedVo = new BedVo();
        BeanUtils.copyProperties(bedById,bedVo);
        return new ResponseResult<>(bedVo,"ok",200);
    }

    /**
     * 添加
     * @param bedVo
     * @return
     */
    @PostMapping("/basic/bed/add")
    @ApiOperation("添加病床")
    @ApiOperationSupport(ignoreParameters = {"id","patientid"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addBed(@Validated @RequestBody BedVo bedVo){
        AddBedCommand command = new AddBedCommand();
        try {
            BedPo bedPo = new BedPo();
            BeanUtils.copyProperties(bedVo,bedPo);
            command.excute(bedPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param bedVo
     * @return
     */
    @PutMapping("/basic/bed/update")
    @ApiOperation("修改病床")
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> updateBed(@Validated @RequestBody BedVo bedVo){
        UpdateBedCommand command = new UpdateBedCommand();
        try {
            BedPo bedPo = new BedPo();
            BeanUtils.copyProperties(bedVo,bedPo);
            command.excute(bedPo);
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
    @PutMapping("/basic/bed/deleteById")
    @ApiOperation("删除病床")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="病床id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteBed(@Positive(message = "必须为一个正整数")@RequestParam("id") Integer id){
        try {
            BedExample example = new BedExample();
            BedExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            List<BedPo> bedPos = bedMapper.selectByExample(example);
            if(bedPos.size()==0){
                throw new RuntimeException("该床位不存在，无法删除");
            }
            BedPo bedById = bedService.getBedById(id);
            bedById.setStatus("d");
            DeleteBedCommand command = new DeleteBedCommand();
            command.excute(bedById);
        } catch (Exception e) {
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>("成功","ok",200);
    }
}
