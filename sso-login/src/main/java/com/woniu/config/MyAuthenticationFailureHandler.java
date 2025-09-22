package com.woniu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.exception.AccountIsDisabledException;
import com.woniu.exception.AccountIsLockedException;
import com.woniu.exception.TokenIsNullException;
import com.woniu.utils.ResponseResult;
import com.woniu.utils.ResultCode;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     * 单点登录失败的一些情况
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        ResponseResult result = null;
        e.printStackTrace();
        if(e instanceof TokenIsNullException){
            result = ResponseResult.error(ResultCode.TOKEN_IS_NULL);
        } else if (e instanceof AccountIsLockedException){
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof AccountIsDisabledException){
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_DISABLE);
        } else if(e instanceof UsernameNotFoundException){
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_NOT_EXIST);
        } else if (e instanceof AccountExpiredException) {
            //账号过期
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_EXPIRED);
        } else if (e instanceof BadCredentialsException) {
            //凭证不对   错误
            result = ResponseResult.error(ResultCode.USER_CREDENTIALS_ERROR);
        } else if (e instanceof CredentialsExpiredException) {
            //密码过期
            result = ResponseResult.error(ResultCode.USER_CREDENTIALS_EXPIRED);
        } else if (e instanceof DisabledException) {
            //账号不可用
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_DISABLE);
        } else if (e instanceof LockedException) {
            //账号锁定
            result = ResponseResult.error(ResultCode.USER_ACCOUNT_LOCKED);
        } else if (e instanceof InternalAuthenticationServiceException) {
            //用户不存在
            if("UserDetailsService returned null, which is an interface contract violation".equals(e.getMessage())){
                result = ResponseResult.error(ResultCode.USER_ACCOUNT_NOT_EXIST);
            } else {
                result = new ResponseResult<String>(400,e.getMessage());
            }
        }else{
            result = ResponseResult.error(ResultCode.COMMON_FAIL);
        }

        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Method", "POST,GET");
        //输出JSON
        PrintWriter out = response.getWriter();
        out.write(new ObjectMapper().writeValueAsString(result));
        out.flush();
        out.close();
    }
}
