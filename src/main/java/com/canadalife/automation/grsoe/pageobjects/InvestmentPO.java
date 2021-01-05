package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.VlocityActionInput;
import com.canadalife.automation.grsoe.components.VlocityInput;
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
        ageInput.validateData(DataTypes.Expected);
        setElementValue(ageInput);

    }

    public void validateInvestmentCardHeader(){
        investmentCardHeader.validateData(DataTypes.Data);
    }

    public void validateInvestmentCardSelected(){
        investmentCardSelected.validateData(DataTypes.Data);
    }
}

