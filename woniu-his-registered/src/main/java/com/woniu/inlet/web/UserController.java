package com.woniu.inlet.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.woniu.command.usercommand.ActivateUserCommand;
import com.woniu.command.usercommand.RegisterUserCommand;
import com.woniu.exception.ServiceException;
import com.woniu.inlet.web.vo.UserVo;
import com.woniu.outlet.po.User;
import com.woniu.service.UserService;
import com.woniu.utils.ResponseResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param userVo
     * @return
     */
    @GetMapping("/registered/user/register")
    @ApiOperation("注册用户")
    @ApiOperationSupport(ignoreParameters = {"id","status"})
    public ResponseResult<String> registerUser(@Validated UserVo userVo){
        try {
            User user = new User();
            RegisterUserCommand command = new RegisterUserCommand();
            BeanUtils.copyProperties(userVo,user);
            String handle = command.handle(user);
            return new ResponseResult<>("激活码："+handle+",五分钟有效","注册成功，请激活",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }

    /**
     * 激活账户
     * @return
     */
    @GetMapping("/registered/user/activate")
    @ApiOperation("激活用户")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "phone",value ="电话号码",dataType ="string"),
            @ApiImplicitParam(paramType = "query",name = "handle",value ="激活码,遗忘请重新注册获取",dataType ="string")
    })
    public ResponseResult<String> activateUser(String phone,String handle){
        try {
            Map<String,String> map = new HashMap<>();
            map.put("phone",phone);
            map.put("handle",handle);
            ActivateUserCommand command = new ActivateUserCommand();
            command.handle(map);
            return new ResponseResult<>(200,"激活成功");
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }


    /**
     * 挂号系统登录
     */
    @GetMapping("/registered/user/login")
    @ApiOperation("登录挂号系统")
    @ApiOperationSupport(ignoreParameters = {"id","status"})
    public ResponseResult<String> loginToReg(UserVo userVo){
        try {
            User user = new User();
            BeanUtils.copyProperties(userVo,user);
            String token = userService.doLogin(user);
            return new ResponseResult<>(token,"登录成功,请用token",200);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof ServiceException){
                return new ResponseResult<>(502,e.getMessage());
            }
            return new ResponseResult<>(501,"系统异常");
        }
    }



}
