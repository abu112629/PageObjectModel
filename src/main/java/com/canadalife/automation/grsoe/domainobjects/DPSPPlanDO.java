package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.DPSPAdditionalInfoPO;
import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.canadalife.automation.grsoe.pageobjects.PlanSelectionPO;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class DPSPPlanDO extends DomainObjectModel {

    private LoginPO loginPO;
    private DPSPAdditionalInfoPO dpspAdditionalInfoPO;
    private PlanSelectionPO planSelectionPO;

    private DPSPPlanDO() {}
    public DPSPPlanDO(TestContext context){
        this.context = context;
    }

    @Step("{0} User on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        TestNGBase.takeScreenshot("");

        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can see Plan Headers and sub Headers")
    public void user_can_see_plan_headers_and_subheaders(String gwt) {
        planSelectionPO.validatePlansHeader();
        planSelectionPO.validatePlanssubHeader();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user can view the Plan Progress Bar Info and Step Details")
    public void user_can_view_the_plan_progress_bar_info_and_step_details(String gwt){
        AppHelper.waitForXHR(2);
        planSelectionPO.validatePlanProgressBarInfo();
        planSelectionPO.validatePlanProgressBarStep();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user can see error message on no selection and when click continue")
    public void user_can_see_error_messages_on_no_selection_and_click_continue(String gwt) {
        planSelectionPO.clickContinueButton();
        dpspAdditionalInfoPO.initPage(getContext());
        dpspAdditionalInfoPO.errorMessageNoselection();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects yes for connected person and is able to validate disclaimer")
    public void user_selects_yes_for_connected_person_and_is_able_to_validate_disclaimer(String gwt) {
        dpspAdditionalInfoPO.clickYesforconnectedperson();
        dpspAdditionalInfoPO.validateConnectedPersonDetailsLabel();
        dpspAdditionalInfoPO.validateConnectedPersonDisclaimer();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects yes for connected person and is not able to continue with DPSP Plan")
    public void user_selects_yes_for_connected_person_and_is_not_able_to_continue(String gwt) {
        planSelectionPO.clickContinueButton();
        dpspAdditionalInfoPO.validateConnectedPersonDisclaimer();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects no for connected person and is able to continue with DPSP Plan")
    public void user_selects_no_for_connected_person_and_is_able_to_continue(String gwt) {
        dpspAdditionalInfoPO.clickNoforconnectedperson();
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("");
    }
}
