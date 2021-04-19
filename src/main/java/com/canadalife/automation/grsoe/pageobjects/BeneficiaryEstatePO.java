package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class BeneficiaryEstatePO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']//h4")
    private WebComponent addBeneficiaryEstateLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']//p")
    private WebComponent addBeneficiaryEstateHintLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaryType']")
    private RadioGroup primaryTypeEstateLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryEstateFeedbackMessage']//p")
    private WebComponent beneficiaryEstateMessage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationEstate']")
    private VlocityActionInput primaryAllocationEstate;

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryAllocationEstate'])[last()]")
    private WebElement primaryDuplicateAllocationEstate;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationEstate']")
    private VlocityInput primaryEstateAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationEstate']")
    private VlocityInput primaryEstateAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelect beneficiaryEstateType;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelect beneficiaryAllocationEstatePercentage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaryType']")
    private VlocitySelectRadioButton BeneEstateRadioButton;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateEstateBeneFormLabels(){
        AppHelper.scrollToView(addBeneficiaryEstateLabel.getCoreElement());
        addBeneficiaryEstateLabel.validateData(DataTypes.Data);
        addBeneficiaryEstateHintLabel.validateData(DataTypes.Data);
        primaryTypeEstateLabel.validateLabelHeader(DataTypes.Data);

        beneficiaryEstateMessage.validateData(DataTypes.Data);

    }

    public void validateAndEnterDetailsEstateBeneficiary(){
        setElementValue(primaryAllocationEstate);

    }

    /*For multiple beneficiaries*/
    public void enterDetailsEstateBeneficiary(){
        primaryDuplicateAllocationEstate.sendKeys(primaryAllocationEstate.getData());
    }
    public void validateInvalidEstateBeneficiaryDetails() {
        AppHelper.scrollToView(primaryEstateAllocationInvalid.getCoreElement());
        primaryEstateAllocationInvalid.click();
        setElementValue(primaryEstateAllocationInvalid);
        AppHelper.waitForXHR(2);
        primaryEstateAllocationInvalid.validateError(DataTypes.Initial);

    }

    public void validateEstateError(){
        primaryEstateAllocationError.validateError(DataTypes.Data);

    }

    public void validatePillInformationEstate(){
        beneficiaryEstateType.validateBeneficiaryTypeEstate(DataTypes.Data);
        beneficiaryEstateType.validateBeneficiaryName(DataTypes.Expected);
        beneficiaryAllocationEstatePercentage.validateAllocationPercentage(DataTypes.Data);
    }

    public void deleteAllTestRecords() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.deleteAllEstateOrgDetails("Estate",
                Float.valueOf(beneficiaryAllocationEstatePercentage.getData(DataTypes.Initial)));
    }
    public void validateSalesforceEstateRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryEstateOrgDetails(BeneEstateRadioButton.getData(),
                Float.valueOf(beneficiaryAllocationEstatePercentage.getData(DataTypes.Initial)));
    }
}
