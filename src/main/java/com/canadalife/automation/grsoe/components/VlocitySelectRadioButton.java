package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;

public class VlocitySelectRadioButton extends VlocityComponent{

    @Override
    protected void init() {

    }

    @Override
    public void setValue() {
        WebElement button = coreElement.findElement(By.xpath(".//span[contains(text(),'" + getData() + "')]"));
        button.click();
    }

    @Override
    public String getValue() {
        return coreElement.findElement(By.xpath(".//span")).getAttribute("text");
    }

    @Override
    public void validateData(DataTypes validationMethod) {
        Assertions.assertThat(getValue()).isEqualTo(validationMethod.getData(this));
    }
}
