package com.ws.mq;


import java.util.Set;

public interface MessageHandler<T> {
    /**
     * 处理消息
     * @param message 消息内容
     * @param topic 主题
     * @return 处理结果
     */
    boolean handle(T message, String topic);
    
    /**
     * 支持的主题列表
     * @return 主题集合
     */
    Set<String> supportedTopics();
}
