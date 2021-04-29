package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.RadioGroup;
import com.canadalife.automation.grsoe.components.VlocityActionInput;
import com.canadalife.automation.grsoe.components.VlocitySelect;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class ContingentBeneficiaryOrganizationPO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']//h4")
    private WebComponent addBeneficiaryOrgLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']//p")
    private WebComponent addBeneficiaryOrgHintLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaryType']")
    private RadioGroup contingentTypeOrgLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentOrganizationHelpTextBlock']//div")
    private WebComponent beneficiaryOrganizationMessage;

    @FindBy(xpath = "//*[@data-omni-key='ContingentOrganizationNameText']")
    private VlocityActionInput beneficiaryOrganizationName;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentOrganizationNameText'])[last()]")
    private WebElement beneficiaryDuplicateOrganizationName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationOrganization']")
    private VlocityActionInput beneficiaryOrganizationAllocation;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentAllocationOrganization'])[last()]")
    private WebElement beneficiaryDuplicateOrganizationAllocation;

    @FindBy(xpath = "//*[@data-omni-key='ContingentOrganizationNameText']")
    private VlocityActionInput beneficiaryOrganizationNameError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationOrganization']")
    private VlocityActionInput beneficiaryOrganizationAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentOrganizationNameText']")
    private VlocityActionInput beneficiaryOrganizationNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationOrganization']")
    private VlocityActionInput beneficiaryOrganizationAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryOrgType;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryOrgAllocationPercentage;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateOrganisationBeneFormLabels(){
        AppHelper.scrollToView(addBeneficiaryOrgLabel.getCoreElement());
        addBeneficiaryOrgLabel.validateData(DataTypes.Data);
        addBeneficiaryOrgHintLabel.validateData(DataTypes.Data);
        contingentTypeOrgLabel.validateLabelHeader(DataTypes.Data);

        beneficiaryOrganizationMessage.validateData(DataTypes.Data);
        beneficiaryOrganizationName.validateInputLabel(DataTypes.Initial);
        beneficiaryOrganizationAllocation.validateInputLabel(DataTypes.Initial);

    }

    public void validateAndEnterDetailsOrganizationBeneficiary(){
        setElementValue(beneficiaryOrganizationName);
        setElementValue(beneficiaryOrganizationAllocation);

    }

    /*For multiple beneficiaries*/
    public void enterDetailsOrganizationBeneficiary(){
        beneficiaryDuplicateOrganizationName.sendKeys(beneficiaryOrganizationName.getData());
        AppHelper.scrollToView(beneficiaryDuplicateOrganizationAllocation);
        beneficiaryDuplicateOrganizationAllocation.sendKeys(beneficiaryOrganizationAllocation.getData());

    }
    public void validateInvalidOrganizationBeneficiaryDetails() {
        AppHelper.scrollToView(beneficiaryOrganizationNameInvalid.getCoreElement());
        beneficiaryOrganizationNameInvalid.click();
        setElementValue(beneficiaryOrganizationNameInvalid);
        AppHelper.waitForXHR(2);
        beneficiaryOrganizationNameInvalid.validateError(DataTypes.Initial);

        beneficiaryOrganizationAllocationInvalid.click();
        setElementValue(beneficiaryOrganizationAllocationInvalid);
        AppHelper.waitForXHR(2);
        beneficiaryOrganizationAllocationInvalid.validateError(DataTypes.Initial);

    }

    public void validateOrganizationError(){
        beneficiaryOrganizationNameError.validateError(DataTypes.Data);
        beneficiaryOrganizationAllocationError.validateError(DataTypes.Data);
    }

    public void validatePillInformationOrganization(){
        beneficiaryOrgType.validateBeneficiaryTypeOrganization(DataTypes.Data);
        beneficiaryOrgType.validateBeneficiaryName(DataTypes.Expected);
        beneficiaryOrgAllocationPercentage.validateAllocationPercentage(DataTypes.Data);
    }

    public void deleteAllTestRecords() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.deleteAllEstateOrgDetails(beneficiaryOrganizationName.getData(),
                Float.valueOf(beneficiaryOrgAllocationPercentage.getData(DataTypes.Initial)));
    }

    public void validateSalesforceOrganizationRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryEstateOrgDetails(beneficiaryOrganizationName.getData(),
                Float.valueOf(beneficiaryOrgAllocationPercentage.getData(DataTypes.Initial)));
    }
}
