package com.woniu.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.utils.JwtTokenUtil;
import com.woniu.utils.ResponseResult;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * 生成token返回给前端，同时我们可以把该用户的权限标识符查询出来存redis
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Method", "POST,GET");
            //输出JSON
            String username = request.getParameter("username");
            //生成token字符串
            String tokenStr = JwtTokenUtil.createSign(username);
            ResponseResult<String> result = new ResponseResult<>(tokenStr,"登陆成功",200);
            PrintWriter out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(result));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
