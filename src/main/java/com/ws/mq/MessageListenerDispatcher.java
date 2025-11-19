package com.ws.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageListenerDispatcher {

    private static final Logger logger = LoggerFactory.getLogger(MessageListenerDispatcher.class);

    private final Map<String, MessageHandler<?>> handlerMap = new HashMap<>();

    public MessageListenerDispatcher(List<MessageHandler<?>> handlers) {
        for (MessageHandler<?> handler : handlers) {
            for (String topic : handler.supportedTopics()) {
                handlerMap.put(topic, handler);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> boolean dispatch(String topic, T message) {
        MessageHandler<T> handler = (MessageHandler<T>) handlerMap.get(topic);
        if (handler != null) {
            try {
                return handler.handle(message, topic);
            } catch (Exception e) {
                logger.error("处理消息失败, 主题: {}, 消息: {}", topic, message, e);
                return false;
            }
        } else {
            logger.warn("未找到主题 {} 的处理器", topic);
            return false;
        }
    }

}
