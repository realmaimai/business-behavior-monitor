package com.maimai.domain.repository;

import com.maimai.domain.model.entity.MonitorDataEntity;
import com.maimai.domain.model.valobj.GatherNodeExpressionVO;

import java.util.List;

/**
 * @author win
 * @since 2024/7/8
 */
public interface IMonitorRepository {
    List<GatherNodeExpressionVO> queryGatherNodeExpressionVO(String systemName, String className, String methodName);

    String queryMonitorNameByMonitorId(String monitorId);

    void saveMonitorData(MonitorDataEntity monitorDataEntity);
}
