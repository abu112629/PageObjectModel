package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.VlocityActionInput;
import com.canadalife.automation.grsoe.components.VlocityInput;
import com.canadalife.automation.grsoe.components.VlocitySelect;
import com.canadalife.automation.grsoe.components.VlocitySelectRadioButton;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class BeneficiarySuccessorPO extends PageObjectModel {

    @FindBy(xpath="//*[@data-omni-key='successorHolderHeadingTextBlock']//h3")
    private WebComponent beneficiariesSuccessorHeader;

    @FindBy(xpath="//*[@data-omni-key='successorHolderHeadingTextBlock']//p")
    private WebComponent beneficiariesSuccessorSubHeader;

    @FindBy(xpath="//*[@data-omni-key='PrimaryBeneHeadingTextBlock']//h3")
    private WebComponent beneficiariesPrimaryHeader;

    @FindBy(xpath="//*[@data-omni-key='PrimaryBeneHeadingTextBlock']//p")
    private WebComponent beneficiariesPrimarySubHeader;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesSuccessorAdd;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorBeneficiaries']//h4")
    private WebComponent addSuccessorBeneficiaryLabel;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorBeneficiaries']//p")
    private WebComponent addSuccessorBeneficiaryHintLabel;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorFirstName']")
    private VlocityInput primarySuccessorFirstName;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorFirstName']")
    private VlocityInput primarySuccessorInvalidFirstName;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorFirstName']")
    private VlocityInput primarySuccessorFirstNameError;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorLastName']")
    private VlocityInput primarySuccessorLastName;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorLastName']")
    private VlocityInput primarySuccessorInvalidLastName;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorLastName']")
    private VlocityInput primarySuccessorLastNameError;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorDateOfBirth']")
    private VlocityInput primarySuccessorDateOfBirth;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorDateOfBirth']")
    private VlocityInput primarySuccessorDateOfBirthError;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorDateOfBirth']")
    private VlocityInput primarySuccessorDateOfBirthHint;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorDateOfBirth']")
    private VlocityInput primarySuccessorMonthLabel;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorDateOfBirth']")
    private VlocityInput primarySuccessorDateLabel;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorDateOfBirth']")
    private VlocityInput primarySuccessorYearLabel;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorSIN']")
    private VlocityActionInput primarySuccessorSIN;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorSIN']")
    private VlocityActionInput primarySuccessorUpdatedSIN;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorSIN']")
    private VlocityActionInput primarySuccessorInvalidSIN;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorSIN']")
    private VlocityActionInput primarySuccessorSINError;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorBeneficiaries']")
    private VlocitySelect beneficiarySuccessorType;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorBeneficiaries']")
    private VlocitySelectRadioButton primaryBeneSuccessorEdit;

    @FindBy(xpath = "//*[@data-omni-key='SuccessorBeneficiaries']")
    private VlocitySelectRadioButton primaryBeneSuccessorDelete;

    @FindBy(xpath="//*[@data-omni-key='YourBeneficiaries']//h2")
    private WebComponent primarySuccessorDeleteQuestion;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void editPrimarySuccessorBeneficiary(){
        AppHelper.scrollToView(primaryBeneSuccessorEdit.getCoreElement());
        setElementValue(primaryBeneSuccessorEdit,false);
    }

    public void deletePrimarySuccessorBeneficiary(){
        setElementValue(primaryBeneSuccessorDelete,false);

    }

    public void validateBeneficiariesDeleteQuestion(){
        primarySuccessorDeleteQuestion.validateData(DataTypes.Data);
    }

    public void validateBeneficiariesSuccessorDescription(){
        beneficiariesSuccessorHeader.validateData(DataTypes.Data);
        beneficiariesSuccessorSubHeader.validateData(DataTypes.Data);
        beneficiariesPrimaryHeader.validateData(DataTypes.Data);
        beneficiariesPrimarySubHeader.validateData(DataTypes.Data);
    }

    public void addSuccessorBeneficiary(){
        setElementValue(beneficiariesSuccessorAdd,false);
    }

    public void validateSuccessorBeneficiaryFormLabels(){
        AppHelper.scrollToView(addSuccessorBeneficiaryLabel.getCoreElement());
        addSuccessorBeneficiaryLabel.validateData(DataTypes.Data);
        addSuccessorBeneficiaryHintLabel.validateData(DataTypes.Data);

        AppHelper.scrollToView(primarySuccessorFirstName.getCoreElement());
        primarySuccessorFirstName.validateInputLabel(DataTypes.Initial);
        primarySuccessorLastName.validateInputLabel(DataTypes.Initial);

        primarySuccessorDateOfBirth.getInputTextLabel();
        primarySuccessorDateOfBirth.validateInputTextLabel(DataTypes.Expected);

        primarySuccessorMonthLabel.getInputTextLabel();
        primarySuccessorMonthLabel.validateInputTextLabel(DataTypes.Expected);

        primarySuccessorDateOfBirth.getInputTextLabel();
        primarySuccessorDateOfBirth.validateInputTextLabel(DataTypes.Expected);

        primarySuccessorYearLabel.getInputTextLabel();
        primarySuccessorYearLabel.validateInputTextLabel(DataTypes.Expected);

        primarySuccessorDateOfBirthHint.getAllocationPercentage();
        primarySuccessorDateOfBirthHint.validateAllocationPercentage(DataTypes.Data);

        AppHelper.scrollToView(primarySuccessorSIN.getCoreElement());
        primarySuccessorSIN.validateInputLabel(DataTypes.Initial);

    }

    public void validateInvalidSuccessorBeneficiaryDetails() {
        AppHelper.scrollToView(primarySuccessorInvalidFirstName.getCoreElement());
        primarySuccessorInvalidFirstName.click();
        setElementValue(primarySuccessorInvalidFirstName);
        AppHelper.waitForXHR(2);
        primarySuccessorInvalidFirstName.validateError(DataTypes.Initial);

        primarySuccessorInvalidLastName.click();
        setElementValue(primarySuccessorInvalidLastName);
        AppHelper.waitForXHR(2);
        primarySuccessorInvalidLastName.validateError(DataTypes.Initial);

        AppHelper.scrollToView(primarySuccessorInvalidSIN.getCoreElement());
        primarySuccessorInvalidSIN.click();
        AppHelper.waitForXHR(3);
        setElementValue(primarySuccessorInvalidSIN,false);
        AppHelper.waitForXHR(2);
        primarySuccessorInvalidSIN.validateError(DataTypes.Initial);

    }

    public void validateIncompleteDOBDetails() {
        AppHelper.scrollToView(primarySuccessorDateOfBirthError.getCoreElement());
        primarySuccessorDateOfBirthError.validateError(DataTypes.Data);
    }

    public void validateInvalidDOBDetails() {
        AppHelper.scrollToView(primarySuccessorDateOfBirthError.getCoreElement());
        primarySuccessorDateOfBirthError.validateError(DataTypes.Expected);
    }

    public void validateAndEnterDetailsSuccessorBeneficiary(){
        setElementValue(primarySuccessorFirstName);
        setElementValue(primarySuccessorLastName);
        AppHelper.scrollToView(primarySuccessorSIN.getCoreElement());
        primarySuccessorSIN.click();
        AppHelper.waitForXHR(3);
        setElementValue(primarySuccessorSIN,false);

    }

    public void enterSINSuccessorBeneficiary(){
        AppHelper.scrollToView(primarySuccessorUpdatedSIN.getCoreElement());
        AppHelper.waitForXHR(3);
        setElementValue(primarySuccessorUpdatedSIN,false);

    }

    public void validateErrors(){
        primarySuccessorFirstNameError.validateError(DataTypes.Data);
        primarySuccessorLastNameError.validateError(DataTypes.Data);
        primarySuccessorSINError.validateError(DataTypes.Data);

    }

    public void validateSuccessorPillInformation(){
        AppHelper.scrollToView(beneficiarySuccessorType.getCoreElement());
        beneficiarySuccessorType.validateBeneficiaryTypePerson(DataTypes.Data);
        beneficiarySuccessorType.validateBeneficiaryName(DataTypes.Expected);
    }

    public void validateSalesforceBeneficiarySuccessorRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetails(primarySuccessorFirstName.getData(),
                primarySuccessorLastName.getData(),
                Float.valueOf("0.0"));
    }

    public void validatePrimarySuccessorBeneficiaryOnEdit(){
        primarySuccessorFirstName.getValue().contains(primarySuccessorFirstName.getData());
        primarySuccessorLastName.getValue().contains(primarySuccessorLastName.getData());
        AppHelper.scrollToView(primarySuccessorSIN.getCoreElement());
        primarySuccessorSIN.getValue().contains(primarySuccessorSIN.getData());

    }

    public void deleteAllTestRecords() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.deleteAllBeneficiaryDetails(primarySuccessorFirstName.getData(),primarySuccessorLastName.getData(),
                Float.valueOf("0.0"));
    }

    public void validateSalesforceBeneficiaryRecordDeleted() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetailsDeleted(primarySuccessorFirstName.getData(),primarySuccessorLastName.getData(),
                Float.valueOf("0.0"));
    }

}
