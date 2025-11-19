package com.ws.mq;

import com.ws.mq.data.UserMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMessageHandle implements MessageHandler<UserMessage>{

    private static final Logger logger = LoggerFactory.getLogger(UserMessageHandle.class);

    @Override
    public Set<String> supportedTopics() {
        return Set.of("USER_TOPIC");
    }

    @Override
    public boolean handle(UserMessage message, String topic) {
        logger.info("处理用户消息: {}, 来自主题: {}", message, topic);
        // 具体业务逻辑处理
        return true;
    }
}
