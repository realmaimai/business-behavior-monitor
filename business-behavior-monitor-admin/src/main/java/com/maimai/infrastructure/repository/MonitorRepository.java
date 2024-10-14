package com.maimai.infrastructure.repository;

import com.maimai.domain.model.entity.MonitorDataEntity;
import com.maimai.domain.model.valobj.GatherNodeExpressionVO;
import com.maimai.domain.repository.IMonitorRepository;
import com.maimai.infrastructure.dao.*;
import com.maimai.infrastructure.po.MonitorData;
import com.maimai.infrastructure.po.MonitorDataMapNode;
import com.maimai.infrastructure.po.MonitorDataMapNodeField;
import com.maimai.infrastructure.redis.IRedisService;
import com.maimai.types.Constants;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class MonitorRepository implements IMonitorRepository {

    @Resource
    private IMonitorDataDao monitorDataDao;
    @Resource
    private IMonitorDataMapDao monitorDataMapDao;
    @Resource
    private IMonitorDataMapNodeDao monitorDataMapNodeDao;
    @Resource
    private IMonitorDataMapNodeFieldDao monitorDataMapNodeFieldDao;
    @Resource
    private IMonitorDataMapNodeLinkDao monitorDataMapNodeLinkDao;
    @Resource
    private IRedisService redisService;


    @Override
    public List<GatherNodeExpressionVO> queryGatherNodeExpressionVO(String systemName, String className, String methodName) {
        MonitorDataMapNode monitorDataMapNodeReq = new MonitorDataMapNode();
        monitorDataMapNodeReq.setGatherSystemName(systemName);
        monitorDataMapNodeReq.setGatherClazzName(className);
        monitorDataMapNodeReq.setGatherMethodName(methodName);
        List<MonitorDataMapNode> monitorDataMapNodes = monitorDataMapNodeDao.queryMonitorDataMapNodeList(monitorDataMapNodeReq);
        if (monitorDataMapNodes.isEmpty()) return null;

        List<GatherNodeExpressionVO> gatherNodeExpressionVOList = new ArrayList();
        for (MonitorDataMapNode node : monitorDataMapNodes) {
            MonitorDataMapNodeField monitorDataMapNodeFieldReq = new MonitorDataMapNodeField();
            monitorDataMapNodeFieldReq.setMonitorId(node.getMonitorId());
            monitorDataMapNodeFieldReq.setMonitorNodeId(node.getMonitorNodeId());
            List<MonitorDataMapNodeField> monitorDataMapNodeFieldList = monitorDataMapNodeFieldDao.queryMonitorDataMapNodeList(monitorDataMapNodeFieldReq);

            List<GatherNodeExpressionVO.Field> fieldList = new ArrayList();
            for (MonitorDataMapNodeField field : monitorDataMapNodeFieldList) {
                fieldList.add(GatherNodeExpressionVO.Field.builder()
                        .logName(field.getLogName())
                        .logIndex(field.getLogIndex())
                        .logType(field.getLogType())
                        .attributeField(field.getAttributeField())
                        .attributeName(field.getAttributeName())
                        .attributeOgnl(field.getAttributeOgnl())
                        .build());

            }

            gatherNodeExpressionVOList.add(GatherNodeExpressionVO.builder()
                    .monitorId(node.getMonitorId())
                    .monitorNodeId(node.getMonitorNodeId())
                    .gatherSystemName(node.getGatherSystemName())
                    .gatherClazzName(node.getGatherClazzName())
                    .gatherMethodName(node.getGatherMethodName())
                    .fields(fieldList)
                    .build());
        }
        return gatherNodeExpressionVOList;
    }

    @Override
    public String queryMonitorNameByMonitorId(String monitorId) {
        return monitorDataMapDao.queryMonitorNameByMonitorId(monitorId);
    }

    @Override
    public void saveMonitorData(MonitorDataEntity monitorDataEntity) {
        MonitorData monitorDataReq = new MonitorData();
        monitorDataReq.setMonitorId(monitorDataEntity.getMonitorId());
        monitorDataReq.setMonitorName(monitorDataEntity.getMonitorName());
        monitorDataReq.setMonitorNodeId(monitorDataEntity.getMonitorNodeId());
        monitorDataReq.setSystemName(monitorDataEntity.getSystemName());
        monitorDataReq.setClazzName(monitorDataEntity.getClazzName());
        monitorDataReq.setMethodName(monitorDataEntity.getMethodName());
        monitorDataReq.setAttributeName(monitorDataEntity.getAttributeName());
        monitorDataReq.setAttributeField(monitorDataEntity.getAttributeField());
        monitorDataReq.setAttributeValue(monitorDataEntity.getAttributeValue());
        monitorDataDao.insert(monitorDataReq);

        String cacheKey = Constants.RedisKey.monitor_node_data_count_key + monitorDataEntity.getMonitorId() + Constants.UNDERLINE + monitorDataEntity.getMonitorNodeId();
        redisService.incr(cacheKey);
    }
}
