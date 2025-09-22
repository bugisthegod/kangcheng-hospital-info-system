package com.woniu.filter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.utils.JwtTokenUtil;
import com.woniu.utils.ResponseResult;
import com.woniu.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader("token");
        String path = request.getRequestURI();

        try {
            if (path.contains("doc.html") || path.contains(".js") || path.contains(".css")
                    || path.contains("swagger-resources") || path.contains("api-docs")|| path.contains("/outpatient/prescription/getPreById")||path.contains("/outpatient/prescription/getPrescriptionItemByPid")||path.contains("/charge/pay/add")) {
                filterChain.doFilter(request, response);
                return;
            }
            //请求未携带token，输出一个流到前端进行提示
            if (jwtToken == null) {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                ResponseResult result = ResponseResult.error(ResultCode.TOKEN_IS_NULL);
                out.write(new ObjectMapper().writeValueAsString(result));
                out.flush();
                out.close();
                return;
            }
            //校验token是否合法
            boolean flag = JwtTokenUtil.checkSign(jwtToken);
            if (!flag) {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                ResponseResult result = new ResponseResult(9000,"token非法");
                out.write(new ObjectMapper().writeValueAsString(result));
                out.flush();
                out.close();
                return;
            }

            String username = null;
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            username = JwtTokenUtil.getUserId(jwtToken);
            //从redis获取权限标识符
//            String str = stringRedisTemplate.opsForValue().get("HisPerms" + username);
            String str = stringRedisTemplate.opsForValue().get("HisPerms" + username);
            List<String> perms = new ArrayList<>();
            //将权限的一长串字符串处理成字符串集合，并将权限集合存放到SpringSecurity的容器grantedAuthorities中
            if (!StringUtils.isEmpty(str)) {
                System.out.println("从redis缓存取的");
                perms = objectMapper.readValue(str, new TypeReference<List<String>>() {
                });
            }
            //取出权限存入token
            perms.forEach(item -> grantedAuthorities.add(new SimpleGrantedAuthority(item)));
            /** 将权限容器grantedAuthorities封装到SpringSecurity的UsernamePasswordAuthenticationToken对象中去
             * UsernamePasswordAuthenticationToken该Token对象只存放认证通过的用户的信息，
             * 所以理论上前两个参数的用户名和密码可以随意填写，但是由于每个用户都有自己的权限集合，故这里的用户名不能写死，
             * 不然多个线程的不同的用户的权限集合会互相覆盖 **/
            UsernamePasswordAuthenticationToken xxx = new
                    UsernamePasswordAuthenticationToken(username, null, grantedAuthorities);
            //存入上下文
            SecurityContextHolder.getContext().setAuthentication(xxx);
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("xxxxxxx");
        }
    }
}
