package com.woniu.filter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 限流过滤器
 */
@Component
@Slf4j
@Order(-1)
public class LimitStreamFilter implements GlobalFilter {

    // 如果要启动网关的多个实例，那么就需要将 ip 和桶的键值对信息存到 Redis 中。
    private static final Map<String, Bucket> LOCAL_CACHE = new ConcurrentHashMap<>();
    private int capacity; //桶容量
    private int refillTokens;//  定时添加token的数量  如每秒添加几个token
    private Duration refillDuration;//添加周期   周期 ： 如 每秒

    public LimitStreamFilter(int capacity, int refillTokens, Duration refillDuration) {
        this.capacity = capacity;
        this.refillTokens = refillTokens;
        this.refillDuration = refillDuration;
    }

    public LimitStreamFilter() {
        this(300, 300, Duration.ofSeconds(1));
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String host = exchange.getRequest().getURI().getHost();
        String path = exchange.getRequest().getURI().getPath();
        log.info("请求ip:" + host);
        log.info("请求路径:" + path);

        //当key存在时，不会重新赋值
        Bucket bucket = LOCAL_CACHE.computeIfAbsent(host + path, new Function<String, Bucket>() {
            @Override
            public Bucket apply(String s) {
                return createNewBucket();
            }
        });
        if (bucket.tryConsume(1)) {
            return chain.filter(exchange);
        } else {
            exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
            String jsonStr = "{\"status\":\"-1\", \"msg\":\"你的访问次数太频繁了\"}";
            byte[] bytes = jsonStr.getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
            return exchange.getResponse().writeWith(Flux.just(buffer));
        }
    }

    //生成一个桶
    private Bucket createNewBucket() {
        //每秒中生产一个token
        Refill refill = Refill.greedy(refillTokens, refillDuration);
        Bandwidth limit = Bandwidth.classic(capacity, refill);
        return Bucket4j.builder().addLimit(limit).build();
    }


}
