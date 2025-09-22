//package com.woniu.config;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Collection;
//
//@Configuration
//@Slf4j
//public class FeignConfiguration implements RequestInterceptor {
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String token = request.getHeader("token"); // HeaderConstants.TOKEN_HEADER_NAME 替换为自己的请求头名称，下同
//        if(token == null){
//            log.info("--请求中未携带token.......");
//            return;
//        }
//        requestTemplate.header("token", token);
//    }
//}
