package com.maimai.domain.model.valobj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GatherNodeExpressionVO {
    private String monitorId;
    private String monitorNodeId;
    private String gatherSystemName;
    private String gatherClazzName;
    private String gatherMethodName;
    private List<Field> fields;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Field{
        private String logName;
        private Integer logIndex;
        private String logType;
        private String attributeName;
        private String attributeField;
        private String attributeOgnl;
    }
}
