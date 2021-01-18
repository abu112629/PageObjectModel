package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.VlocityActionInput;
import com.canadalife.automation.grsoe.components.VlocityComponent;
import com.canadalife.automation.grsoe.components.VlocityInput;
import com.canadalife.automation.grsoe.components.VlocitySelect;
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

    @FindBy(xpath="//*[@class='nds-card-header-lwc']//h3")
    private WebComponent investmentCardHeader;

    @FindBy(xpath="//*[@class='nds-card-footer-lwc']//span")
    private WebComponent investmentCardSelected;

    @FindBy(xpath="//*[@class='nds-text-title nds-m-top_large']")
    private WebComponent investmentCardFundName;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundFeesLine;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundRORline1;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundRORline2;

    @FindBy(xpath="//*[@data-omni-key='CustomLWCTargetDateCard']")
    private VlocitySelect investmentCardFundRORline3;

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

    public void enterAge(){
        AppHelper.scrollToView(ageInput.getCoreElement());
        setElementValue(ageInput);
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

    public void validateInvestmentCardHeader(){
        investmentCardHeader.validateData(DataTypes.Data);
    }

    public void validateInvestmentCardSelected(){
        investmentCardSelected.validateData(DataTypes.Data);
    }

    public void validateInvestmentFundName(){
        investmentCardFundName.validateData(DataTypes.Data);
    }
}

