package com.maimai.trigger.listener;

import com.alibaba.fastjson.JSON;
import com.maimai.domain.service.ILogAnalyticalService;
import com.maimai.sdk.model.LogMessage;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.listener.MessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class MonitorLogListener implements MessageListener<LogMessage> {
    @Resource
    private ILogAnalyticalService logAnalyticalService;

    @Override
    public void onMessage(CharSequence charSequence, LogMessage logMessage) {
        try {
            log.info("start monitoring: {}", JSON.toJSONString(logMessage));
            logAnalyticalService.doAnalytical(logMessage.getSystemName(), logMessage.getClassName(), logMessage.getMethodName(), logMessage.getLogList());

        } catch (Exception e) {
            log.error("start monitor failed: {}", JSON.toJSONString(logMessage));
        }
    }
}
