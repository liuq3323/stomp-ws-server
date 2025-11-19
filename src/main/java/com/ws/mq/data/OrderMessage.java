package com.ws.mq.data;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 后续定义消息类型 eg： K线消息 订单消息 账户消息 等等
 * msgType 后续定义为toUser or toAll
 * userId 发送的用户id
 * topic 用户订阅的topic
 */
@Data
public class OrderMessage {

    private String userId;

    private Integer msgType;

    private String data;

    private String topic;

}
