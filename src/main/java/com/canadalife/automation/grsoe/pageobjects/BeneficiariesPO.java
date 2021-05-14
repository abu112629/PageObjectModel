package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceInfo;
import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryBeneficiaryType']//span[contains(text(),'Organization')])[last()]")
    private WebElement BeneOrganizationRadioButton;

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryBeneficiaryType']//span[contains(text(),'Estate')])[last()]")
    private WebElement BeneEstateRadioButton;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryRelationship']")
    private VlocitySelectRadioButton personDropDownQuestion;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryRelationship']")
    private VlocitySelect personBeneficiaryRelation;

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryRelationship']//input)[last()]")
    private WebElement additionalPersonBeneficiaryRelation;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityInput primaryFirstName;

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryFirstName'])[last()]")
    private WebElement primaryDuplicateFirstName;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityActionInput primaryFirstNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFirstName']")
    private VlocityInput primaryFirstNameError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryLastName']")
    private VlocityInput primaryLastName;

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryLastName'])[last()]")
    private WebElement primaryDuplicateLastName;

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

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryAllocationPerson'])[last()]")
    private WebElement primaryDuplicateAllocation;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationPerson']")
    private VlocityInput primaryAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryAllocationPerson']")
    private VlocityInput primaryAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelect beneficiaryType;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelect beneficiaryAllocationPercentage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryIsRevocableCheckbox']")
    private VlocityCheckBox beneficiaryRevocableQuestion;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton primaryBeneEdit;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton primaryBeneDelete;

    @FindBy(xpath="//*[@data-omni-key='YourBeneficiaries']//h2")
    private WebComponent beneficiariesDeleteQuestion;

    @FindBy(xpath = "(//*[@data-omni-key='PrimaryBeneficiaries'])[last()]")
    private VlocitySelectRadioButton beneficiariesDuplicateError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryFeedbackMessage']")
    private VlocitySelectRadioButton beneficiariesAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAllocationPercentage;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAllocationAddedTotal;

    @FindBy(xpath = "//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAllocationTotal;

    @FindBy(xpath="//*[@data-omni-key='PrimaryBeneficiaries']")
    private VlocitySelectRadioButton allocationInlineError;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    public void editPrimaryBeneficiary(){
        setElementValue(primaryBeneEdit,false);
    }

    public void deletePrimaryBeneficiary(){
        AppHelper.scrollToView(primaryBeneDelete.getCoreElement());
        setElementValue(primaryBeneDelete,false);

    }

    public void validateBeneficiariesDeleteQuestion(){
        beneficiariesDeleteQuestion.validateData(DataTypes.Data);
    }

    public void validateBeneficiariesDescription(){
        beneficiariesDescription.initPage(getContext());
        beneficiariesDescription.validateAll();
    }

    public void validateBeneficiariesSkipQuestionandDetails(){
       beneficiariesSkipQuestion.validateData(DataTypes.Data);
       beneficiariesSkipDetails.validateData(DataTypes.Data);
    }

    public void addPrimaryBeneficiary(){
        AppHelper.scrollToView(beneficiariesAdd.getCoreElement());
        setElementValue(beneficiariesAdd,false);
    }

    public void addMultiplePrimaryBeneficiary(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement add= wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("(//*[@data-omni-key='PrimaryBeneficiaries']//span[contains(text(),'"+beneficiariesAdd.getData()+"')])[last()]")));
        AppHelper.scrollToView(add);
        add.click();
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

    public void addBeneficiary(){
        AppHelper.scrollToView(BeneRadioButton.getCoreElement());
        AppHelper.waitForXHR(2);
        setElementValue(BeneRadioButton,false);
    }

    /*For multiple beneficiaries*/
    public void additionalBeneficiary(){
        WebElement BeneRadio=getDriver().findElement(By.xpath("(//*[@data-omni-key='PrimaryBeneficiaryType']//span[contains(text(),'"+BeneRadioButton.getData()+"')])[last()]"));
        AppHelper.waitForXHR(2);
        BeneRadio.click();
    }

    public void selectPersonRelationBeneficiary(){
        AppHelper.scrollToView(personBeneficiaryRelation.getCoreElement());
        setElementValue(personBeneficiaryRelation);
    }

    public void selectAdditionalPersonRelationBeneficiary(){
      additionalPersonBeneficiaryRelation.click();
      WebElement additionalPersonBeneficiarySelectRelation=getDriver().
              findElement(By.xpath("(//*[@data-omni-key='PrimaryRelationship']//li/div[@data-label='"+personBeneficiaryRelation.getData()+"'])[last()]"));
      additionalPersonBeneficiarySelectRelation.click();
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
    public void validateAndEnterDuplicateDetailsPrimaryBeneficiary(){
        primaryDuplicateFirstName.sendKeys(primaryFirstName.getData());
        AppHelper.scrollToView(primaryDuplicateLastName);
        primaryDuplicateLastName.sendKeys(primaryLastName.getData());
        AppHelper.scrollToView(primaryDuplicateAllocation);
        primaryDuplicateAllocation.sendKeys(primaryAllocation.getData());

    }
    public void validatePrimaryBeneficiaryOnEdit(){
        primaryFirstName.getValue().contains(primaryFirstName.getData());
        primaryLastName.getValue().contains(primaryLastName.getData());
        AppHelper.scrollToView(primaryAllocation.getCoreElement());
        primaryAllocation.getValue().contains(primaryAllocation.getData());

    }
    public void validateAndEnterPrimaryallocation(){
        setElementValue(primaryAllocation);

    }
    public void validateErrors(){
        primaryFirstNameError.validateError(DataTypes.Data);
        primaryLastNameError.validateError(DataTypes.Data);
        primaryAllocationError.validateError(DataTypes.Data);

    }
    public void validateAllocationError() {
        AppHelper.scrollToView(beneficiariesAllocationError.getCoreElement());
        beneficiariesAllocationError.validateBannerError(DataTypes.Data);
    }
    public void validateDuplicateBeneDetailsError() {
        AppHelper.scrollToView(beneficiariesDuplicateError.getCoreElement());
        beneficiariesDuplicateError.getBannerErrorMsg();
        beneficiariesDuplicateError.validateBannerError(DataTypes.Data);
    }
    public void validatePillInformation(){
        AppHelper.scrollToView(beneficiaryType.getCoreElement());
        beneficiaryType.validateBeneficiaryTypePerson(DataTypes.Data);
        beneficiaryType.validateBeneficiaryName(DataTypes.Expected);
        beneficiaryAllocationPercentage.validateAllocationPercentage(DataTypes.Data);
    }

    public void deleteAllTestRecords() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.deleteAllBeneficiaryDetails(primaryFirstName.getData(),primaryLastName.getData(),
                Float.valueOf(beneficiaryAllocationPercentage.getData(DataTypes.Initial)));
    }

    public void validateSalesforceBeneficiaryRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetails(primaryFirstName.getData(),primaryLastName.getData(),
              Float.valueOf(beneficiaryAllocationPercentage.getData(DataTypes.Initial)));
    }
    public void validateSalesforceBeneficiaryRecordDeleted() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetailsDeleted(primaryFirstName.getData(),primaryLastName.getData(),
                Float.valueOf(beneficiaryAllocationPercentage.getData(DataTypes.Initial)));
    }
    public void validateQuebecQuestionAndLabels() {
        AppHelper.scrollToView(beneficiaryRevocableQuestion.getCoreElement());
        beneficiaryRevocableQuestion.validateLabelHeader(DataTypes.Data);
        beneficiaryRevocableQuestion.validateCheckboxLabel(DataTypes.Initial);
    }

    public void validateRevocableCheckBox() {
        AppHelper.scrollToView(beneficiaryRevocableQuestion.getCoreElement());
        setElementValue(beneficiaryRevocableQuestion,false);
    }

    public void unCheckRevocableCheckBox() {
        AppHelper.scrollToView(beneficiaryRevocableQuestion.getCoreElement());
        setElementValue(beneficiaryRevocableQuestion,false);
    }

    public void validateSalesforceRevocableBox(String value) {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        switch(value){
            case "true":
                salesforceInfo.checkRevocableDetails(primaryFirstName.getData(),primaryLastName.getData(),
                        "true");
                break;

            case "false":
                salesforceInfo.checkRevocableDetails(primaryFirstName.getData(),primaryLastName.getData(),
                        "false");
                break;

        }
    }

    public void validateAllocationErrorTotalAndLogo(){
        beneficiariesAllocationTotal.getCoreElement();
        beneficiariesAllocationTotal.getAllocationPercentage();
        beneficiariesAllocationTotal.validateAllocationPercentage(DataTypes.Expected);
        beneficiariesAllocationPercentage.validateAllocationError(DataTypes.Data);
        allocationInlineError.getCoreElement();
        allocationInlineError.validateAllocationInlineError(DataTypes.Data);

    }

    public void validateAllocationSuccessTotalAndLogo(){
        beneficiariesAllocationTotal.getCoreElement();
        WebElement beneAllocationTotal=getDriver().findElement(By.
                xpath("//div[contains(text(),'"+beneficiariesAllocationTotal.getData()+"')]"));
        String allocationTotalText=beneAllocationTotal.getText();
        String expectedAllocationTotalText=beneficiariesAllocationTotal.getData();
        Assertions.assertThat(allocationTotalText).isEqualTo(expectedAllocationTotalText);

        WebElement allocationAddedTotal=getDriver().findElement(By.xpath("//*[contains(@class,'allocation-total allocation-success')]"));
        String AllocationAddedTot=allocationAddedTotal.getText();
        String expectedAllocationAddedTot=beneficiariesAllocationAddedTotal.getData(DataTypes.Data);
        Assertions.assertThat(AllocationAddedTot).isEqualTo(expectedAllocationAddedTot);

    }

    public void validateAdditionalAllocationErrorTotalAndLogo(){
        beneficiariesAllocationTotal.getCoreElement();
        WebElement beneAllocationTotal=getDriver().findElement(By.
                xpath("//div[contains(text(),'"+beneficiariesAllocationTotal.getData()+"')]"));
        String allocationTotalText=beneAllocationTotal.getText();
        String expectedAllocationTotalText=beneficiariesAllocationTotal.getData();
        Assertions.assertThat(allocationTotalText).isEqualTo(expectedAllocationTotalText);

        WebElement allocationAddedTotal=getDriver().findElement(By.xpath("//*[contains(@class,'allocation-total allocation-fail')]"));
        String AllocationAddedTot=allocationAddedTotal.getText();
        String expectedAllocationAddedTot=beneficiariesAllocationAddedTotal.getData(DataTypes.Expected);
        Assertions.assertThat(AllocationAddedTot).isEqualTo(expectedAllocationAddedTot);

        WebElement allocationInline=getDriver().findElement(By.xpath("//*[contains(@class,'nds-size_1-of-1 allocation-error')]"));
        String allocationInlineText=allocationInline.getText();
        String expectedAllocationInlineMsg=allocationInlineError.getData();
        Assertions.assertThat(allocationInlineText).isEqualTo(expectedAllocationInlineMsg);

    }
}
