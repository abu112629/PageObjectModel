package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class ContingentBeneficiaryTrusteePO extends PageObjectModel {


    @FindBy(xpath = "//*[@data-omni-key='ContingentFirstName']")
    private VlocityInput contingentFirstName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentFirstName']")
    private VlocityInput contingentLastName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryTrusteeType;

    @FindBy(xpath = "//*[@data-omni-key='ContingentIstrusteeYesNo']")
    private RadioGroup contingentTrusteeQuestion;

    @FindBy(xpath = "//*[@data-omni-key='ContingentIstrusteeYesNo']")
    private RadioActionGroup contingentTrusteeSelectionYes;

    @FindBy(xpath = "//*[@data-omni-key='ContingentIstrusteeYesNo']")
    private RadioActionGroup contingentTrusteeSelectionNo;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentIstrusteeYesNo']//input[@value='no']/..)[last()]")
    private WebElement contingentDuplicateTrusteeSelectionNo;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeRelationship']")
    private VlocitySelect contingentTrusteeRelationship;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeFirstName']")
    private VlocityActionInput contingentTrusteeFirstName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeLastName']")
    private VlocityActionInput contingentTrusteeLastName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeFirstName']")
    private VlocityActionInput contingentTrusteeFirstNameDuplicate;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeLastName']")
    private VlocityActionInput contingentTrusteeLastNameDuplicate;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeFirstName']")
    private VlocityActionInput contingentTrusteePrimaryFirstNameDuplicate;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeLastName']")
    private VlocityActionInput contingentTrusteePrimaryLastNameDuplicate;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeRelationship']")
    private RadioGroup contingentTrusteeRelationshipError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeFirstName']")
    private VlocityActionInput contingentTrusteeFirstNameError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeLastName']")
    private VlocityActionInput contingentTrusteeLastNameError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeFirstName']")
    private VlocityActionInput contingentTrusteeFirstNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentTrusteeLastName']")
    private VlocityActionInput contingentTrusteeLastNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAdd;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton primaryTrusteeDuplicateError;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void validateBeneficaryTrusteeQuestion(){
        AppHelper.scrollToView(contingentTrusteeQuestion.getCoreElement());
        contingentTrusteeQuestion.validateLabelHeader(DataTypes.Data);
    }

    public void selectContingentTrusteeNo(){
        AppHelper.scrollToView(contingentTrusteeSelectionNo.getCoreElement());
        setElementValue(contingentTrusteeSelectionNo);

    }
    public void selectContingentTrusteeNoDuplicate(){
        AppHelper.scrollToView(contingentDuplicateTrusteeSelectionNo);
        contingentDuplicateTrusteeSelectionNo.click();

    }
    public void selectContingentTrusteeYes(){
        AppHelper.scrollToView(contingentTrusteeSelectionYes.getCoreElement());
        setElementValue(contingentTrusteeSelectionYes);
    }
    public void validateContingentTrusteeError(){
        AppHelper.scrollToView(contingentTrusteeSelectionNo.getCoreElement());
        contingentTrusteeSelectionNo.validateError(DataTypes.Initial);

    }
    public void validateTrusteeFormLabels(){
        AppHelper.scrollToView(contingentTrusteeRelationship.getCoreElement());
        contingentTrusteeRelationship.validateSelectionLabel(DataTypes.Initial);

        AppHelper.scrollToView(contingentTrusteeFirstName.getCoreElement());
        contingentTrusteeFirstName.validateInputLabel(DataTypes.Initial);
        contingentTrusteeLastName.validateInputLabel(DataTypes.Initial);
    }
    public void validateContingentTrusteeEmptyErrors(){
        AppHelper.scrollToView(contingentTrusteeRelationshipError.getCoreElement());
        contingentTrusteeRelationshipError.validateError(DataTypes.Data);
        contingentTrusteeFirstNameError.validateError(DataTypes.Data);
        contingentTrusteeLastNameError.validateError(DataTypes.Data);

    }
    public void validateInvalidTrusteeDetails() {
        AppHelper.scrollToView(contingentTrusteeRelationship.getCoreElement());
        setElementValue(contingentTrusteeRelationship);

        contingentTrusteeFirstNameInvalid.click();
        setElementValue(contingentTrusteeFirstNameInvalid);
        AppHelper.waitForXHR(2);
        contingentTrusteeFirstNameInvalid.validateError(DataTypes.Initial);

        contingentTrusteeLastNameInvalid.click();
        setElementValue(contingentTrusteeLastNameInvalid);
        AppHelper.waitForXHR(2);
        contingentTrusteeLastNameInvalid.validateError(DataTypes.Initial);
    }

    public void validateDuplicateBeneTrusteeDetails() {
        AppHelper.scrollToView(contingentTrusteeFirstName.getCoreElement());
        setElementValue(contingentTrusteeFirstNameDuplicate);
        setElementValue(contingentTrusteeLastNameDuplicate);
    }

    public void validateDuplicateTrusteePrimaryDetails() {
        AppHelper.scrollToView(contingentTrusteePrimaryFirstNameDuplicate.getCoreElement());
        setElementValue(contingentTrusteePrimaryFirstNameDuplicate);
        setElementValue(contingentTrusteePrimaryLastNameDuplicate);
    }
    public void validateDuplicateBeneTrusteeDetailsError() {
        AppHelper.scrollToView(beneficiariesAdd.getCoreElement());
        AppHelper.waitForXHR(3);
        beneficiariesAdd.validateBannerError(DataTypes.Expected);
    }

    public void validateDuplicatePrimaryTrusteeDetailsError() {
        AppHelper.scrollToView(primaryTrusteeDuplicateError.getCoreElement());
        AppHelper.waitForXHR(3);
        primaryTrusteeDuplicateError.validateBannerError(DataTypes.Data);
    }
    public void validateAndEnterDetailsTrusteeBeneficiary(){
        AppHelper.scrollToView(contingentTrusteeRelationship.getCoreElement());
        setElementValue(contingentTrusteeRelationship);
        setElementValue(contingentTrusteeFirstName);
        setElementValue(contingentTrusteeLastName);

    }
    public void validatePillInformationTrustee(){
        beneficiaryTrusteeType.validateTrusteeName(DataTypes.Data);
    }

    public void validateSalesforceTrusteeRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkTrusteeDetails(contingentFirstName.getData(),contingentLastName.getData(),
                contingentTrusteeFirstName.getData(),contingentTrusteeLastName.getData(),"Aunt");
    }
}
