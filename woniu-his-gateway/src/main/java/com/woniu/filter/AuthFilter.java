package com.woniu.filter;



import com.woniu.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 授权guolv器
 */
@Component
@Order(1)
@Slf4j
public class AuthFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        String host = exchange.getRequest().getURI().getHost();     //请求ip
        String path = exchange.getRequest().getURI().getPath();     //请求路径
        ServerHttpRequest request = exchange.getRequest();
        if (request.getMethod().equals(HttpMethod.OPTIONS)) {    //预检放行
            return chain.filter(exchange);
        }
        HttpHeaders headers = request.getHeaders();
        log.info("请求ip:" + host);
        log.info("请求路径:" + path);
        String jsonStr = "{\"status\":\"-1\", \"msg\":\"you have no right\"}";
        byte[] bytes = jsonStr.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
        if (path.equals("/login")) {
            log.info("login operate!--登录操作：放行 ");
            return chain.filter(exchange);
        } else {
            try {
                log.info("是否有token:" + headers.containsKey("token"));
                List<String> list = headers.get("token");
                boolean auth = auth(list, path);
                if (auth == true) {
                    return chain.filter(exchange);
                } else {
                    return exchange.getResponse().writeWith(Flux.just(buffer));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return exchange.getResponse().writeWith(Flux.just(buffer));
            }
        }
    }

    /**
     * 校验token 是否存在、是否为空、是否合法
     *
     * @param list token集合
     * @param path 路径
     * @return
     */
    public boolean auth(List<String> list, String path) {
        if (list == null || list.size() == 0) {
            return false;
        }
        String token = list.get(0);
        boolean flag = JwtTokenUtil.checkSign(token);
        return flag;
    }
}
