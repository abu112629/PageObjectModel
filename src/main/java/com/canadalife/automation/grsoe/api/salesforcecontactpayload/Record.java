package com.canadalife.automation.grsoe.api.salesforcecontactpayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "attributes",
        "AccountId",
        "Name",
        "Relationship__c"
})
public class Record {
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Relationship__c")
    private String relationshipC;

    @JsonProperty("attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("AccountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("AccountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Relationship__c")
    public String getRelationshipC() {
        return relationshipC;
    }

    @JsonProperty("Relationship__c")
    public void setRelationshipC(String relationshipC) {
        this.relationshipC = relationshipC;
    }

}
