package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class NRSPAdditionalInfoPO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='NRSP_AreYouaUSCitizen']")
    private RadioGroup usCitizenYes;

    @FindBy(xpath = "//*[@data-omni-key='NRSP_AreYouaUSCitizen']")
    private RadioGroup usCitizenNo;

    @FindBy(xpath = "//*[@data-omni-key='Are_You_A_Resident_Of_Other_Country']")
    private RadioGroup otherCitizenYes;

    @FindBy(xpath = "//*[@data-omni-key='Are_You_A_Resident_Of_Other_Country']")
    private RadioGroup otherCitizenNo;

    @FindBy(xpath = "//*[@data-omni-key='NRSP_Do_You_Have_A_TIN']")
    private RadioGroup secondaryTINyes;

    @FindBy(xpath = "//*[@data-omni-key='NRSP_Do_You_Have_A_TIN']")
    private RadioGroup secondaryTINno;

    @FindBy(xpath = "//*[@data-omni-key='Select_CountryOfResidence']")
    private VlocitySelect selectCountry;

    @FindBy(xpath = "//*[@data-omni-key='US_TIN_Number']")
    private VlocityActionInput usTinNumber;

    @FindBy(xpath = "//*[@data-omni-key='NRSP_NonUSCandaTIN']")
    private VlocityActionInput otherCountryTIN;

    @FindBy(xpath = "//*[@data-omni-key='NRSP_NonUSCandaTIN']")
    private VlocityActionInput otherCountryinvalidTIN;

    @FindBy(xpath = "//*[@data-omni-key='US_TIN_Number']//label")
    private WebComponentList ustaxpayerLabel;

    @FindBy(xpath = "//*[@data-omni-key='NRSP_NonUSCandaTIN']//label")
    private WebComponentList otherCountryTINlabel;

    @FindBy(xpath = "//*[@data-omni-key='Radio_Why_Do_not_Have_TIN']")
    private RadioGroup radiobuttonNoOtherTIN;

    @FindBy(xpath = "//*[@data-omni-key='TAReason_For_No_Tin']//label")
    private WebComponentList reasonLabel;

    @FindBy(xpath = "//*[@data-omni-key='TAReason_For_No_Tin']")
    private VlocityTextAreaInput reasonExplanationDetails;

    @Step("Click yes button for US Citizen Tax Purposes")
    public void clickYesforUSCitizen() {
        setElementValue(usCitizenYes);
    }

    @Step("Click yes button for Other Citizen Tax Purposes")
    public void clickYesforOtherCitizen() {
        AppHelper.scrollToView(otherCitizenYes.getCoreElement());
        setElementValue(otherCitizenYes);
    }

    @Step("Click yes button for Other Country TIN for Tax Purposes")
    public void clickYesforOtherTIN() {
        setElementValue(secondaryTINyes);
    }


    @Step("Select radio button for Another Reason for No Additional TIN")
    public void selectRadioButtonforNoAdditionalTIN() {
        AppHelper.scrollToView(radiobuttonNoOtherTIN.getCoreElement());
        setElementValue(radiobuttonNoOtherTIN);
    }

    @Step("Click no button for US Citizen Tax Purposes")
    public void clickNoforUSCitizen() {
        setElementValue(usCitizenNo);
    }

    @Step("Click no button for Other Citizen Tax Purposes")
    public void clickNoforOtherCitizen() {
        setElementValue(otherCitizenNo);
    }

    @Step("Click no button for Other Country TIN for Tax Purposes")
    public void clickNoforOtherTIN() {
        setElementValue(secondaryTINno);
    }

    @Step("Enter TIN for the US Tax Payer")
    public void enterTINforUSCitizen() {
        AppHelper.scrollToView(usTinNumber.getCoreElement());
        usTinNumber.click();
        setElementValue(usTinNumber);
    }

    @Step("Enter TIN for the Other Country Tax Payer")
    public void enterTINforNonUSCitizen(){
        AppHelper.scrollToView(otherCountryTIN.getCoreElement());
        otherCountryTIN.click();
        setElementValue(otherCountryTIN);
    }

    @Step("Enter invalid TIN for the Other Country Tax Payer")
    public void enterInvalidTINforNonUSCitizen() {
        AppHelper.scrollToView(otherCountryinvalidTIN.getCoreElement());
        otherCountryinvalidTIN.click();
        setElementValue(otherCountryinvalidTIN);
    }

    @Step("Enter Additional Input Details for no Other TIN Explanation")
    public void enterAdditionalDetailsforNoTIN() {
        AppHelper.scrollToView(reasonExplanationDetails.getCoreElement());
        reasonExplanationDetails.click();
        setElementValue(reasonExplanationDetails);
    }

    public void validateUStaxPayerLabel(){
        ustaxpayerLabel.initPage(getContext());
        ustaxpayerLabel.validateAll();
    }

    public void selectCountry(){
        setElementValue(selectCountry);
    }

    public void validateAdditionalTINinputlabel(){
        otherCountryTINlabel.initPage(getContext());
        otherCountryTINlabel.validateAll();

    }
    public void validateReasonforAdditionalTINLabel(){
        reasonLabel.initPage(getContext());
        reasonLabel.validateAll();

    }
    @Step("Validate error message when no input for TIN number for US tax Payer")
    public void errorMessageNoUSTIN(){
        AppHelper.waitForXHR(1);
        usTinNumber.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no selection for US Citizen or Other country Citizen for Tax Purposes")
    public void errorMessageNoselection(){
        AppHelper.waitForXHR(1);
        usCitizenYes.validateError(DataTypes.Initial);
        otherCitizenYes.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no country is selected")
    public void errorMessageNoCountrySelection(){
        AppHelper.waitForXHR(1);
        selectCountry.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no selection for secondary TIN")
    public void errorMessageNoSelectionsecondaryTIN(){
        AppHelper.waitForXHR(1);
        secondaryTINyes.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no input for TIN number for Other Country tax Payer")
    public void errorMessageNoOtherCountryTIN(){
        AppHelper.waitForXHR(1);
        otherCountryTIN.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when invalid input for TIN number for Other Country tax Payer")
    public void errorMessageInvalidOtherCountryTIN(){
        AppHelper.waitForXHR(1);
        otherCountryinvalidTIN.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no selection made for Radio button for No additional TIN")
    public void errorMessageNoRadioSelectionAdditionalTIN(){
        AppHelper.waitForXHR(1);
        radiobuttonNoOtherTIN.validateError(DataTypes.Initial);
    }

    @Step("Validate error message when no entry made for Additional Details for No TIN")
    public void errorMessageNoAdditionalDetailsProvided(){
        AppHelper.waitForXHR(1);
        reasonExplanationDetails.validateError(DataTypes.Initial);
    }

}
