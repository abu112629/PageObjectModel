package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;

public class VlocityAccordion extends VlocityComponent{
    @Override
    protected void init() {

    }

    @Override
    public void setValue() {
       WebElement accordiondrodown= coreElement.findElement(By.xpath(".//button/span[@title='" + getData() + "']"));
       accordiondrodown.click();
    }

    @Override
    public String getValue() {
        return coreElement.findElement(By.xpath(".//button/span")).getAttribute("title");
    }

    @Override
    public void validateData(DataTypes validationMethod) {
        Assertions.assertThat(getValue()).isEqualTo(validationMethod.getData(this));
    }
}
