package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.PlanRadioGroup;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.canadalife.automation.grsoe.support.LocatorAndValue;
import datainstiller.data.Data;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;
import ui.auto.core.utils.WebHelper;

import java.util.List;

public class PlanSelectionPO extends PageObjectModel {

    @FindBy(xpath="//*[@class='nds-m-right_x-small']")
    private PlanRadioGroup planAdditionalInfoQuestions;

    @FindBy(xpath = "//c-eligible-plan-card")
    private PlanRadioGroup planList;

    @FindBy(xpath="//*[@class='heading']")
    private PlanRadioGroup planHeader;

    @FindBy(xpath="//*[@class='subHeading']")
    private PlanRadioGroup plansubHeader;

    @Data(skip = true)
    @FindBy(xpath = "//*[starts-with(@name,'back')]")
    private WebComponent buttonBack;
    @Data(skip = true)
    @FindBy(xpath = "//*[starts-with(@name,'continue')]")
    private WebComponent buttonContinue;

    @Data(skip = true)
    @FindBy(xpath = "//*[starts-with(@name,'skip-back')]")
    private WebComponent buttonSkipBack;
    @Data(skip = true)
    @FindBy(xpath = "//*[starts-with(@name,'skip-continue')]")
    private WebComponent buttonSkipContinue;

    @FindBy(xpath="//h1[contains(@class,'h1')]")
    private WebComponentList planProgressBarInfo;

    @FindBy(xpath="//h2[contains(@class,'n-progress__label')]")
    private WebComponentList planProgressBarStep;

    @FindBy(xpath = "//span[contains(@class,'nds-form-element__static')]")
    private WebComponentList hintText;

    @FindBy(xpath = "//c-cloe-o-s-error-message//p")
    private WebComponent errorMessage;

    @FindBy(css="img.cl-logo")
    private WebComponent canadalifeLogo;

    @FindBy(xpath="//*[contains(@class,'footer')]//div/div[1]")
    private WebComponentList canadalifeFooter;

    @FindBy(xpath="//*[contains(@class,'footer')]//a")
    private WebComponentList canadalifeFooterlinks;

    private List<LocatorAndValue> errors;

    @Step("Click continue button")
    public void clickContinueButton() {
        AppHelper.scrollToView(buttonContinue.getCoreElement());
        buttonContinue.click();
        AppHelper.waitForXHR(3);
    }

    @Step("Click back button")
    public void clickBackButton() {
        AppHelper.scrollToView(buttonBack.getCoreElement());
        buttonBack.click();
        AppHelper.waitForXHR(2);
    }

    @Step("Click Skip continue button")
    public void clickSkipContinueButton() {
        AppHelper.scrollToView(buttonSkipContinue.getCoreElement());
        buttonSkipContinue.click();
        AppHelper.waitForXHR(3);
    }

    @Step("Click Skip back button")
    public void clickSkipBackButton() {
        AppHelper.scrollToView(buttonSkipBack.getCoreElement());
        buttonSkipBack.click();
        AppHelper.waitForXHR(2);
    }

    public void validateAdditionalQuestions(){
        planAdditionalInfoQuestions.validateAll();
    }

    public void validatePlansDescription() {
        planList.validateAll();
    }

    public void validatePlansHeader(){
        planHeader.validateAll();
    }

    public void validatePlanssubHeader(){
        plansubHeader.validateAll();
    }

    public void validateHinttextLabels(){
        hintText.initPage(getContext());
        hintText.validateAll();
    }

    public void validatePlanProgressBarInfo(){
        planProgressBarInfo.initPage(getContext());
        planProgressBarInfo.validateAll();
    }
    public void validatePlanProgressBarStep(){
        planProgressBarStep.initPage(getContext());
        planProgressBarStep.validateAll();
    }

    public void validatePlanSelection() {
        planList.getElements().forEach((plan)-> {
            planList.select(plan);
            planList.isSelected(plan);
        });
    }

    public void validatePlanRetention() {
        String plan = planList.getToSelect();
        planList.select(plan);
        clickContinueButton();
        clickBackButton();
        planList.isSelected(plan);
    }

    public void selectRequiredPlan() {
        String plan = planList.getToSelect();
        planList.select(plan);
    }


    public void validateErrorMessage() {
        AppHelper.scrollToView(errorMessage.getCoreElement());
        errorMessage.validateData(DataTypes.Expected);
    }

    public void validateErrorMessageVanishes() {
        List<WebElement> error= getDriver().findElements(By.xpath("//c-cloe-o-s-error-message//p"));
        if(error.size()==0){
            System.out.println("Error Message is not displayed for no plan selection");
        }
    }
    public void validateErrorMessages() {
        By err1 = By.xpath(errors.get(0).getLocator());
        WebElement error1 = WebHelper.getWebDriiverWait().until(ExpectedConditions.visibilityOfElementLocated(err1));
        Assertions.assertThat(error1.getText()).isEqualTo(errors.get(0).getValue());
    }

    public void validateCanadaLifeLogo(){
        Assertions.assertThat(canadalifeLogo.getAttribute("outerHTML")).
                isEqualTo(canadalifeLogo.getData());
    }

    public void validateCanadaLifeFooter(){
        canadalifeFooter.initPage(getContext());
        canadalifeFooter.validateAll();
    }

    public void validateCanadaLifeFooterlinks(){
        canadalifeFooterlinks.initPage(getContext());
        canadalifeFooterlinks.validateAll();
    }
}
