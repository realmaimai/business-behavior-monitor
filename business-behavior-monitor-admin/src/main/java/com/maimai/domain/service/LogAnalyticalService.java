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

        if (null == gatherNodeExpressionVOs || gatherNodeExpressionVOs.isEmpty()) {
            return;
        }

        for (GatherNodeExpressionVO gatherNodeExpressionVO : gatherNodeExpressionVOs) {
            String monitorName = repository.queryMonitorNameByMonitorId(gatherNodeExpressionVO.getMonitorId());

            List<GatherNodeExpressionVO.Field> fields = gatherNodeExpressionVO.getFields();
            for (GatherNodeExpressionVO.Field field : fields) {
                Integer logIndex = field.getLogIndex();

                String logName = logList.get(0);
                if (!logName.equals(field.getLogName())) {
                    continue;
                }

                String attributeValue = "";
                String logStr = logList.get(logIndex);
                if ("Object".equals(field.getLogType())) {
                    OgnlContext context = new OgnlContext();
                    context.setRoot(JSONObject.parseObject(logStr));
                    Object root = context.getRoot();
                    attributeValue = String.valueOf(Ognl.getValue(field.getAttributeOgnl(), context, root));
                } else {
                    attributeValue = logStr.trim();
                    // xxx:xxx
                    if (attributeValue.contains(Constants.COLON)) {
                        attributeValue = attributeValue.split(Constants.COLON)[1].trim();
                    }
                }

                MonitorDataEntity monitorDataEntity = MonitorDataEntity.builder()
                        .monitorId(gatherNodeExpressionVO.getMonitorId())
                        .monitorName(monitorName)
                        .monitorNodeId(gatherNodeExpressionVO.getMonitorNodeId())
                        .systemName(gatherNodeExpressionVO.getGatherSystemName())
                        .clazzName(gatherNodeExpressionVO.getGatherClazzName())
                        .methodName(gatherNodeExpressionVO.getGatherMethodName())
                        .attributeName(field.getAttributeName())
                        .attributeField(field.getAttributeField())
                        .attributeValue(attributeValue)
                        .build();

                repository.saveMonitorData(monitorDataEntity);
            }
        }
    }
}
