package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class BeneficiariesPO extends PageObjectModel {

    @FindBy(xpath="//*[@data-omni-key='stepperHeaderTextBlock']//p")
    private WebComponentList beneficiariesDescription;

    @FindBy(xpath="//*[@data-omni-key='YourBeneficiaries']//h2")
    private WebComponent beneficiariesSkipQuestion;

    @FindBy(xpath = "//*[starts-with(@class,'nds-col nds-m-bottom_xx-large nds-size_1-of-1')]")
    private WebComponent beneficiariesSkipDetails;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAdd;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']//h4")
    private WebComponent addBeneficiaryLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']//p")
    private WebComponent addBeneficiaryHintLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaryType']")
    private RadioGroup primaryTypeLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaryType']")
    private VlocitySelectRadioButton BeneRadioButton;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryRelationship']")
    private VlocitySelectRadioButton personDropDownQuestion;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryRelationship']")
    private VlocitySelect personBeneficiaryRelation;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityInput primaryFirstName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityActionInput primaryFirstNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityInput primaryFirstNameError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryLastName']")
    private VlocityInput primaryLastName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryLastName']")
    private VlocityActionInput primaryLastNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryLastName']")
    private VlocityInput primaryLastNameError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryDateOfBirth']")
    private VlocityInput primaryDateOfBirth;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryDateOfBirth']")
    private VlocityInput primaryMonthLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryDateOfBirth']")
    private VlocityInput primaryDateLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryDateOfBirth']")
    private VlocityInput primaryYearLabel;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationPerson']")
    private VlocityActionInput primaryAllocation;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationPerson']")
    private VlocityInput primaryAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationPerson']")
    private VlocityInput primaryAllocationError;

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
    private VlocitySelect beneficiaryType;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelect beneficiaryAllocationPercentage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryEstateFeedbackMessage']//p")
    private WebComponent beneficiaryEstateMessage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationEstate']")
    private VlocityActionInput primaryAllocationEstate;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationEstate']")
    private VlocityInput primaryEstateAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationEstate']")
    private VlocityInput primaryEstateAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryOrganizationHelpTextBlock']//div")
    private WebComponent beneficiaryOrganizationMessage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryOrganizationNameText']")
    private VlocityActionInput beneficiaryOrganizationName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationOrganization']")
    private VlocityActionInput beneficiaryOrganizationAllocation;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryOrganizationNameText']")
    private VlocityActionInput beneficiaryOrganizationNameError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationOrganization']")
    private VlocityActionInput beneficiaryOrganizationAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryOrganizationNameText']")
    private VlocityActionInput beneficiaryOrganizationNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationOrganization']")
    private VlocityActionInput beneficiaryOrganizationAllocationInvalid;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateBeneficiariesDescription(){
        beneficiariesDescription.initPage(getContext());
        beneficiariesDescription.validateAll();
    }

    public void validateBeneficiariesSkipQuestionandDetails(){
       beneficiariesSkipQuestion.validateData(DataTypes.Data);
       beneficiariesSkipDetails.validateData(DataTypes.Data);
    }

    public void addPrimaryBeneficiary(){
        setElementValue(beneficiariesAdd,false);
    }

    public void validateBeneficiaryFormLabels(){
        AppHelper.scrollToView(addBeneficiaryLabel.getCoreElement());
        addBeneficiaryLabel.validateData(DataTypes.Data);
        addBeneficiaryHintLabel.validateData(DataTypes.Data);
        primaryTypeLabel.validateLabelHeader(DataTypes.Data);
        personDropDownQuestion.validateSelectionLabel(DataTypes.Data);

        AppHelper.scrollToView(primaryFirstName.getCoreElement());
        primaryFirstName.validateInputLabel(DataTypes.Initial);
        primaryLastName.validateInputLabel(DataTypes.Initial);

        primaryDateOfBirth.getInputTextLabel();
        primaryDateOfBirth.validateInputTextLabel(DataTypes.Expected);

        primaryMonthLabel.getInputTextLabel();
        primaryMonthLabel.validateInputTextLabel(DataTypes.Expected);

        primaryDateOfBirth.getInputTextLabel();
        primaryDateOfBirth.validateInputTextLabel(DataTypes.Expected);

        primaryYearLabel.getInputTextLabel();
        primaryYearLabel.validateInputTextLabel(DataTypes.Expected);

        AppHelper.scrollToView(primaryAllocation.getCoreElement());
        primaryAllocation.validateInputLabel(DataTypes.Initial);
    }

    public void validateEstateBeneFormLabels(){
        AppHelper.scrollToView(addBeneficiaryLabel.getCoreElement());
        addBeneficiaryLabel.validateData(DataTypes.Data);
        addBeneficiaryHintLabel.validateData(DataTypes.Data);
        primaryTypeLabel.validateLabelHeader(DataTypes.Data);

        beneficiaryEstateMessage.validateData(DataTypes.Data);

    }

    public void validateOrganisationBeneFormLabels(){
        AppHelper.scrollToView(addBeneficiaryLabel.getCoreElement());
        addBeneficiaryLabel.validateData(DataTypes.Data);
        addBeneficiaryHintLabel.validateData(DataTypes.Data);
        primaryTypeLabel.validateLabelHeader(DataTypes.Data);

        beneficiaryOrganizationMessage.validateData(DataTypes.Data);
        beneficiaryOrganizationName.validateInputLabel(DataTypes.Initial);
        beneficiaryOrganizationAllocation.validateInputLabel(DataTypes.Initial);

    }

    public void addBeneficiary(){
        AppHelper.scrollToView(BeneRadioButton.getCoreElement());
        setElementValue(BeneRadioButton,false);
    }

    public void selectPersonRelationBeneficiary(){
        AppHelper.scrollToView(personBeneficiaryRelation.getCoreElement());
        setElementValue(personBeneficiaryRelation);
    }


    public void validateInvalidPersonBeneficiaryDetails() {
        primaryFirstNameInvalid.click();
        setElementValue(primaryFirstNameInvalid);
        AppHelper.waitForXHR(2);
        primaryFirstNameInvalid.validateError(DataTypes.Initial);

        primaryLastNameInvalid.click();
        setElementValue(primaryLastNameInvalid);
        AppHelper.waitForXHR(2);
        primaryLastNameInvalid.validateError(DataTypes.Initial);

        AppHelper.scrollToView(primaryAllocation.getCoreElement());
        primaryAllocationInvalid.click();
        setElementValue(primaryAllocationInvalid);
        AppHelper.waitForXHR(2);
        primaryAllocationInvalid.validateError(DataTypes.Initial);

    }
    public void validateAndEnterDetailsPrimaryBeneficiary(){
        setElementValue(primaryFirstName);
        setElementValue(primaryLastName);
        AppHelper.scrollToView(primaryAllocation.getCoreElement());
        setElementValue(primaryAllocation);

    }
    public void validateAndEnterDetailsEstateBeneficiary(){
        setElementValue(primaryAllocationEstate);

    }

    public void validateAndEnterDetailsOrganizationBeneficiary(){
        setElementValue(beneficiaryOrganizationName);
        setElementValue(beneficiaryOrganizationAllocation);

    }
    public void validateInvalidEstateBeneficiaryDetails() {
        AppHelper.scrollToView(primaryEstateAllocationInvalid.getCoreElement());
        primaryEstateAllocationInvalid.click();
        setElementValue(primaryEstateAllocationInvalid);
        AppHelper.waitForXHR(2);
        primaryEstateAllocationInvalid.validateError(DataTypes.Initial);

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
    public void validateAndEnterPrimaryallocation(){
        setElementValue(primaryAllocation);

    }
    public void validateErrors(){
        primaryFirstNameError.validateError(DataTypes.Data);
        primaryLastNameError.validateError(DataTypes.Data);
        primaryAllocationError.validateError(DataTypes.Data);

    }

    public void validateEstateError(){
        primaryEstateAllocationError.validateError(DataTypes.Data);

    }

    public void validateOrganizationError(){
        beneficiaryOrganizationNameError.validateError(DataTypes.Data);
        beneficiaryOrganizationAllocationError.validateError(DataTypes.Data);
    }

    public void validatePillInformation(){
        beneficiaryType.validateBeneficiaryTypePerson(DataTypes.Data);
        beneficiaryType.validateBeneficiaryName(DataTypes.Expected);
        beneficiaryAllocationPercentage.validateAllocationPercentage(DataTypes.Data);
    }

    public void validatePillInformationEstate(){
        beneficiaryType.validateBeneficiaryTypeEstate(DataTypes.Data);
        beneficiaryType.validateBeneficiaryName(DataTypes.Expected);
        beneficiaryAllocationPercentage.validateAllocationPercentage(DataTypes.Data);
    }

    public void validatePillInformationOrganization(){
        beneficiaryType.validateBeneficiaryTypeOrganization(DataTypes.Data);
        beneficiaryType.validateBeneficiaryName(DataTypes.Expected);
        beneficiaryAllocationPercentage.validateAllocationPercentage(DataTypes.Data);
    }

    public void validateSalesforceBeneficiaryRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetails(primaryFirstName.getData(),primaryLastName.getData(),
                primaryAllocation.getData());
    }

    public void validateSalesforceEstateRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetails(BeneRadioButton.getData(),"",
                primaryAllocationEstate.getData());
    }

    public void validateSalesforceOrganizationRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetails(beneficiaryOrganizationName.getData(),"",
                beneficiaryOrganizationAllocation.getData());
    }

    public void validateSalesforceTrusteeRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkTrusteeDetails(primaryFirstName.getData(),primaryLastName.getData(),
                primaryTrusteeFirstName.getData(),primaryTrusteeLastName.getData(),primaryTrusteeRelationship.getData());
    }
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
}
