package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;

public class VlocityMaskedCheckBox extends VlocityComponent {

    @Override
    protected void init() {}

    @Override
    public void setValue() {
        WebElement checkBox = coreElement.findElement(By.xpath(".//span[contains(text(),'"+getData()+"')]"));
        checkBox.click();
    }

    @Override
    public String getValue() {
        return coreElement.findElement(By.xpath(".//span")).getAttribute("value");
    }

    @Override
    public void validateData(DataTypes validationMethod) {
        Assertions.assertThat(getValue()).isEqualTo(validationMethod.getData(this));
    }
}
