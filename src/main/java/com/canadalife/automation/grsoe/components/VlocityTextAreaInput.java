package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;

public class VlocityTextAreaInput extends VlocityComponent{
    @Override
    protected void init() {

    }

    @Override
    public void setValue() {
        WebElement input = coreElement.findElement(By.xpath("//textarea"));
        input.clear();
        input.sendKeys(getData());
    }

    @Override
    public String getValue() {
        WebElement input = coreElement.findElement(By.xpath("//textarea"));
        String value = input.getAttribute("value");
        if (value == null) {
            value = input.getText();
        }
        return value;
    }

    @Override
    public void validateData(DataTypes validationMethod) {
        Assertions.assertThat(getValue()).isEqualTo(validationMethod.getData(this));
    }
}
