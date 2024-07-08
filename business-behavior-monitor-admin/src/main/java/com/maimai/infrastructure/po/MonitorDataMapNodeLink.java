package com.maimai.infrastructure.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 监控数据地图节点链路配置(MonitorDataMapNodeLink) entity class
 *
 * @author maimai
 * @since 2024-07-08 02:09:29
 */
public class MonitorDataMapNodeLink implements Serializable {
    private static final long serialVersionUID = 472175244073365211L;
    

    private Long id;
    
    /**
     * 监控ID
     */
    private String monitorId;
    
    /**
     * from 监控ID
     */
    private String fromMonitorNodeId;
    
    /**
     * to 监控ID
     */
    private String toMonitorNodeId;
    
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

    public String getFromMonitorNodeId() {
        return fromMonitorNodeId;
    }

    public void setFromMonitorNodeId(String fromMonitorNodeId) {
        this.fromMonitorNodeId = fromMonitorNodeId;
    }

    public String getToMonitorNodeId() {
        return toMonitorNodeId;
    }

    public void setToMonitorNodeId(String toMonitorNodeId) {
        this.toMonitorNodeId = toMonitorNodeId;
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

