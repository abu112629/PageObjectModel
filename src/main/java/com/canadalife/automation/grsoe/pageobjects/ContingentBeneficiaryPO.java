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
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.SelectComponent;
import ui.auto.core.components.WebComponent;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class ContingentBeneficiaryPO extends PageObjectModel {

    @FindBy(xpath="//*[@data-omni-key='ContingentBeneHeadingTextBlock']//h3")
    private WebComponent contingentBeneficiaryHeader;

    @FindBy(xpath="//*[@data-omni-key='ContingentBeneHeadingTextBlock']//p")
    private WebComponent contingentBeneficiaryDescription;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentBeneficiaries'])[last()]")
    private VlocitySelectRadioButton contingentBeneficiariesAdd;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']//h4")
    private WebComponent addContingentBeneficiaryLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']//p")
    private WebComponent addContingentBeneficiaryHintLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaryType']")
    private RadioGroup contingentTypeLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaryType']")
    private VlocitySelectRadioButton BeneRadioButton;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentBeneficiaryType']//span[contains(text(),'Organization')])[last()]")
    private WebElement BeneOrganizationRadioButton;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentBeneficiaryType']//span[contains(text(),'Estate')])[last()]")
    private WebElement BeneEstateRadioButton;

    @FindBy(xpath = "//*[@data-omni-key='ContingentRelationship']")
    private VlocitySelectRadioButton personDropDownQuestion;

    @FindBy(xpath = "//*[@data-omni-key='ContingentRelationship']")
    private VlocitySelect personBeneficiaryRelation;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentRelationship']//input)[last()]")
    private WebElement additionalPersonBeneficiaryRelation;

    @FindBy(xpath = "//*[@data-omni-key='ContingentFirstName']")
    private VlocityInput contingentFirstName;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentFirstName'])[last()]")
    private WebElement contingentDuplicateFirstName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentFirstName']")
    private VlocityActionInput contingentFirstNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentFirstName']")
    private VlocityInput contingentFirstNameError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentLastName']")
    private VlocityInput contingentLastName;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentLastName'])[last()]")
    private WebElement contingentDuplicateLastName;

    @FindBy(xpath = "//*[@data-omni-key='ContingentLastName']")
    private VlocityActionInput contingentLastNameInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentLastName']")
    private VlocityInput contingentLastNameError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']")
    private VlocityInput contingentDateOfBirth;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']//input[@type='number'][starts-with(@id, 'day')]")
    private WebComponent contingentDateOfBirthInput;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']")
    private VlocityInput contingentMonthLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']//select[starts-with(@id, 'month')]")
    private SelectComponent contingentMonthOfBirthInput;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']")
    private VlocityInput contingentDateLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']")
    private VlocityInput contingentYearLabel;

    @FindBy(xpath = "//*[@data-omni-key='ContingentDateOfBirth']//input[@type='number'][starts-with(@id, 'year')]")
    private WebComponent contingentYearOfBirthInput;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationPerson']")
    private VlocityActionInput contingentAllocation;

    @FindBy(xpath = "(//*[@data-omni-key='ContingentAllocationPerson'])[last()]")
    private WebElement contingentDuplicateAllocation;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationPerson']")
    private VlocityInput contingentAllocationInvalid;

    @FindBy(xpath = "//*[@data-omni-key='ContingentAllocationPerson']")
    private VlocityInput contingentAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryType;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelect beneficiaryAllocationPercentage;

    @FindBy(xpath = "//*[@data-omni-key='ContingentIsRevocableCheckbox']")
    private VlocityCheckBox beneficiaryRevocableQuestion;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton contingentBeneEdit;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton contingentBeneDelete;

    @FindBy(xpath="//*[@data-omni-key='YourBeneficiaries']//h2")
    private WebComponent beneficiariesDeleteQuestion;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesDuplicateError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAllocationError;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAllocationAddedTotal;

    @FindBy(xpath = "//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton beneficiariesAllocationTotal;

    @FindBy(xpath="//*[@data-omni-key='ContingentBeneficiaries']")
    private VlocitySelectRadioButton allocationInlineError;

    @Data(skip = true)
    SalesforceInfo salesforceInfo;

    @Step("Enter Date Of Birth Details")
    public void enterDOBDetails() {
        setElementValue(contingentMonthOfBirthInput, false);
        setElementValue(contingentDateOfBirthInput);
        setElementValue(contingentYearOfBirthInput);

    }
    public void validateContingentBeneficiaryHeaderAndDescription(){
        contingentBeneficiaryHeader.validateData(DataTypes.Data);
        contingentBeneficiaryDescription.validateData(DataTypes.Data);
    }

    public void editContingentBeneficiary(){
        setElementValue(contingentBeneEdit,false);
    }

    public void deleteContingentBeneficiary(){
        AppHelper.scrollToView(contingentBeneDelete.getCoreElement());
        setElementValue(contingentBeneDelete,false);

    }

    public void validateBeneficiariesDeleteQuestion(){
        beneficiariesDeleteQuestion.validateData(DataTypes.Data);
    }

    public void addContingentBeneficiary(){
        AppHelper.scrollToView(contingentBeneficiariesAdd.getCoreElement());
        setElementValue(contingentBeneficiariesAdd,false);
    }

    public void addMultipleContingentBeneficiary(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        WebElement add= wait.until(ExpectedConditions.elementToBeClickable(By.
                xpath("(//*[@data-omni-key='ContingentBeneficiaries']//span[contains(text(),'" +
                        ""+contingentBeneficiariesAdd.getData()+"')])[last()]")));
        add.click();
    }

    public void validateBeneficiaryFormLabels(){
        AppHelper.scrollToView(addContingentBeneficiaryLabel.getCoreElement());
        addContingentBeneficiaryLabel.validateData(DataTypes.Data);
        addContingentBeneficiaryHintLabel.validateData(DataTypes.Data);
        contingentTypeLabel.validateLabelHeader(DataTypes.Data);
        personDropDownQuestion.validateSelectionLabel(DataTypes.Data);

        AppHelper.scrollToView(contingentFirstName.getCoreElement());
        contingentFirstName.validateInputLabel(DataTypes.Initial);
        contingentLastName.validateInputLabel(DataTypes.Initial);

        contingentDateOfBirth.getInputTextLabel();
        contingentDateOfBirth.validateInputTextLabel(DataTypes.Expected);

        contingentMonthLabel.getInputTextLabel();
        contingentMonthLabel.validateInputTextLabel(DataTypes.Expected);

        contingentDateOfBirth.getInputTextLabel();
        contingentDateOfBirth.validateInputTextLabel(DataTypes.Expected);

        contingentYearLabel.getInputTextLabel();
        contingentYearLabel.validateInputTextLabel(DataTypes.Expected);

        AppHelper.scrollToView(contingentAllocation.getCoreElement());
        contingentAllocation.validateInputLabel(DataTypes.Initial);
    }

    public void addBeneficiary(){
        AppHelper.scrollToView(BeneRadioButton.getCoreElement());
        AppHelper.waitForXHR(2);
        setElementValue(BeneRadioButton,false);
    }

    /*For multiple beneficiaries*/
    public void additionalBeneficiary(){
        WebElement BeneRadio=getDriver().
                findElement(By.xpath("(//*[@data-omni-key='ContingentBeneficiaryType']//span[contains(text(),'"+BeneRadioButton.getData()+"')])[last()]"));
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
                findElement(By.xpath("(//*[@data-omni-key='ContingentRelationship']//li/div[@data-label='"+personBeneficiaryRelation.getData()+"'])[last()]"));
        additionalPersonBeneficiarySelectRelation.click();
    }

    public void validateInvalidPersonBeneficiaryDetails() {
        contingentFirstNameInvalid.click();
        setElementValue(contingentFirstNameInvalid);
        AppHelper.waitForXHR(2);
        contingentFirstNameInvalid.validateError(DataTypes.Initial);

        contingentLastNameInvalid.click();
        setElementValue(contingentLastNameInvalid);
        AppHelper.waitForXHR(2);
        contingentLastNameInvalid.validateError(DataTypes.Initial);

        AppHelper.scrollToView(contingentAllocation.getCoreElement());
        contingentAllocationInvalid.click();
        setElementValue(contingentAllocationInvalid);
        AppHelper.waitForXHR(2);
        contingentAllocationInvalid.validateError(DataTypes.Initial);

    }
    public void validateAndEnterDetailsContingentBeneficiary(){
        setElementValue(contingentFirstName);
        setElementValue(contingentLastName);
        AppHelper.scrollToView(contingentAllocation.getCoreElement());
        setElementValue(contingentAllocation);

    }
    public void validateAndEnterDuplicateDetailsContingentBeneficiary(){
        contingentDuplicateFirstName.sendKeys(contingentFirstName.getData());
        AppHelper.scrollToView(contingentDuplicateLastName);
        contingentDuplicateLastName.sendKeys(contingentLastName.getData());
        AppHelper.scrollToView(contingentDuplicateAllocation);
        contingentDuplicateAllocation.sendKeys(contingentAllocation.getData());

    }
    public void validateContingentBeneficiaryOnEdit(){
        contingentFirstName.getValue().contains(contingentFirstName.getData());
        contingentLastName.getValue().contains(contingentLastName.getData());
        AppHelper.scrollToView(contingentAllocation.getCoreElement());
        contingentAllocation.getValue().contains(contingentAllocation.getData());

    }
    public void validateAndEnterContingentAllocation(){
        setElementValue(contingentAllocation);

    }
    public void validateErrors(){
        contingentFirstNameError.validateError(DataTypes.Data);
        contingentLastNameError.validateError(DataTypes.Data);
        contingentAllocationError.validateError(DataTypes.Data);

    }
    public void validateAllocationError() {
        AppHelper.scrollToView(beneficiariesAllocationError.getCoreElement());
        beneficiariesAllocationError.validateBannerError(DataTypes.Data);
    }
    public void validateDuplicateBeneDetailsError() {
        AppHelper.scrollToView(beneficiariesDuplicateError.getCoreElement());
        String ErrorMessage=beneficiariesDuplicateError.getCoreElement().findElements(By.xpath("//slot/p")).get(0).getText();
        String ExpectedErrorMessage=beneficiariesDuplicateError.getData();
        Assertions.assertThat(ErrorMessage).isEqualTo(ExpectedErrorMessage);
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
        salesforceInfo.deleteAllBeneficiaryDetails(contingentFirstName.getData(),contingentLastName.getData(),
                Float.valueOf(beneficiaryAllocationPercentage.getData(DataTypes.Initial)));
    }

    public void validateSalesforceBeneficiaryRecord() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetails(contingentFirstName.getData(),contingentLastName.getData(),
                Float.valueOf(beneficiaryAllocationPercentage.getData(DataTypes.Initial)));
    }
    public void validateSalesforceBeneficiaryRecordDeleted() {
        AppHelper.waitForXHR(1);
        salesforceInfo = new SalesforceInfo();
        salesforceInfo.checkBeneficiaryDetailsDeleted(contingentFirstName.getData(),contingentLastName.getData(),
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
                salesforceInfo.checkRevocableDetails(contingentFirstName.getData(),contingentLastName.getData(),
                        "true");
                break;

            case "false":
                salesforceInfo.checkRevocableDetails(contingentFirstName.getData(),contingentLastName.getData(),
                        "false");
                break;

        }
    }

    public void validateAllocationErrorTotalAndLogo(){
        beneficiariesAllocationTotal.getCoreElement();
        beneficiariesAllocationTotal.getAllocationPercentage();
        beneficiariesAllocationTotal.validateAllocationPercentage(DataTypes.Expected);
        beneficiariesAllocationError.validateAllocationError(DataTypes.Expected);
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
