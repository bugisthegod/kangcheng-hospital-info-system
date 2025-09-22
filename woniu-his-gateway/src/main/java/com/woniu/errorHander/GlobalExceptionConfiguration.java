package com.woniu.errorHander;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

/**
 * 异常处理器
 */
@Component
public class GlobalExceptionConfiguration implements ErrorWebExceptionHandler {
    ObjectMapper objectMapper=new ObjectMapper();


    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, Throwable throwable) {
        ServerHttpResponse response = serverWebExchange.getResponse();

        if (response.isCommitted()){
            return Mono.error(throwable);
        }
        // header set_json响应
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return response.writeWith(Mono.fromSupplier(new Supplier<DataBuffer>() {
            @Override
            public DataBuffer get() {
                DataBufferFactory bufferFactory = response.bufferFactory();
                try {
                    return bufferFactory.wrap(objectMapper.writeValueAsBytes(throwable.getMessage()));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                    return bufferFactory.wrap(new byte[0]);
                }
            }
        }));
    }
}
