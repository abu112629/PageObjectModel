package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.canadalife.automation.grsoe.pageobjects.NRSPAdditionalInfoPO;
import com.canadalife.automation.grsoe.pageobjects.PlanSelectionPO;
import com.canadalife.automation.grsoe.pageobjects.RPPAdditionalInfoPO;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class PlanDO extends DomainObjectModel {
    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;
    private RPPAdditionalInfoPO rppAdditionalInfoPO;

    private PlanDO() {}
    public PlanDO(TestContext context){
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

    @Step("{0} user presented with all available plans and with specific description")
    public void user_presented_with_all_available_plans_and_with_specific_description(String gwt) {
        planSelectionPO.validatePlansDescription();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user can select each plan")
    public void user_can_select_each_plan(String gwt) {
        planSelectionPO.validatePlanSelection();
    }

    @Step("{0} selected plan is retained when user clicks back button")
    public void selected_plan_is_retained_when_user_clicks_back_button(String gwt) {
        planSelectionPO.validatePlanRetention();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks continue button")
    public void user_clicks_continue_button(String gwt) {
        planSelectionPO.clickContinueButton();
        AppHelper.waitForXHR(2);
    }

    @Step("{0} user clicks Skip continue button")
    public void user_clicks_skip_continue_button(String gwt) {
        planSelectionPO.clickSkipContinueButton();
        AppHelper.waitForXHR(2);
    }

    @Step("{0} user clicks back button")
    public void user_clicks_back_button(String gwt) {
        planSelectionPO.clickBackButton();
        AppHelper.waitForXHR(2);
    }

    @Step("{0} user can select required Plan")
    public void user_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user can select new Plan")
    public void user_select_new_plan(String gwt) {
        planSelectionPO.selectNewPlan();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters information for RPP plan")
    public void user_enters_information_for_rpp_plan(String gwt) {
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.clickNoforspouse();
        rppAdditionalInfoPO.clickNoforconnectedperson();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user enters information for NRSP plan")
    public void user_enters_information_for_nrsp_plan(String gwt) {
        nrspAdditionalInfoPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        TestNGBase.takeScreenshot("");
    }
    @Step("{0} user selects a different plan and is able to see warning message")
    public void user_selects_different_plan_and_is_able_to_see_warning_message(String gwt) {
        planSelectionPO.validatePlanChangeHeader();
        planSelectionPO.validatePlanChangeQuestion();
    }

    @Step("{0} user selects no go back and previous plan selection is retained")
    public void user_selects_no_go_back_and_previous_plan_selection_retained(String gwt) {
        planSelectionPO.validatePlanRetentionAfterSkipBack();
    }

    @Step("{0} the correct error message is presented to user when user proceeds without selecting Plan")
    public void the_correct_error_message_is_presented_to_user(String gwt) {
        planSelectionPO.validateErrorMessage();
    }

    @Step("{0} user selects Plan and error message goes away")
    public void user_select_plan_and_error_message_vanishes(String gwt) {
        planSelectionPO.selectRequiredPlan();
        planSelectionPO.validateErrorMessageVanishes();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user can view the Plan Progress Bar Info and Step Details")
    public void user_can_view_the_plan_progress_bar_info_and_step_details(String gwt){
        AppHelper.waitForXHR(2);
        planSelectionPO.validatePlanProgressBarInfo();
        planSelectionPO.validatePlanProgressBarStep();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user can view the Canada Life Logo and Footer Links")
    public void user_can_view_the_canada_life_logo_and_footer_links(String gwt){
        planSelectionPO.validateCanadaLifeLogo();
        planSelectionPO.validateCanadaLifeFooter();
        planSelectionPO.validateCanadaLifeFooterlinks();
        TestNGBase.takeScreenshot("");
    }

}
