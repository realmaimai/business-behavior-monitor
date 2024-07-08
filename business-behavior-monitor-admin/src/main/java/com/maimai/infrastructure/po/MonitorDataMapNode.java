package com.maimai.infrastructure.po;

import java.util.Date;
import java.io.Serializable;

/**
 * 监控数据地图节点配置(MonitorDataMapNode) entity class
 *
 * @author maimai
 * @since 2024-07-08 02:08:46
 */
public class MonitorDataMapNode implements Serializable {
    private static final long serialVersionUID = -93440543173881441L;
    
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
     * 节点名称
     */
    private String monitorNodeName;
    
    /**
     * 采集，系统名称
     */
    private String gatherSystemName;
    
    /**
     * 采集，类的名称
     */
    private String gatherClazzName;
    
    /**
     * 采集，方法名称
     */
    private String gatherMethodName;
    
    /**
     * 渲染节点坐标
     */
    private String loc;
    
    /**
     * 节点颜色
     */
    private String color;
    
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

    public String getMonitorNodeName() {
        return monitorNodeName;
    }

    public void setMonitorNodeName(String monitorNodeName) {
        this.monitorNodeName = monitorNodeName;
    }

    public String getGatherSystemName() {
        return gatherSystemName;
    }

    public void setGatherSystemName(String gatherSystemName) {
        this.gatherSystemName = gatherSystemName;
    }

    public String getGatherClazzName() {
        return gatherClazzName;
    }

    public void setGatherClazzName(String gatherClazzName) {
        this.gatherClazzName = gatherClazzName;
    }

    public String getGatherMethodName() {
        return gatherMethodName;
    }

    public void setGatherMethodName(String gatherMethodName) {
        this.gatherMethodName = gatherMethodName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

