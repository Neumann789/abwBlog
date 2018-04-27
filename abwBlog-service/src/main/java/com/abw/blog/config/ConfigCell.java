package com.abw.blog.config;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by fanghuabao on 2018/4/26 0026.
 * 配置单元类
 */
public class ConfigCell {

    private Long id;

    private String configType;

    private String configTypeName;

    private String configKey;

    private String configVal;

    private Long priority;

    private Long parentConfigId;

    private String createBy;

    private Date createTime;

    private String modifyBy;

    private Date modifyTime;

    private Map<String,String> extMap;

    private List<ConfigCell> childList;

    public Long getParentConfigId() {
        return parentConfigId;
    }

    public void setParentConfigId(Long parentConfigId) {
        this.parentConfigId = parentConfigId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigType() {
        return configType;
    }

    public void setConfigType(String configType) {
        this.configType = configType;
    }

    public String getConfigTypeName() {
        return configTypeName;
    }

    public void setConfigTypeName(String configTypeName) {
        this.configTypeName = configTypeName;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigVal() {
        return configVal;
    }

    public void setConfigVal(String configVal) {
        this.configVal = configVal;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }

    public List<ConfigCell> getChildList() {
        return childList;
    }

    public void setChildList(List<ConfigCell> childList) {
        this.childList = childList;
    }
}
