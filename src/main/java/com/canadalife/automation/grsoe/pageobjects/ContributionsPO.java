package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.RadioGroup;
import com.canadalife.automation.grsoe.components.VlocityAccordion;
import com.canadalife.automation.grsoe.components.VlocityInput;
import com.canadalife.automation.grsoe.support.AppHelper;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class ContributionsPO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='NRSPContributionsLWC']//h3")
    private WebComponentList contributionAccountDetails;

    @FindBy(xpath = "//*[@data-omni-key='NRSPContributionsLWC']")
    private VlocityAccordion contributionAccordiondropdown;

    @FindBy(xpath = "//*[@data-omni-key='NRSPContributionsLWC']")
    private RadioGroup contributionEmployerPercentageRadioButton;

    @FindBy(xpath = "//*[@data-omni-key='NRSPContributionsLWC']")
    private RadioGroup contributionEmployerDollarRadioButton;

    @FindBy(xpath = "//*[@data-omni-key='EMPR']")
    private VlocityInput contributionEmployerInput;

    @FindBy(xpath = "//*[@data-omni-key='EMPR']")
    private VlocityInput contributionEmployerPercentageError;

    @FindBy(xpath = "//*[@data-omni-key='EMPR']")
    private VlocityInput contributionEmployerDollarError;

    @FindBy(xpath = "//*[@data-omni-key='MEM']")
    private VlocityInput contributionMemberInput;

    @FindBy(xpath = "//*[@data-omni-key='MEM']")
    private VlocityInput contributionMemberInvalidInput;

    @FindBy(xpath = "//*[@data-omni-key='MEM']")
    private VlocityInput contributionMemberError;

    @FindBy(xpath = "//span[contains(@class,'text-body')]")
    private WebComponentList contributionExplanation;


    @Step("Validate contribution account details")
    public void validateContributionAccount() {
        contributionAccountDetails.initPage(getContext());
        contributionAccountDetails.validateAll();
        contributionAccountDetails.validateUnordered();
    }

    @Step("Validate contribution accordion Content")
    public void validateContributionAccordionContent() {
        contributionAccordiondropdown.validateAccordionContent(DataTypes.Initial);
    }

    @Step("Validate accordion rules title and able to click dropdown arrow for accordion")
    public void validateClickforAccordionDropdown() {
        setElementValue(contributionAccordiondropdown);
    }

    @Step("Validate contribution heading when both options available on account")
    public void validateContributionHeadingDollarPercentage() {
        contributionEmployerPercentageRadioButton.validateContributionHeader(DataTypes.Initial);

    }

    @Step("Validate contribution label on account")
    public void validateContributionLabel() {
        contributionEmployerInput.validateContributionInputLabel(DataTypes.Initial);
        contributionMemberInput.validateContributionInputLabel(DataTypes.Initial);
    }

    @Step("Validate contribution error on Employer Account for Percentage")
    public void validateErrorPercentageEmployer() {
        AppHelper.waitForXHR(1);
        contributionEmployerPercentageError.validateError(DataTypes.Data);
    }

    @Step("Validate contribution error on Employer Account for Dollar")
    public void validateErrorDollarEmployer() {
        AppHelper.waitForXHR(1);
        contributionEmployerDollarError.validateError(DataTypes.Data);
    }

    @Step("Click Employer Account percentage input radio button and enter value")
    public void clickEmployerPercentageEnterInput() {
        setElementValue(contributionEmployerPercentageRadioButton);
        setElementValue(contributionEmployerInput);

    }

    @Step("Validate contribution amount input is retained")
    public void validateContributionAmountRetained() {
        contributionEmployerInput.getValue();
        contributionMemberInput.getValue();
    }

    @Step("Click Employer Account dollar input radio button and enter value")
    public void clickEmployerDollarEnterInput() {
        setElementValue(contributionEmployerDollarRadioButton);
        setElementValue(contributionEmployerInput);
    }

    @Step("Validate contribution error on Member Account")
    public void validateContributionErrorMember() {
        contributionMemberError.validateError(DataTypes.Data);
    }

    @Step("Enter invalid value in range for Member Account")
    public void enterMemberInvalidInput() {
        setElementValue(contributionMemberInvalidInput);
    }

    @Step("Enter valid value in range for Member Account")
    public void enterMemberValidInput() {
        setElementValue(contributionMemberInput);
    }

    @Step("Validate Plan account text with no Contribution available")
    public void validatePlanNoContributionsText() {
        contributionExplanation.initPage(getContext());
        contributionExplanation.validateAll();
    }
}
