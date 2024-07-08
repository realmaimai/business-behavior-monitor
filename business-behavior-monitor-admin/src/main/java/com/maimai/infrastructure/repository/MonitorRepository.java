package com.maimai.infrastructure.repository;

import com.maimai.domain.model.entity.MonitorDataEntity;
import com.maimai.domain.model.valobj.GatherNodeExpressionVO;
import com.maimai.domain.repository.IMonitorRepository;

import java.util.Collections;
import java.util.List;

/**
 * @author win
 * @since 2024/7/9
 */
public class MonitorRepository implements IMonitorRepository {
    @Override
    public List<GatherNodeExpressionVO> queryGatherNodeExpressionVO(String systemName, String className, String methodName) {
        return Collections.emptyList();
    }

    @Override
    public String queryMonitorNameByMonitorId(String monitorId) {
        return "";
    }

    @Override
    public void saveMonitorData(MonitorDataEntity monitorDataEntity) {

    }
}
