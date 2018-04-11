

package com.example.webdemo.dom4j;

import com.google.gson.annotations.SerializedName;


public class AlarmSpecification {

    @SerializedName("module_id")
    private String moduleId;

    @SerializedName("error_code")
    private Integer errorCode;

    @SerializedName("severity")
    private Integer severity;

    @SerializedName("model_description")
    private String modelDescription;

    @SerializedName("active_description")
    private String activeDescription;

    @SerializedName("event_type")
    private String eventType;

    @SerializedName("probable_cause")
    private String probableCause;

    @SerializedName("active")
    private String active;

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public String getActiveDescription() {
        return activeDescription;
    }

    public void setActiveDescription(String activeDescription) {
        this.activeDescription = activeDescription;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getProbableCause() {
        return probableCause;
    }

    public void setProbableCause(String probableCause) {
        this.probableCause = probableCause;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

}
