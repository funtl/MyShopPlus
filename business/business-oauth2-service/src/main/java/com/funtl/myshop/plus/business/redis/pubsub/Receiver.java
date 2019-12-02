package com.funtl.myshop.plus.business.redis.pubsub;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Gjing
 * <p>
 * 消息监听者
 **/
@Slf4j
@Component
public class Receiver {

    public void receiveMessage(String message) {
        log.info("监听者1收到消息：{}", message);
    }
}
