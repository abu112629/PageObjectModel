package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.canadalife.automation.grsoe.pageobjects.PlanSelectionPO;
import com.canadalife.automation.grsoe.pageobjects.ProfileInformationPO;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class ProfileInformationDO extends DomainObjectModel {

    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private ProfileInformationPO profileInformationPO;

    private ProfileInformationDO() {}
    public ProfileInformationDO(TestContext context){
        this.context = context;
    }

    @Step("{0} Member is on profile Information page")
    public void user_is_on_profile_information_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        planSelectionPO.initPage(getContext());
        TestNGBase.takeScreenshot("Plan Selection Page");
    }

    @Step("{0} Member can view the Profile Progress Bar Info and Step Details")
    public void user_can_view_the_profile_progress_bar_info_and_step_details(String gwt){
        AppHelper.waitForXHR(2);
        planSelectionPO.validatePlanProgressBarInfo();
        planSelectionPO.validatePlanProgressBarStep();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member can view the Profile Information and Details")
    public void user_can_view_the_profile_information_and_details(String gwt){
        AppHelper.waitForXHR(2);
        profileInformationPO.initPage(getContext());
        profileInformationPO.validateProfileHeader();
        profileInformationPO.validateProfileDescription();
        profileInformationPO.validateProfileLabels();
        profileInformationPO.validateProfileInformation();
    }
}
