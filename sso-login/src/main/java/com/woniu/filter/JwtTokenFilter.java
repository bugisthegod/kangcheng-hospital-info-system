package com.woniu.filter;



import com.woniu.config.MyAuthenticationFailureHandler;
import com.woniu.exception.TokenIsInvalidException;
import com.woniu.exception.TokenIsNullException;
import com.woniu.outlet.dao.WorkerPoMapper;
import com.woniu.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private WorkerPoMapper workerPoMapper;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //拿到头信息中的token
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) {
                //判断是不是登录
                String path = request.getRequestURI();
                if (path.equals("/login") || path.equals("/static/login.html") || path.equals("/returnUrl")) {
                    //是登录就放行
                    filterChain.doFilter(request, response);
                } else {
                    //throw new TokenIsNullException("token is null");
                    myAuthenticationFailureHandler.onAuthenticationFailure(request, response, new TokenIsNullException("token is null"));
                }
                //有token则校验
            } else if (JwtTokenUtil.checkSign(jwtToken)) {
                String username = JwtTokenUtil.getUserId(jwtToken);
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                List<String> perms = workerPoMapper.findPermsByName(username);
                //取出权限，存入token
                perms.forEach(item -> {
                    grantedAuthorities.add(new SimpleGrantedAuthority(item));
                });
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, grantedAuthorities);
                //存入上下文
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            myAuthenticationFailureHandler.onAuthenticationFailure(request, response, new TokenIsInvalidException("token is invalid"));
            // response.setContentType("application/json;charset=utf-8");
            // PrintWriter out = response.getWriter();
            // ResponseResult result = ResponseResult.error(ResultCode.TOKEN_INVALID);
            // out.write(new ObjectMapper().writeValueAsString(result));
            // out.flush();
            // out.close();
        }

    }
}
