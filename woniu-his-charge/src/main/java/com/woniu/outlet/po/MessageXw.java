package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageXw {
    private Long id;
    private String exchange;
    private String routingKey;
    private String messageContent;
    private String status;
    private Integer retryCount;
    private Long version;

    public final static String NOT_SEND = "1"; //未发送
    public final static String SEND = "2"; //已发送
    public final static String ROUTE_ERROR = "3"; //路由错误
}