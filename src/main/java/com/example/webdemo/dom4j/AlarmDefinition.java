

package com.example.webdemo.dom4j;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AlarmDefinition {

    private List<AlarmSpecification> alarmSpecification;

    public List<AlarmSpecification> getAlarmSpecification() {
        return alarmSpecification;
    }

    public void setAlarmSpecification(List<AlarmSpecification> alarmSpecification) {
        this.alarmSpecification = alarmSpecification;
    }

    public static class AlarmSpecification {

        @JsonProperty("module_id")
        private String moduleId;

        @JsonProperty("error_code")
        private Integer errorCode;

        @JsonProperty("severity")
        private Integer severity;

        @JsonProperty("model_description")
        private String modelDescription;

        @JsonProperty("active_description")
        private String activeDescription;

        @JsonProperty("event_type")
        private String eventType;

        @JsonProperty("probable_cause")
        private String probableCause;

        @JsonProperty("active")
        private String active;

        @JsonProperty("documentation")
        private AlarmDefinition.AlarmSpecification.Documentation documentation;

        public Documentation getDocumentation() {
            return documentation;
        }

        public void setDocumentation(Documentation documentation) {
            this.documentation = documentation;
        }

        private static class Documentation {

            @JsonProperty("description")
            private String description;

            @JsonProperty("alarming_object")
            private String alarmingObject;

            @JsonProperty("raised_by")
            private String raisedBy;

            @JsonProperty("cleared_by")
            private String clearedBy;

            @JsonProperty("proposed_repair_action")
            private String proposedRepairAction;

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getAlarmingObject() {
                return alarmingObject;
            }

            public void setAlarmingObject(String alarmingObject) {
                this.alarmingObject = alarmingObject;
            }

            public String getRaisedBy() {
                return raisedBy;
            }

            public void setRaisedBy(String raisedBy) {
                this.raisedBy = raisedBy;
            }

            public String getClearedBy() {
                return clearedBy;
            }

            public void setClearedBy(String clearedBy) {
                this.clearedBy = clearedBy;
            }

            public String getProposedRepairAction() {
                return proposedRepairAction;
            }

            public void setProposedRepairAction(String proposedRepairAction) {
                this.proposedRepairAction = proposedRepairAction;
            }
        }

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


}
