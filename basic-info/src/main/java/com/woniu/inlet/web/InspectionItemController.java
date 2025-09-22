package com.woniu.inlet.web;

import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.departmentcommand.AddDepartmentCommand;
import com.woniu.command.departmentcommand.DeleteDepartmentCommand;
import com.woniu.command.departmentcommand.UpdateDepartmentCommand;
import com.woniu.command.inspectionitemcommand.AddInspectionItemCommand;
import com.woniu.command.inspectionitemcommand.DeleteInspectionItemCommand;
import com.woniu.command.inspectionitemcommand.UpdateInspectionItemCommand;
import com.woniu.inlet.web.vo.InspectionItemVo;
import com.woniu.outlet.dao.InspectionItemPoMapper;
import com.woniu.outlet.po.InspectionItemPo;
import com.woniu.outlet.po.InspectionItemPoExample;
import com.woniu.service.InspectionItemService;
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
public class InspectionItemController {

    @Autowired
    private InspectionItemService inspectionItemService;

    @Autowired
    private InspectionItemPoMapper inspectionItemPoMapper;

    /**
     * 获取检查项目列表（根据名称、状态条件查询）
     * @return
     */
    @GetMapping("/basic/inspectionItem/list")
    @ApiOperation("获取检查项目列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "iiName",value ="检查项目名",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "iiStatus",value ="状态 y正常 n禁用 d删除",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "pageNum",value ="页码",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",value ="每页显示几条",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<PageInfo<InspectionItemVo>> getInspectionItemList(@NotEmpty(message = "不得为空") String iiName, String iiStatus, @Positive(message = "必须为一个正整数") @NotNull(message = "不得为空") @RequestParam(defaultValue = "1") Integer pageNum,@Positive(message = "必须为一个正整数") @NotNull(message = "不得为空") @RequestParam(defaultValue = "5") Integer pageSize){
        InspectionItemPo inspectionItemPo = new InspectionItemPo();
        inspectionItemPo.setIiName(iiName);
        inspectionItemPo.setIiStatus(iiStatus);
        PageInfo<InspectionItemPo> inspectionItemList = null;
        try {
            inspectionItemList = inspectionItemService.getInspectionItemList(inspectionItemPo,pageNum,pageSize);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        List<InspectionItemPo> poList = inspectionItemList.getList();
        List<InspectionItemVo> voList = new ArrayList<>();
        poList.forEach(item -> {
            InspectionItemVo inspectionItemVo = new InspectionItemVo();
            BeanUtils.copyProperties(item,inspectionItemVo);
            voList.add(inspectionItemVo);
        });
        PageInfo<InspectionItemVo> inspectionItemVoPageInfo = new PageInfo<>(voList);
        return new ResponseResult<>(inspectionItemVoPageInfo,"ok",200);
    }

    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    @GetMapping("/basic/inspectionItem/getById")
    @ApiOperation("根据id获取检查项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="检查项目id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<InspectionItemVo> getInspectionItemById(@NotNull(message = "不得为空")@Positive(message = "必须为一个正整数")@RequestParam("id") Integer id){
        InspectionItemPo inspectionItemById = null;
        try {
            inspectionItemById = inspectionItemService.getInspectionItemById(id);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        InspectionItemVo inspectionItemVo = new InspectionItemVo();
        BeanUtils.copyProperties(inspectionItemById,inspectionItemVo);
        return new ResponseResult<>(inspectionItemVo,"ok",200);
    }

    /**
     * 添加
     * @param inspectionItemVo
     * @return
     */
    @PostMapping("/basic/inspectionItem/add")
    @ApiOperation("添加检查项目")
    @ApiOperationSupport(ignoreParameters = {"id"})
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> addInspectionItem(@Validated @RequestBody InspectionItemVo inspectionItemVo){
        AddInspectionItemCommand command = new AddInspectionItemCommand();
        try {
            InspectionItemPo inspectionItemPo = new InspectionItemPo();
            BeanUtils.copyProperties(inspectionItemVo,inspectionItemPo);
            command.excute(inspectionItemPo);
        } catch (Exception e) {
            return new ResponseResult<>(null,"系统异常",999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

    /**
     * 修改
     * @param inspectionItemVo
     * @return
     */
    @PutMapping("/basic/inspectionItem/update")
    @ApiOperation("修改检查项目")
    @PreAuthorize("hasAuthority('equipment:list')")
    public  ResponseResult<String> updateInspectionItem(@Validated @RequestBody InspectionItemVo inspectionItemVo){
        UpdateInspectionItemCommand command = new UpdateInspectionItemCommand();
        try {
            InspectionItemPo inspectionItemPo = new InspectionItemPo();
            BeanUtils.copyProperties(inspectionItemVo,inspectionItemPo);
            command.excute(inspectionItemPo);
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
    @PutMapping("/basic/inspectionItem/deleteById")
    @ApiOperation("删除检查项目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "id",value ="检查项目id",dataType ="int"),
    })
    @PreAuthorize("hasAuthority('equipment:list')")
    public ResponseResult<String> deleteInspectionItem(@NotNull(message = "不得为空")@Positive(message = "必须为一个正整数")@RequestParam("id") Integer id){
        try {
            InspectionItemPoExample example = new InspectionItemPoExample();
            InspectionItemPoExample.Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
            List<InspectionItemPo> inspectionItemPos = inspectionItemPoMapper.selectByExample(example);
            if(inspectionItemPos.size()==0){
                throw new RuntimeException("检查项目不存在,无法修改");
            }

            InspectionItemPo inspectionItemById = inspectionItemService.getInspectionItemById(id);
            inspectionItemById.setIiStatus("d");
            DeleteInspectionItemCommand command = new DeleteInspectionItemCommand();
            command.excute(inspectionItemById);
        } catch (Exception e) {
            return new ResponseResult<>(null,e.getMessage(),999);
        }
        return new ResponseResult<>("成功","ok",200);
    }

}
