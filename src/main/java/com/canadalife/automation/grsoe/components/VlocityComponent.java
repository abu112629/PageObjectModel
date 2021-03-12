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

    public String getSpecialHeader() {
        WebElement els=coreElement.findElement(By.xpath(".//span[contains(@class,'nds-m-right_x-small')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateLabelHeader(DataTypes type) {
        String actual = getSpecialHeader();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getInputLabel() {
        WebElement els=coreElement.findElement(By.xpath(".//label"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateInputLabel(DataTypes type) {
        String actual = getInputLabel();
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


    public String getSelectionLabel() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//*[@class='nds-form-element__control nds-form-element__control-animated-label']"));
        if (els.isEmpty()) {
            return null;
        } else {
            return els.get(0).getText();
        }
    }

    public void validateSelectionLabel(DataTypes type) {
        String actual = getSelectionLabel();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getInputTextLabel() {
        WebElement els=coreElement.findElement(By.xpath(".//label[contains(text(),'"+ getData() + "')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateInputTextLabel(DataTypes type) {
        String actual = getInputTextLabel();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getBeneficiaryType() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'pill-icon')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateBeneficiaryType(DataTypes type) {
        String actual = getBeneficiaryType();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getBeneficiaryName() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'overflow-break')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateBeneficiaryName(DataTypes type) {
        String actual = getBeneficiaryName();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getAllocationPercentage() {
        WebElement els=coreElement.findElement(By.xpath(".//div[contains(text(),'"+ getData() + "')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateAllocationPercentage(DataTypes type) {
        String actual = getAllocationPercentage();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
