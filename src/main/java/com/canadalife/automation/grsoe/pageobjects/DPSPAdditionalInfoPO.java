package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.RadioGroup;
import com.canadalife.automation.grsoe.support.AppHelper;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class DPSPAdditionalInfoPO extends PageObjectModel {

    @FindBy(xpath = "//*[@data-omni-key='DPSPConnectedPerson']")
    private RadioGroup connectedPersonbuttonYes;

    @FindBy(xpath = "//*[@data-omni-key='DPSPConnectedPerson']")
    private RadioGroup connectedPersonbuttonNo;

    @FindBy(xpath = "//*[(@data-omni-key='DPSPConnectedPerson')]//*[contains(@class,'nds-form-element__static')]")
    private WebComponentList connectedPersonDetailedText;

    @FindBy(xpath = "//*[(@data-omni-key='DPSPDisclaimer')]//slot/p")
    private WebComponent connectedPersonDisclaimer;

    @Step("Click yes button for connected person Question")
    public void clickYesforconnectedperson() {
        AppHelper.scrollToView(connectedPersonbuttonYes.getCoreElement());
        setElementValue(connectedPersonbuttonYes);
    }

    @Step("Click no button for connected person Question")
    public void clickNoforconnectedperson() {
        AppHelper.scrollToView(connectedPersonbuttonYes.getCoreElement());
        setElementValue(connectedPersonbuttonNo);
    }

    @Step("Validate error message when no selection for DPSP connected person questionnaire")
    public void errorMessageNoselection() {
        AppHelper.waitForXHR(1);
        connectedPersonbuttonYes.validateError(DataTypes.Initial);
    }

    public void validateConnectedPersonDetailsLabel() {
        connectedPersonDetailedText.initPage(getContext());
        connectedPersonDetailedText.validateAll();
    }

    @Step("Connected Person Disclaimer is visible on selecting yes for Connected Person")
    public void validateConnectedPersonDisclaimer() {
        AppHelper.scrollToView(connectedPersonbuttonYes.getCoreElement());
        AppHelper.waitForXHR(3);
        AppHelper.scrollToView(connectedPersonDisclaimer.getCoreElement());
        connectedPersonDisclaimer.validateData();
    }
}
