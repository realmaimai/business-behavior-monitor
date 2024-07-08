package com.maimai.infrastructure.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 监控数据地图配置(MonitorDataMap) entity class
 *
 * @author maimai
 * @since 2024-07-08 02:08:38
 */
public class MonitorDataMap implements Serializable {
    private static final long serialVersionUID = -23666641527450873L;
    

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
     * 创建日期
     */
    private Date createTime;
    
    /**
     * 更新日期
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

