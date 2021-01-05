package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.api.salesforce.SalesforceUpdateAsset;
import com.canadalife.automation.grsoe.api.salesforce.SalesforceUpdateLanguage;
import com.canadalife.automation.grsoe.support.AppHelper;
import datainstiller.data.Data;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.support.AliasedString;
import ui.auto.core.support.PageObjectModel;

@SuppressWarnings("unused")
public class LoginPO extends PageObjectModel {
    private AliasedString url;
    private AliasedString userRole;
    private AliasedString planId;
    private AliasedString division;
    private WebComponent username;
    private WebComponent password;
    @Data(skip = true)
    @FindBy(id = "Login")
    private WebComponent loginButton;

    @Data(skip = true)
    SalesforceUpdateLanguage salesforceUpdateLanguage;
    @Data(skip = true)
    SalesforceUpdateAsset salesforceUpdateAsset;

    public void login() {
        login(userRole.getData());
    }

    @Step("Login to the GRS lightning application as a \"{0}\"")
    public void login(String role) {
        getDriver().get(url.getData());
        setElementValue(username);
        setElementValue(password);
        loginButton.click();
        AppHelper.waitForXHR(2);
    }

    @Step("Logout of the GRS application")
    public void logout() {
        getDriver().get(url.getData() + "/secur/logout.jsp");
        AppHelper.waitForXHR(2);
    }

    @Step("Navigate to \"...{0}\" url")
    public void navigate(String url) {
        getDriver().get(this.url.getData() + url);
        AppHelper.waitForXHR(2);
    }

    public void update_locale(){
        AppHelper.waitForXHR(1);
        salesforceUpdateLanguage=new SalesforceUpdateLanguage();
        salesforceUpdateLanguage.updateLanguage(userRole.getData());
    }

    public void update_asset(){
        AppHelper.waitForXHR(1);
        salesforceUpdateAsset=new SalesforceUpdateAsset();
        salesforceUpdateAsset.updatedAssetDetails(planId.getData(),division.getData());
    }

}
