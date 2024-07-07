package com.maimai.sdk.push;

import com.maimai.sdk.model.LogMessage;

/**
 * @author maimai
 * @description
 * @create 2024/7/4
 */
public interface IPush {
    void open(String host, int port);

    void send(LogMessage logMessage);
}
