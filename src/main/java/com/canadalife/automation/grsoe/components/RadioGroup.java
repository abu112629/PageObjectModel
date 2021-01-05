package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;

import java.util.List;

public class RadioGroup extends VlocityComponent {

    @Override
    protected void init() {
    }

    @Override
    public void setValue() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//input[@value='" + getData() + "']/.."));
        if (!els.isEmpty()) {
            els.get(0).click();
            return;
        }
        els = coreElement.findElements(By.xpath("//input[.='" + getData() + "']/.."));
        if (!els.isEmpty()) {
            els.get(0).click();
        } else {
            throw new RuntimeException("Value '" + getData() + "' is not found for RadioGroup component");
        }

    }

    @Override
    public String getValue() {
        boolean valueMode = true;
        if (getData() != null) {
            List<WebElement> els = coreElement.findElements(By.xpath(".//input[@value='" + getData() + "']/.."));
            valueMode = !els.isEmpty();
        }
        List<WebElement> els = coreElement.findElements(By.xpath(".//input"));
        for (WebElement el : els) {
            if (el.isSelected()) {
                if (valueMode) {
                    return el.getAttribute("value");
                } else {
                    return el.getText();
                }
            }
        }
        return null;
    }

    @Override
    public void validateData(DataTypes validationMethod) {
        Assertions.assertThat(getValue()).isEqualTo(validationMethod.getData(this));
    }


}
