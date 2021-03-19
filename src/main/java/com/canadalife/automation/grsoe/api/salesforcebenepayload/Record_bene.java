package com.canadalife.automation.grsoe.api.salesforcebenepayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"attributes",
"Allocation__c",
"Asset_Role__c",
"Revocable__c"
})
public class Record_bene {

@JsonProperty("attributes")
private Attributes attributes;
@JsonProperty("Allocation__c")
private Float allocationC;
@JsonProperty("Asset_Role__c")
private String assetRoleC;
@JsonProperty("Revocable__c")
private Boolean revocableC;

@JsonProperty("attributes")
public Attributes getAttributes() {
return attributes;
}

@JsonProperty("attributes")
public void setAttributes(Attributes attributes) {
this.attributes = attributes;
}

@JsonProperty("Allocation__c")
public Float getAllocationC() {
return allocationC;
}

@JsonProperty("Allocation__c")
public void setAllocationC(Float allocationC) {
this.allocationC = allocationC;
}

@JsonProperty("Asset_Role__c")
public String getAssetRoleC() {
return assetRoleC;
}

@JsonProperty("Asset_Role__c")
public void setAssetRoleC(String assetRoleC) {
this.assetRoleC = assetRoleC;
}

@JsonProperty("Revocable__c")
public Boolean getRevocableC() {
return revocableC;
}

@JsonProperty("Revocable__c")
public void setRevocableC(Boolean revocableC) {
this.revocableC = revocableC;
}

}