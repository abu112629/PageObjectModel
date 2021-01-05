package com.canadalife.automation.grsoe.support;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("tuple")
public class LocatorAndValue {
    @XStreamAsAttribute
    private String xpath;
    @XStreamAsAttribute
    private String value;

    public String getLocator() {
        return xpath;
    }

    public String getValue() {
        return value;
    }
}
