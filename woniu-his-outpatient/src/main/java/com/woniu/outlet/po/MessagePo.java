package com.woniu.outlet.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagePo {
    private Long id;

    private String exchange;

    private String routingKey;

    private String messageContent;

    private Integer status;

    private Integer retryCount;

    private Long version;
}