package com.maimai.infrastructure.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 监控数据地图节点字段配置(MonitorDataMapNodeField) entity class
 *
 * @author maimai
 * @since 2024-07-08 02:09:21
 */
public class MonitorDataMapNodeField implements Serializable {
    private static final long serialVersionUID = 465312440737033730L;
    
    /**
     * 自增ID
     */
    private Long id;
    
    /**
     * 监控ID
     */
    private String monitorId;
    
    /**
     * 节点ID
     */
    private String monitorNodeId;
    
    /**
     * 日志名称；执行抽奖开始 userId
     */
    private String logName;
    
    /**
     * 解析顺序；第几个字段
     */
    private Integer logIndex;
    
    /**
     * 字段类型；Object、String
     */
    private String logType;
    
    /**
     * 属性名称
     */
    private String attributeName;
    
    /**
     * 属性字段
     */
    private String attributeField;
    
    /**
     * 解析公式
     */
    private String attributeOgnl;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

    public String getMonitorNodeId() {
        return monitorNodeId;
    }

    public void setMonitorNodeId(String monitorNodeId) {
        this.monitorNodeId = monitorNodeId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Integer getLogIndex() {
        return logIndex;
    }

    public void setLogIndex(Integer logIndex) {
        this.logIndex = logIndex;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeField() {
        return attributeField;
    }

    public void setAttributeField(String attributeField) {
        this.attributeField = attributeField;
    }

    public String getAttributeOgnl() {
        return attributeOgnl;
    }

    public void setAttributeOgnl(String attributeOgnl) {
        this.attributeOgnl = attributeOgnl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

