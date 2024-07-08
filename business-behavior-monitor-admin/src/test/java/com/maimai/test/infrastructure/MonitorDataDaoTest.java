package com.maimai.test.infrastructure;

import com.alibaba.fastjson.JSON;
import com.maimai.infrastructure.PageRequest;
import com.maimai.infrastructure.dao.IMonitorDataDao;
import com.maimai.infrastructure.po.MonitorData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author win
 * @description
 * @create 2024/7/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class MonitorDataDaoTest {
    @Resource
    private IMonitorDataDao monitorDataDao;

    @Test
    public void test_queryAllByLimit() {
        MonitorData monitorData = new MonitorData();
        monitorData.setMonitorName("大营销抽奖流程");
        PageRequest pageRequest = PageRequest.of(1, 10);
        List<MonitorData> monitorDataList = monitorDataDao.queryAllByLimit(monitorData, pageRequest);
        log.info(JSON.toJSONString(monitorDataList));
    }

    @Test
    public void test_queryById() {
        MonitorData monitorData = monitorDataDao.queryById(1L);
        System.out.println(monitorData.getMonitorName());
    }
}
