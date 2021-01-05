package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;

public class VlocitySelect extends VlocityComponent {

    @Override
    protected void init() {}

    @Override
    public void setValue() {
        coreElement.findElement(By.xpath(".//input")).click();
        WebElement country = coreElement.findElement(By.xpath(".//li/div[@data-label='" + getData() + "']"));
        country.click();
    }

    @Override
    public String getValue() {
        return coreElement.findElement(By.xpath(".//input")).getAttribute("value");
    }

    @Override
    public void validateData(DataTypes validationMethod) {
        Assertions.assertThat(getValue()).isEqualTo(validationMethod.getData(this));
    }
}
