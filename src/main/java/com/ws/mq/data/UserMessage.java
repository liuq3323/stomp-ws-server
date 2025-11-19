package com.ws.mq.data;

import lombok.Data;

@Data
public class UserMessage {

    private String userId;

    private Integer msgType;

    private String data;

    private String topic;
}
