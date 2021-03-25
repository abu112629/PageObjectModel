package com.canadalife.automation.grsoe.api.salesforcetrusteepayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "attributes",
        "Trustee_First_Name__c",
        "Trustee_Last_Name__c",
        "Trustee_Relationship__c"
})
public class Record_trustee {

    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("Trustee_First_Name__c")
    private String trusteeFirstNameC;
    @JsonProperty("Trustee_Last_Name__c")
    private String trusteeLastNameC;
    @JsonProperty("Trustee_Relationship__c")
    private String trusteeRelationshipC;

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("Trustee_First_Name__c")
    public String getTrusteeFirstNameC() {
        return trusteeFirstNameC;
    }

    @JsonProperty("Trustee_First_Name__c")
    public void setTrusteeFirstNameC(String trusteeFirstNameC) {
        this.trusteeFirstNameC = trusteeFirstNameC;
    }

    @JsonProperty("Trustee_Last_Name__c")
    public String getTrusteeLastNameC() {
        return trusteeLastNameC;
    }

    @JsonProperty("Trustee_Last_Name__c")
    public void setTrusteeLastNameC(String trusteeLastNameC) {
        this.trusteeLastNameC = trusteeLastNameC;
    }

    @JsonProperty("Trustee_Relationship__c")
    public String getTrusteeRelationshipC() {
        return trusteeRelationshipC;
    }

    @JsonProperty("Trustee_Relationship__c")
    public void setTrusteeRelationshipC(String trusteeRelationshipC) {
        this.trusteeRelationshipC = trusteeRelationshipC;
    }

}
