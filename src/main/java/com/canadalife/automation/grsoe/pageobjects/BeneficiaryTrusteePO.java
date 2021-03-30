package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class BeneficiaryTrusteePO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityInput primaryFirstName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityInput primaryLastName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelect beneficiaryTrusteeType;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryIstrusteeYesNo']")
    private RadioGroup primaryTrusteeQuestion;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryIstrusteeYesNo']")
    private RadioGroup primaryTrusteeSelectionYes;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryIstrusteeYesNo']")
    private RadioGroup primaryTrusteeSelectionNo;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeRelationship']")
    private VlocitySelect primaryTrusteeRelationship;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeFirstName']")
    private VlocityActionInput primaryTrusteeFirstName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeLastName']")
    private VlocityActionInput primaryTrusteeLastName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeFirstName']")
    private VlocityActionInput primaryTrusteeFirstNameDuplicate;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeLastName']")
    private VlocityActionInput primaryTrusteeLastNameDuplicate;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeRelationship']")
    private RadioGroup primaryTrusteeRelationshipError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeFirstName']")
    private VlocityActionInput primaryTrusteeFirstNameError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeLastName']")
    private VlocityActionInput primaryTrusteeLastNameError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeFirstName']")
    private VlocityActionInput primaryTrusteeFirstNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryTrusteeLastName']")
    private VlocityActionInput primaryTrusteeLastNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAdd;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateBeneficaryTrusteeQuestion(){
        primaryTrusteeQuestion.validateLabelHeader(DataTypes.Data);
    }

    public void selectPrimaryTrusteeNo(){
        AppHelper.scrollToView(primaryTrusteeSelectionNo.getCoreElement());
        setElementValue(primaryTrusteeSelectionNo);

    }
    public void selectPrimaryTrusteeYes(){
        AppHelper.scrollToView(primaryTrusteeSelectionYes.getCoreElement());
        setElementValue(primaryTrusteeSelectionYes);
    }
    public void validatePrimaryTrusteeError(){
        AppHelper.scrollToView(primaryTrusteeSelectionNo.getCoreElement());
        primaryTrusteeSelectionNo.validateError(DataTypes.Initial);

    }
    public void validateTrusteeFormLabels(){
        AppHelper.scrollToView(primaryTrusteeRelationship.getCoreElement());
        primaryTrusteeRelationship.validateSelectionLabel(DataTypes.Initial);

        AppHelper.scrollToView(primaryTrusteeFirstName.getCoreElement());
        primaryTrusteeFirstName.validateInputLabel(DataTypes.Initial);
        primaryTrusteeLastName.validateInputLabel(DataTypes.Initial);
    }
    public void validatePrimaryTrusteeEmptyErrors(){
        AppHelper.scrollToView(primaryTrusteeRelationshipError.getCoreElement());
        primaryTrusteeRelationshipError.validateError(DataTypes.Data);
        primaryTrusteeFirstNameError.validateError(DataTypes.Data);
        primaryTrusteeLastNameError.validateError(DataTypes.Data);

    }
    public void validateInvalidTrusteeDetails() {
        AppHelper.scrollToView(primaryTrusteeRelationship.getCoreElement());
        setElementValue(primaryTrusteeRelationship);

        primaryTrusteeFirstNameInvalid.click();
        setElementValue(primaryTrusteeFirstNameInvalid);
        AppHelper.waitForXHR(2);
        primaryTrusteeFirstNameInvalid.validateError(DataTypes.Initial);

        primaryTrusteeLastNameInvalid.click();
        setElementValue(primaryTrusteeLastNameInvalid);
        AppHelper.waitForXHR(2);
        primaryTrusteeLastNameInvalid.validateError(DataTypes.Initial);
    }

    public void validateDuplicateBeneTrusteeDetails() {
        AppHelper.scrollToView(primaryTrusteeFirstName.getCoreElement());
        setElementValue(primaryTrusteeFirstNameDuplicate);
        setElementValue(primaryTrusteeLastNameDuplicate);
    }

    public void validateDuplicateBeneTrusteeDetailsError() {
        AppHelper.scrollToView(beneficiariesAdd.getCoreElement());
        beneficiariesAdd.validateBannerError(DataTypes.Expected);
    }

    public void validateAndEnterDetailsTrusteeBeneficiary(){
        AppHelper.scrollToView(primaryTrusteeRelationship.getCoreElement());
        setElementValue(primaryTrusteeRelationship);
        setElementValue(primaryTrusteeFirstName);
        setElementValue(primaryTrusteeLastName);

    }
    public void validatePillInformationTrustee(){
        beneficiaryTrusteeType.validateTrusteeName(DataTypes.Data);
    }

    public void validateSalesforceTrusteeRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkTrusteeDetails(primaryFirstName.getData(),primaryLastName.getData(),
                primaryTrusteeFirstName.getData(),primaryTrusteeLastName.getData(),"Aunt");
    }
}
