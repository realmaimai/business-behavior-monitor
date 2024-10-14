package cn.bugstack.monitor.test;

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
    public void test_log_00() throws InterruptedException {
        log.info("测试日志00 {} {} {}", user.getUserId(), user.getUserName(), JSON.toJSONString(user));
    }

    @Test
    public void test_log_01() throws InterruptedException {
        log.info("test01 {} {} {}", user.getUserId(), user.getUserName(), JSON.toJSONString(user));
    }

    @Test
    public void test_log_02() throws InterruptedException {
        log.info("test02 {} {} {}", user.getUserId(), user.getUserName(), JSON.toJSONString(user));
    }

    @Data
    static class UserEntity {
        private String userId;
        private String userName;
        private Integer userAge;
        private String orderId;
    }
}
