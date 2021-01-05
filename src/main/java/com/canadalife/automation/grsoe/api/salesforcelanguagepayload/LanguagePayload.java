package com.canadalife.automation.grsoe.api.salesforcelanguagepayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LanguageLocaleKey"
})
public class LanguagePayload {

    @JsonProperty("LanguageLocaleKey")
    public String languageLocaleKey;

    @JsonProperty("LanguageLocaleKey")
    public String getLanguageLocaleKey() {
        return languageLocaleKey;
    }

    @JsonProperty("LanguageLocaleKey")
    public void setLanguageLocaleKey(String languageLocaleKey) {
        this.languageLocaleKey = languageLocaleKey;
    }
}
