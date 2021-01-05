package com.canadalife.automation.grsoe.api.salesforceassetpayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Plan_Id__c",
        "Division__c"
})

public class AssetPayload {

    @JsonProperty("Plan_Id__c")
    private String planIdC;
    @JsonProperty("Division__c")
    private String divisionC;

    @JsonProperty("Plan_Id__c")
    public String getPlanIdC() {
        return planIdC;
    }

    @JsonProperty("Plan_Id__c")
    public void setPlanIdC(String planIdC) {
        this.planIdC = planIdC;
    }

    @JsonProperty("Division__c")
    public String getDivisionC() {
        return divisionC;
    }

    @JsonProperty("Division__c")
    public void setDivisionC(String divisionC) {
        this.divisionC = divisionC;
    }

}
