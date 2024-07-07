package com.maimai.sdk.push;

import com.alibaba.fastjson.JSON;
import com.maimai.sdk.model.LogMessage;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.api.listener.MessageListener;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author maimai
 * @description use sub and pub in redis to push log message
 * @create 2024/7/4
 */
public class RedisPush implements IPush{
    private final Logger logger = LoggerFactory.getLogger(RedisPush.class);

    private RedissonClient redissonClient;

    @Override
    public synchronized void open(String host, int port) {
        if (null != redissonClient && !redissonClient.isShutdown()) return;
        Config config = new Config();
        config.setCodec(JsonJacksonCodec.INSTANCE);
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port)
                .setConnectionPoolSize(64)
                .setConnectionMinimumIdleSize(10)
                .setIdleConnectionTimeout(1000)
                .setConnectTimeout(1000)
                .setRetryAttempts(3)
                .setRetryInterval(1000)
                .setPingConnectionInterval(0)
                .setKeepAlive(true);


        redissonClient = Redisson.create(config);
        System.out.println("Redisson init success");

        RTopic topic = redissonClient.getTopic("business-behavior-monitor-sdk-topic");
        topic.addListener(LogMessage.class, new Listener());
    }

    class Listener implements MessageListener<LogMessage> {

        @Override
        public void onMessage(CharSequence charSequence, LogMessage logMessage) {
            System.out.println("receive log message: " + JSON.toJSONString(logMessage));
        }
    }

    @Override
    public void send(LogMessage logMessage) {
        try {
            RTopic topic = redissonClient.getTopic("business-behavior-monitor-sdk-topic");
            topic.publish(logMessage);
        } catch (Exception e) {
            logger.error("error: topic publish failed ", e);
        }
    }

}
