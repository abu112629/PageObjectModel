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

    public String getBannerErrorMsg() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//slot/p"));
        if (els.isEmpty()) {
            return null;
        } else {
            return els.get(0).getText();
        }
    }

    public void validateBannerError(DataTypes type) {
        String actual = getBannerErrorMsg();
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

    public String getListDetails() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//li[contains(text(),'" + getData() + "')]"));
        if (els.isEmpty()) {
            return null;
        } else {
            return els.get(0).getText();
        }
    }
    public void validateListDetails(DataTypes type) {
        String actual = getListDetails();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getSelectionLabel() {
        List<WebElement> els = coreElement.findElements(By.xpath(".//*[contains(@class,'nds-form-element__control nds-form-element__control-animated-label')]"));
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

    public String getBeneficiaryTypePerson() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'person-badge')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateBeneficiaryTypePerson(DataTypes type) {
        String actual = getBeneficiaryTypePerson();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getBeneficiaryTypeEstate() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'estate-badge')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateBeneficiaryTypeEstate(DataTypes type) {
        String actual = getBeneficiaryTypeEstate();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getBeneficiaryTypeOrganization() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'organization-badge')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateBeneficiaryTypeOrganization(DataTypes type) {
        String actual = getBeneficiaryTypeOrganization();
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

    public String getTrusteeName() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'trustee')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateTrusteeName(DataTypes type) {
        String actual = getTrusteeName();
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

    public String getCheckboxLabel() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'nds-checkbox-span')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateCheckboxLabel(DataTypes type) {
        String actual = getCheckboxLabel();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getDetailsText() {
        WebElement els=coreElement.findElement(By.xpath(".//span[contains(text(),'"+ getData()+ "')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateDetailsText(DataTypes type) {
        String actual = getDetailsText();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getInformationLabel() {
        WebElement els=coreElement.findElement(By.xpath(".//strong[contains(text(),'"+ getData()+ "')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }
    public void validateInformationText(DataTypes type) {
        String actual = getInformationLabel();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    public String getQuestionLabel() {
        WebElement els=coreElement.findElement(By.xpath(".//*[contains(@class,'nds-m-bottom_xx-large')]"));
        if (!els.isDisplayed()) {
            return null;
        } else {
            return els.getText();
        }
    }

    public void validateQuestionLabel(DataTypes type) {
        String actual = getQuestionLabel();
        String expected = getData(type);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
