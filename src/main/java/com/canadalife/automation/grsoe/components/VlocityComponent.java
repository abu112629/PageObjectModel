package com.canadalife.automation.grsoe.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;
import ui.auto.core.utils.WebHelper;

import java.util.List;

public abstract class VlocityComponent extends PageComponent {

    public String getErrorMsg() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//*[contains(@class,'form-element__help')]"));
        if (els.isEmpty()) {
            return null;
        } else {
            return els.get(0).getText();
        }
    }

    public void validateError(DataTypes type) {
        String actual = getErrorMsg();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getAccordionContent() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//*[@class='nds-accordion__content']"));
        if (els.isEmpty()) {
            return null;
        } else {
            return els.get(0).getText();
        }
    }

    public void validateAccordionContent(DataTypes type) {
        String actual = getAccordionContent();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getContributionHeader() {
        WebElement els=coreElement.findElement(By.xpath(".//span[contains(@class,'nds-m-right_x-small')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateContributionHeader(DataTypes type) {
        String actual = getContributionHeader();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getContributionInputLabel() {
        WebElement els=coreElement.findElement(By.xpath(".//label"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateContributionInputLabel(DataTypes type) {
        String actual = getContributionInputLabel();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getFundFeesDetails() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//li[contains(text(),'" + getData() + "')]"));
        if (els.isEmpty()) {
            return null;
        } else {
            return els.get(0).getText();
        }
    }

    public void validateFundFees(DataTypes type) {
        String actual = getFundFeesDetails();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
