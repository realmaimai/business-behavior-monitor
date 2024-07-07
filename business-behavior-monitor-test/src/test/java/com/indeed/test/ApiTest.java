package com.indeed.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ApiTest {
    private UserEntity user = null;

    // @Before will run this method before every other method
    @Before
    public void init() {
        user = new UserEntity();
        user.setUserId("10001");
        user.setUserName("abc");
        user.setUserAge(25);
        user.setOrderId("109234158826");
    }

    @Test
    public void test_log_01() throws InterruptedException {
        log.info(user.toString());
        // Initialize CountDownLatch with a count of 1
        CountDownLatch latch = new CountDownLatch(1);

        // Use a separate thread to simulate the asynchronous logging completion
        new Thread(() -> {
            try {
                // Simulate processing time
                Thread.sleep(1000);

                // Process log messages and then count down the latch
                latch.countDown();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Wait for the latch to be counted down with a timeout
        boolean completed = latch.await(5, TimeUnit.SECONDS);

        if (!completed) {
            log.error("Timeout waiting for log processing to complete");
        }
    }

    @Data
    static class UserEntity {
        private String userId;
        private String userName;
        private Integer userAge;
        private String orderId;
    }
}
