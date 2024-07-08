package com.maimai.trigger.listener;

import com.alibaba.fastjson.JSON;
import com.maimai.sdk.model.LogMessage;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.listener.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author win
 * @since 2024/7/8
 */
@Slf4j
@Component
public class MonitorLogListener implements MessageListener<LogMessage> {

    @Override
    public void onMessage(CharSequence charSequence, LogMessage logMessage) {
        try {
            log.info("listening monitor log message: {}", JSON.toJSONString(logMessage));
        } catch ( Exception e ) {
            log.error("listening monitor log message failed: {}", JSON.toJSONString(logMessage), e);
        }
    }
}
