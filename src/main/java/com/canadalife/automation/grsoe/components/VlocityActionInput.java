package com.canadalife.automation.grsoe.components;

import com.canadalife.automation.grsoe.support.AppHelper;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.auto.core.data.DataTypes;
import ui.auto.core.utils.WebHelper;

public class    VlocityActionInput extends VlocityComponent{

    @Override
    protected void init() {

    }

    @Override
    public void setValue() {
        WebElement input = coreElement.findElement(By.xpath(".//input"));
        input.clear();
        AppHelper.waitForXHR(1);
        Actions action = new Actions(WebHelper.getWebDriver());
        action.sendKeys(input,getData()).build().perform();
    }

    @Override
    public String getValue() {
        WebElement input = coreElement.findElement(By.xpath(".//input"));
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
