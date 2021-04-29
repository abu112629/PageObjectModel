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

public class ContingentBeneficiaryEstatePO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']//h4")
    private WebComponent addBeneficiaryEstateLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']//p")
    private WebComponent addBeneficiaryEstateHintLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaryType']")
    private RadioGroup contingentTypeEstateLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentEstateFeedbackMessage']//p")
    private WebComponent beneficiaryEstateMessage;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationEstate']")
    private VlocityActionInput contingentAllocationEstate;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentAllocationEstate'])[last()]")
    private WebElement contingentDuplicateAllocationEstate;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationEstate']")
    private VlocityInput contingentEstateAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationEstate']")
    private VlocityInput contingentEstateAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryEstateType;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryAllocationEstatePercentage;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaryType']")
    private VlocitySelectRadioButton BeneEstateRadioButton;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateEstateBeneFormLabels(){
        AppHelper.scrollToView(addBeneficiaryEstateLabel.getCoreElement());
        addBeneficiaryEstateLabel.validateData(DataTypes.Data);
        addBeneficiaryEstateHintLabel.validateData(DataTypes.Data);
        contingentTypeEstateLabel.validateLabelHeader(DataTypes.Data);

        beneficiaryEstateMessage.validateData(DataTypes.Data);

    }

    public void validateAndEnterDetailsEstateBeneficiary(){
        setElementValue(contingentAllocationEstate);

    }

    /*For multiple beneficiaries*/
    public void enterDetailsEstateBeneficiary(){
        contingentDuplicateAllocationEstate.sendKeys(contingentAllocationEstate.getData());
    }
    public void validateInvalidEstateBeneficiaryDetails() {
        AppHelper.scrollToView(contingentEstateAllocationInvalid.getCoreElement());
        contingentEstateAllocationInvalid.click();
        setElementValue(contingentEstateAllocationInvalid);
        AppHelper.waitForXHR(2);
        contingentEstateAllocationInvalid.validateError(DataTypes.Initial);

    }

    public void validateEstateError(){
        contingentEstateAllocationError.validateError(DataTypes.Data);

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
