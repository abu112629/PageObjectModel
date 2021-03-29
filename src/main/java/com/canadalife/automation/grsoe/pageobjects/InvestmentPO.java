package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

import javax.xml.crypto.Data;

public class InvestmentPO extends PageObjectModel {

    @FindBy(xpath="//*[@data-omni-key='TargetDateHeaderDescriptionTB']//p")
    private WebComponentList investmentDescription;

    @FindBy(xpath="//*[@data-omni-key='TargetDateQuestionTB']//h3")
    private WebComponentList inputfieldQuestion;

    @FindBy(xpath="//*[@data-omni-key='TargetDateQuestionTB']//p[@id='targetDateFundAge']")
    private WebComponentList inputfieldTip;

    @FindBy(xpath="//*[@data-omni-key='TargetDateAgeInput']")
    private VlocityActionInput ageInput;

    @FindBy(xpath="//*[@data-omni-key='TargetDateAgeInput']")
    private VlocityActionInput ageInputError;

    @FindBy(xpath="//*[@class='nds-card-header-lwc']//h3")
    private WebComponent investmentCardHeader;

    @FindBy(xpath="//*[@class='nds-card-footer-lwc']//span")
    private WebComponent investmentCardSelected;

    @FindBy(xpath="//*[@class='nds-text-title nds-m-top_large']")
    private WebComponent investmentCardFundName;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundFeesLine;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardUpdatedFundFeesLine;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundRORline1;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardUpdatedFundRORline1;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundRORline2;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundRORline3;

    @FindBy(xpath="//*[@data-omni-key='TargetDateFundStep']//h2")
    private WebComponent investmentSkipQuestion;

    @FindBy(xpath="//*[starts-with(@class,'nds-col nds-m-bottom_xx-large nds-size_1-of-1')]")
    private WebComponent investmentSkipDetails;

    @FindBy(xpath="//*[@data-omni-key='InvestmentsAccordion']")
    private VlocityAccordion investmentTargetDateFundsAccordion;

    @FindBy(xpath="//*[@data-omni-key='InvestmentsAccordion']")
    private VlocityAccordion investmentTargetDateFundsAccordionContent;

    @FindBy(xpath="//*[@data-omni-key='InvestmentsAccordion']")
    private VlocityAccordion investmentFeesAccordion;

    @FindBy(xpath="//*[@data-omni-key='InvestmentsAccordion']")
    private VlocityAccordion investmentFeesAccordionContent;

    @FindBy(xpath="//*[@data-omni-key='InvestmentsAccordion']")
    private VlocityAccordion investmentRORAccordion;

    @FindBy(xpath="//*[@data-omni-key='InvestmentsAccordion']")
    private VlocityAccordion investmentRORAccordionContent;

    @FindBy(xpath="//*[@data-omni-key='showFundCardButton']")
    private VlocityButton showFundsButton;

    public void validateInvestmentDescription(){
        investmentDescription.initPage(getContext());
        investmentDescription.validateAll();
    }

    public void validateInputFieldQuestion(){
        inputfieldQuestion.initPage(getContext());
        inputfieldQuestion.validateAll();
    }

    public void validateInputFieldTip(){
        inputfieldTip.initPage(getContext());
        inputfieldTip.validateAll();
    }

    public void validateAgeInput(){
        AppHelper.scrollToView(ageInput.getCoreElement());
        ageInput.getValue().contains("65");

    }

    public void validateUpdatedAgeInput(){
        AppHelper.scrollToView(ageInput.getCoreElement());
        ageInput.getValue().contains("99");

    }

    public void enterInvalidAge(){
        AppHelper.scrollToView(ageInputError.getCoreElement());
        setElementValue(ageInputError);
    }
    public void validateAgeInputError(){
        AppHelper.scrollToView(ageInputError.getCoreElement());
        ageInputError.validateError(DataTypes.Initial);

    }
    public void enterAge(){
        AppHelper.scrollToView(ageInput.getCoreElement());
        setElementValue(ageInput);
    }

    public void clickShowFundsButton(){
        AppHelper.scrollToView(showFundsButton.getCoreElement());
        setElementValue(showFundsButton,false);
    }
    public void validateFundFeeLines(){
        AppHelper.scrollToView(investmentCardFundFeesLine.getCoreElement());
        investmentCardFundFeesLine.getFundFeesDetails();
        investmentCardFundFeesLine.validateFundFees(DataTypes.Expected);

        investmentCardFundRORline1.getFundFeesDetails();
        investmentCardFundRORline1.validateFundFees(DataTypes.Expected);

        investmentCardFundRORline2.getFundFeesDetails();
        investmentCardFundRORline2.validateFundFees(DataTypes.Expected);

        investmentCardFundRORline3.getFundFeesDetails();
        investmentCardFundRORline3.validateFundFees(DataTypes.Expected);
    }

    public void validateUpdatedFundFeeLines(){
        AppHelper.scrollToView(investmentCardUpdatedFundFeesLine.getCoreElement());
        investmentCardUpdatedFundFeesLine.getFundFeesDetails();
        investmentCardUpdatedFundFeesLine.validateFundFees(DataTypes.Expected);

        investmentCardUpdatedFundRORline1.getFundFeesDetails();
        investmentCardUpdatedFundRORline1.validateFundFees(DataTypes.Expected);
    }

    public void validateInvestmentCardHeader(){
        investmentCardHeader.validateData(DataTypes.Data);
    }

    public void validateInvestmentCardHeaderUpdated(){
        investmentCardHeader.validateData(DataTypes.Expected);
    }

    public void validateInvestmentCardSelected(){
        investmentCardSelected.validateData(DataTypes.Data);
    }

    public void validateInvestmentFundName(){
        investmentCardFundName.validateData(DataTypes.Data);
    }

    public void validateInvestmentFundNameUpdated(){
        investmentCardFundName.validateData(DataTypes.Expected);
    }

    public void validateTheInvestmentSkipQuestionandDetails(){
        investmentSkipQuestion.validateData(DataTypes.Data);
        investmentSkipDetails.validateData(DataTypes.Data);
    }

    public void validateTheInvestmentAccordionDetails(){
        setElementValue(investmentTargetDateFundsAccordion);/*Click on Accordion*/
        investmentTargetDateFundsAccordionContent.validateAccordionContent(DataTypes.Initial);
        setElementValue(investmentTargetDateFundsAccordion);/*UnClick on Accordion*/

        AppHelper.waitForXHR(2);
        AppHelper.scrollToView(investmentFeesAccordion.getCoreElement());
        setElementValue(investmentFeesAccordion,false);/*Click on Accordion*/
        investmentFeesAccordionContent.validateDetailsText(DataTypes.Initial);
        setElementValue(investmentFeesAccordion,false);/*UnClick on Accordion*/

        AppHelper.waitForXHR(2);
        AppHelper.scrollToView(investmentRORAccordion.getCoreElement());
        setElementValue(investmentRORAccordion,false);/*Click on Accordion*/
        investmentRORAccordionContent.validateDetailsText(DataTypes.Initial);
        setElementValue(investmentRORAccordion,false);/*UnClick on Accordion*/
    }
}

