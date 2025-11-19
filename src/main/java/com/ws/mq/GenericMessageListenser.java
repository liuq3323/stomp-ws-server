package com.ws.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "*", consumerGroup = "ws-consumer-group")
public class GenericMessageListenser implements RocketMQListener<MessageExt> {

    @Autowired
    private MessageListenerDispatcher messageListenerDispatcher;
    @Override
    public void onMessage(MessageExt messageExt) {
        String topic = messageExt.getTopic();
        String body = new String(messageExt.getBody());

        // 通过分发器处理消息
        messageListenerDispatcher.dispatch(topic, body);

    }
}
