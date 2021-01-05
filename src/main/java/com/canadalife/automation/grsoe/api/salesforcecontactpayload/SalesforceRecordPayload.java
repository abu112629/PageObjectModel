package com.canadalife.automation.grsoe.api.salesforcecontactpayload;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "totalSize",
            "done",
            "records"
    })
    public class SalesforceRecordPayload {

        @JsonProperty("totalSize")
        private Integer totalSize;
        @JsonProperty("done")
        private Boolean done;
        @JsonProperty("records")
        private List<Record> records = null;

        @JsonProperty("totalSize")
        public Integer getTotalSize() {
            return totalSize;
        }

        @JsonProperty("totalSize")
        public void setTotalSize(Integer totalSize) {
            this.totalSize = totalSize;
        }

        @JsonProperty("done")
        public Boolean getDone() {
            return done;
        }

        @JsonProperty("done")
        public void setDone(Boolean done) {
            this.done = done;
        }

        @JsonProperty("records")
        public List<Record> getRecords() {
            return records;
        }

        @JsonProperty("records")
        public void setRecords(List<Record> records) {
            this.records = records;
        }

    }


