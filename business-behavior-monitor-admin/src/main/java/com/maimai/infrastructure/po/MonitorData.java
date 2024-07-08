package com.maimai.infrastructure.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 监控数据(MonitorData) entity class
 *
 * @author maimai
 * @since 2024-07-08 02:08:14
 */
public class MonitorData implements Serializable {
    private static final long serialVersionUID = -34128826329795222L;
    
    /**
     * 自增ID
     */
    private Long id;
    
    /**
     * 监控ID
     */
    private String monitorId;
    
    /**
     * 监控名称
     */
    private String monitorName;
    
    /**
     * 节点ID
     */
    private String monitorNodeId;
    
    /**
     * 系统名称
     */
    private String systemName;
    
    /**
     * 类的名称
     */
    private String clazzName;
    
    /**
     * 方法名称
     */
    private String methodName;
    
    /**
     * 属性名称
     */
    private String attributeName;
    
    /**
     * 属性字段
     */
    private String attributeField;
    
    /**
     * 属性的值
     */
    private String attributeValue;
    
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

    public String getMonitorName() {
        return monitorName;
    }

    public void setMonitorName(String monitorName) {
        this.monitorName = monitorName;
    }

    public String getMonitorNodeId() {
        return monitorNodeId;
    }

    public void setMonitorNodeId(String monitorNodeId) {
        this.monitorNodeId = monitorNodeId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
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

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
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

