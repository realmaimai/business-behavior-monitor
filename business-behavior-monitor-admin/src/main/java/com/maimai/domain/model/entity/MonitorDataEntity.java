package com.maimai.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author win
 * @since 2024/7/9
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDataEntity {
    private String monitorId;
    private String monitorName;
    private String monitorNodeId;
    private String systemName;
    private String clazzName;
    private String methodName;
    private String attributeName;
    private String attributeField;
    private String attributeValue;
}
