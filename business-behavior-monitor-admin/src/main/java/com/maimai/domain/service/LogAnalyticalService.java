package com.maimai.domain.service;

import com.alibaba.fastjson.JSONObject;
import com.maimai.domain.model.entity.MonitorDataEntity;
import com.maimai.domain.model.valobj.GatherNodeExpressionVO;
import com.maimai.domain.repository.IMonitorRepository;
import com.maimai.types.Constants;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author win
 * @since 2024/7/8
 */
public class LogAnalyticalService implements ILogAnalyticalService {

    @Resource
    private IMonitorRepository repository;

    @Override
    public void doAnalytical(String systemName, String className, String methodName, List<String> logList) throws OgnlException {
        List<GatherNodeExpressionVO> gatherNodeExpressionVOs = repository.queryGatherNodeExpressionVO(systemName, className, methodName);

        // no matched node
        if (null == gatherNodeExpressionVOs || gatherNodeExpressionVOs.isEmpty()) return;

        // handle each node
        for (GatherNodeExpressionVO node : gatherNodeExpressionVOs) {
            // get monitor name from monitor id
            String monitorName = repository.queryMonitorNameByMonitorId(node.getMonitorId());

            List<GatherNodeExpressionVO.Field> fields = node.getFields();
            for (GatherNodeExpressionVO.Field field : fields) {
                // need to know what is the index of the required log
                Integer logIndex = field.getLogIndex();
                // because we set the name of the log is the first one so
                String logName = logList.get(0);
                // check the log name from parameter and from log list are the same
                if (!logName.equals(field.getLogName())) continue;

                String logStr = logList.get(logIndex);

                String attributeValue = "";
                // check if the log type is Object or String, if Object then use OGNL
                if ("Object".equals(field.getLogType())) {
                    OgnlContext context = new OgnlContext();
                    context.setRoot(JSONObject.parse(logStr));
                    Object root = context.getRoot();
                    attributeValue = String.valueOf(Ognl.getValue(field.getAttributeOgnl(), context, root));
                } else {
                    attributeValue = logStr.trim();
                    if (attributeValue.contains(Constants.COLON))
                        attributeValue = attributeValue.split(Constants.COLON)[1].trim();

                }

                MonitorDataEntity monitorData = MonitorDataEntity.builder()
                        .monitorId(node.getMonitorId())
                        .monitorName(monitorName)
                        .monitorNodeId(node.getMonitorNodeId())
                        .systemName(systemName)
                        .clazzName(className)
                        .methodName(methodName)
                        .attributeName(field.getAttributeName())
                        .attributeField(field.getAttributeField())
                        .attributeValue(attributeValue)
                        .build();

                repository.saveMonitorData(monitorData);

            }
        }
    }
}
