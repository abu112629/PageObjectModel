package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import ui.auto.core.data.DataTypes;
import ui.auto.core.utils.WebHelper;

import java.util.List;

public class RadioActionGroup extends VlocityComponent {

    @Override
    protected void init() {
    }

    @Override
    public void setValue() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//input[@value='" + getData() + "']"));
        ((JavascriptExecutor) WebHelper.getWebDriver()).executeScript("arguments[0].click();", els.get(0));
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
