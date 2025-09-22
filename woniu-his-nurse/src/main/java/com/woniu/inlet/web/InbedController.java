package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.client.BedClient;
import com.woniu.command.inbedcommand.*;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.InbedVo;
import com.woniu.inlet.web.vo.WorkerVo;
import com.woniu.outlet.po.Bed;
import com.woniu.outlet.po.Inbed;
import com.woniu.outlet.po.Patient;
import com.woniu.outlet.po.Worker;
import com.woniu.service.InbedService;
import com.woniu.service.WorkerService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InbedController {

    @Autowired
    private InbedService inbedService;
    @Autowired
    private WorkerService workerService;

    @Autowired
    @Qualifier("registered1")
    private BedClient bedClient;

    /**
     * 入院登记(还没有分配床位)
     * @return
     */
    @GetMapping("/nurse/inbed/add")
    @ApiOperation("入院登记")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "regbedid",value ="预约记录id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> addInbed(Integer regbedid){
        try {
            AddInbedCommand command = new AddInbedCommand();
            command.handle(regbedid);
            return new ResponseResult<>(200,"入院登记完成");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 查询未分配床位的患者列表
     * @return
     */
    @GetMapping("/nurse/inbed/waitlist")
    @ApiOperation("查询未分配床位的患者列表")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<InbedVo>> findWaitInbeds(){
        try {
            List<Inbed> inbeds = inbedService.findWaitInbed();
            List<InbedVo> inbedVos = new ArrayList<>();
            for (Inbed inbed : inbeds) {
                InbedVo inbedVo = new InbedVo();
                BeanUtils.copyProperties(inbed,inbedVo);
                inbedVos.add(inbedVo);
            }
            return new ResponseResult<>(inbedVos,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    @GetMapping("/nurse/bed/ablebedlist")
    @ApiOperation("查询可用床位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "subjectid",value ="科室id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<Bed>> findAbleBeds(@RequestParam("subjectid") Integer subjectid){
        try {
            ResponseResult<List<Bed>> beds = bedClient.findAbleBeds(subjectid);
            if(beds.getStatus()==200){
                return beds;
            }
            return new ResponseResult<>(501,"系统异常");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 分配床位
     * @return
     */
    @GetMapping("/nurse/inbed/allot")
    @ApiOperation("分配床位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "inbedid",value ="入院记录id",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "bedid",value ="床位id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> allotBed(Integer inbedid,Integer bedid){
        try {
            AllotBedCommand command = new AllotBedCommand();
            Inbed inbed = new Inbed();
            inbed.setId(inbedid);
            inbed.setBedid(bedid);
            command.handle(inbed);
            return new ResponseResult<>(200,"分配成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

    /**
     * 停止病人床位
     * @return
     */
    @GetMapping("/nurse/inbed/recycle")
    @ApiOperation("停止病人床位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "inbedid",value ="入院记录id",dataType ="int")
    })
    //@PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> recycleBed(Integer inbedid){
        try {
            RecycleBedCommand command = new RecycleBedCommand();
            command.handle(inbedid);
            return new ResponseResult<>(200,"停止床位成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    @GetMapping("/nurse/worker/abledoctor")
    @ApiOperation("查找可指派医生")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<WorkerVo>> findAbleDoctor(){
        try {
            List<Worker> doctors = workerService.findAbleDoctor();
            List<WorkerVo> doctorVos = new ArrayList<>();
            for (Worker doctor : doctors) {
                WorkerVo doctorVo = new WorkerVo();
                BeanUtils.copyProperties(doctor,doctorVo);
                doctorVos.add(doctorVo);
            }
            return new ResponseResult<>(doctorVos,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    @GetMapping("/nurse/worker/ablenurse")
    @ApiOperation("查找可指派护士")
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<List<WorkerVo>> findAbleNurse(){
        try {
            List<Worker> nurses = workerService.findAbleNurse();
            List<WorkerVo> nurseVos = new ArrayList<>();
            for (Worker nurse : nurses) {
                WorkerVo nurseVo = new WorkerVo();
                BeanUtils.copyProperties(nurse,nurseVo);
                nurseVos.add(nurseVo);
            }
            return new ResponseResult<>(nurseVos,"ok",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 指派经治人员
     */
    @GetMapping("/nurse/worker/allot")
    @ApiOperation("指派经治人员")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "inbedid",value ="入院记录id",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "doctorid",value ="指派医生id",dataType ="int"),
            @ApiImplicitParam(paramType = "query",name = "nurseid",value ="指派护士id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<String> allotWorker(Integer inbedid,Integer doctorid,Integer nurseid){
        try {
            Inbed inbed = new Inbed();
            inbed.setId(inbedid);
            inbed.setDoctorid(doctorid);
            inbed.setNurseid(nurseid);
            AllotWorkerCommand command = new AllotWorkerCommand();
            command.handle(inbed);
            return new ResponseResult<>(200,"指派成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 出院结算
     */
    @GetMapping("/nurse/inbed/settle")
    @ApiOperation("出院结算")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "inbedid",value ="住院记录id",dataType ="int")
    })
    @PreAuthorize("hasAuthority('nurseStation:manager')")
    public ResponseResult<BigDecimal> outHospitalSettle(Integer inbedid){
        try {
            OutHospitalSettleCommand command = new OutHospitalSettleCommand();
            BigDecimal cost = command.handle(inbedid);
            return new ResponseResult<>(cost,"已办理出院，请去结清费用",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 出院（改状态）
     */
    @GetMapping("/nurse/inbed/out")
    @ApiOperation(value = "出院",hidden = true)
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "inbedid",value ="住院记录id",dataType ="int")
    })
    public ResponseResult<String> outHospital(Integer inbedid){
        try {
            OutHospitalCommand command = new OutHospitalCommand();
            command.handle(inbedid);
            return new ResponseResult<>(200,"出院成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

}
