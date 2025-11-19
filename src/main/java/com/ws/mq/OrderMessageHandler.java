package com.ws.mq;

import com.ws.mq.data.OrderMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OrderMessageHandler implements MessageHandler<OrderMessage>{

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageHandler.class);
    @Override
    public boolean handle(OrderMessage message, String topic) {
        logger.info("处理订单消息: {}, 来自主题: {}", message, topic);
        // 具体业务逻辑处理

        // 发送消息 给用户
        return true;
    }

    @Override
    public Set<String> supportedTopics() {
        return Set.of("ORDER_TOPIC");
    }
}
