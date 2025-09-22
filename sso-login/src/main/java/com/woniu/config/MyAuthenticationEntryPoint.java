package com.woniu.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.exception.AccountIsLockedException;
import com.woniu.utils.ResponseResult;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {



        ResponseResult<String> result = new ResponseResult<String>("","用户未登陆",502);
        if  (e instanceof AccountIsLockedException){
            result = new ResponseResult<String>("",e.getMessage(),400);
        }
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }
}
