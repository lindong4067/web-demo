//
//
//package com.example.webdemo.esa;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.google.gson.annotations.SerializedName;
//import org.springframework.validation.annotation.Validated;
//
//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//
//public class AlarmDefinitionsRequest {
//
////    @SerializedName("module_id")
//    @JsonProperty("module_id")
//    @NotNull(message = "module is can not be null. ")
//    private String moduleId;
//
////    @SerializedName("error_code")
//    @JsonProperty("error_code")
//    private Integer errorCode;
//
////    @SerializedName("severity")
//    @JsonProperty("severity")
//    private Integer severity;
//
//    @JsonProperty("active")
//    @NotBlank(message = "active can not be null...")
//    private String active;
//
//    public String getModuleId() {
//        return moduleId;
//    }
//
//    public void setModuleId(String moduleId) {
//        this.moduleId = moduleId;
//    }
//
//    public Integer getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(Integer errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public Integer getSeverity() {
//        return severity;
//    }
//
//    public void setSeverity(Integer severity) {
//        this.severity = severity;
//    }
//
//    public String getActive() {
//        return active;
//    }
//
//    public void setActive(String active) {
//        this.active = active;
//    }
//}
