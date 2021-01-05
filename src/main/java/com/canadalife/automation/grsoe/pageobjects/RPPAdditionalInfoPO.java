package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.RadioGroup;
import com.canadalife.automation.grsoe.components.VlocityInput;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.SelectComponent;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class RPPAdditionalInfoPO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='SpouseQuestion']")
    private RadioGroup spousebuttonYes;

    @FindBy(xpath = "//*[@data-omni-key='ConnectedPerson']")
    private RadioGroup connectedPersonbuttonYes;

    @FindBy(xpath = "//*[@data-omni-key='SpouseQuestion']")
    private RadioGroup spousebuttonNo;

    @FindBy(xpath = "//*[@data-omni-key='ConnectedPerson']")
    private RadioGroup connectedPersonbuttonNo;

    @FindBy(xpath = "//*[@data-omni-key='birthDate']")
    private RadioGroup birthDate;

    @FindBy(xpath = "//*[@data-omni-key='SpouseFirstName']//label")
    private WebComponentList spouseFirstNameLabel;

    @FindBy(xpath = "//*[@data-omni-key='SpouseLastName']//label")
    private WebComponentList spouseSecondNameLabel;

    @FindBy(xpath = "//c-nds-date-v1_1_0/label")
    private WebComponentList spouseDOBLabel;

    @FindBy(xpath = "//*[@data-omni-key='SpouseFirstName']")
    private VlocityInput spousefirstNameinput;

    @FindBy(xpath = "//*[@data-omni-key='SpouseLastName']")
    private VlocityInput spouseSecondNameinput;

    @FindBy(xpath = "//*[@data-omni-key='SpouseFirstName']//span")
    private WebComponentList spousefirstNamehintLabel;

    @FindBy(xpath = "//*[@data-omni-key='SpouseLastName']//span")
    private WebComponentList spouseSecondNamehintLabel;

    @FindBy(xpath = "//select[starts-with(@id, 'month')]")
    private SelectComponent slctdrpdownMonth;

    @FindBy(xpath = "//input[@type='number'][starts-with(@id, 'day')]")
    private WebComponent birthDay;

    @FindBy(xpath = "//input[@type='number'][starts-with(@id, 'year')]")
    private WebComponent birthYear;

    @FindBy(xpath = "//*[(@data-omni-key='ConnectedPerson')]//*[contains(@class,'nds-form-element__static')]")
    private WebComponentList connectedPersonDetailedText;

    @FindBy(xpath = "//slot/p")
    private WebComponentList connectedPersonDisclaimer;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateSpouseFirstNameLabel() {
        spouseFirstNameLabel.initPage(getContext());
        spouseFirstNameLabel.validateAll();
    }

    public void validateSpouseSecondNameLabel() {
        spouseSecondNameLabel.initPage(getContext());
        spouseSecondNameLabel.validateAll();
    }

    public void validateSpouseDOBLabel() {
        spouseDOBLabel.initPage(getContext());
        spouseDOBLabel.validateAll();
    }

    public void validateHintTextSpouseFirstName() {
        spousefirstNamehintLabel.initPage(getContext());
        spousefirstNamehintLabel.validateAll();
    }

    public void validateHintTextSpouseLastName() {
        spouseSecondNamehintLabel.initPage(getContext());
        spouseSecondNamehintLabel.validateAll();
    }

    public void validateConnectedPersonDetailsLabel() {
        connectedPersonDetailedText.initPage(getContext());
        connectedPersonDetailedText.validateAll();
    }

    @Step("Click yes button for spouse Question")
    public void clickYesforspouse() {
        setElementValue(spousebuttonYes);
    }

    @Step("Click yes button for connected person Question")
    public void clickYesforconnectedperson() {
        AppHelper.scrollToView(connectedPersonbuttonYes.getCoreElement());
        setElementValue(connectedPersonbuttonYes);
    }

    @Step("Click no button for spouse Question")
    public void clickNoforspouse() {
        setElementValue(spousebuttonNo);
    }

    @Step("Click no button for connected person Question")
    public void clickNoforconnectedperson() {
        AppHelper.scrollToView(connectedPersonbuttonYes.getCoreElement());
        setElementValue(connectedPersonbuttonNo);
    }

    @Step("Validate error message when no selection for spouse or connected person questionnaire")
    public void errorMessageNoselection() {
        AppHelper.waitForXHR(1);
        spousebuttonYes.validateError(DataTypes.Initial);
        connectedPersonbuttonYes.validateError(DataTypes.Initial);
    }

    @Step("Validate Spouse First Name , Last Name and DOB labels")
    public void validateLabels() {
        validateSpouseFirstNameLabel();
        validateSpouseSecondNameLabel();
        validateSpouseDOBLabel();
    }

    @Step("Validate error message when no spouse first name or last name is entered")
    public void errorMessageNospousedetails() {
        spousefirstNameinput.validateError(DataTypes.Initial);
        spouseSecondNameinput.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no spouse last name is entered")
    public void errorMessageNospouselastname() {
        spouseSecondNameinput.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no selection for connected person question")
    public void errorMessageNoselectionconnectedperson() {
        AppHelper.waitForXHR(1);
        connectedPersonbuttonYes.validateError(DataTypes.Initial);
    }

    @Step("Enter first Name for spouse")
    public void enterFirstNameSpouse() {
        setElementValue(spousefirstNameinput);
    }

    @Step("Enter last Name for spouse")
    public void enterLastNameSpouse() {
        setElementValue(spouseSecondNameinput);
    }

    @Step("Enter Date Of Birth Details")
    public void enterDOBDetails() {
        setElementValue(slctdrpdownMonth, false);
        setElementValue(birthDay);
        setElementValue(birthYear);

    }

    @Step("Future Day Of Birth error Message")
    public void validateFutureDOBError() {
        birthDate.validateError(DataTypes.Data);
    }

    @Step("Connected Person Disclaimer is visible on selecting yes for Connected Person")
    public void validateConnectedPersonDisclaimer() {
        connectedPersonDisclaimer.initPage(getContext());
        AppHelper.scrollToView(connectedPersonbuttonYes.getCoreElement());
        connectedPersonDisclaimer.validateAll();
    }

    @Step("Connected Person Disclaimer is not visible on selecting no for Connected Person")
    public void validateConnectedPersonDisclaimernotVisible() {
        setElementValue(connectedPersonbuttonNo);
        Assertions.assertThat(connectedPersonDisclaimer.getElementsMap().get(0)).isNull();

    }

    public void validateSalesforceSpouseRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkSpouseRecordDetails(spousefirstNameinput.getData(), spouseSecondNameinput.getData());
    }

    public void validateSalesforceSpouseRecordDeletion() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkSpouseRecordDeleted(spousefirstNameinput.getData(), spouseSecondNameinput.getData());
    }


}
