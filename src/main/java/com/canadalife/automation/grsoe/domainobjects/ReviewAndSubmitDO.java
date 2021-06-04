package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class ReviewAndSubmitDO extends DomainObjectModel {

    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private ProfileInformationPO profileInformationPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;
    private BeneficiariesPO beneficiariesPO;
    private RPPAdditionalInfoPO rppAdditionalInfoPO;
    private DPSPAdditionalInfoPO dpspAdditionalInfoPO;

    private ReviewAndSubmitDO() {}
    public ReviewAndSubmitDO(TestContext context){
        this.context = context;
    }

    @Step("{0} Member on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("Plan Selection Page");
    }

    @Step("{0} Member can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("Select Plan");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks continue and selects no for both questions")
    public void user_clicks_continue_and_selects_no_for_both_questions(String gwt){
        nrspAdditionalInfoPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();

    }

    @Step("{0} user clicks continue and selects no for both questions in RPP plan")
    public void user_clicks_continue_and_selects_no_for_both_questions_in_rpp(String gwt) {
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.clickNoforspouse();
        rppAdditionalInfoPO.clickNoforconnectedperson();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user clicks no for connected person for DPSP plan")
    public void user_clicks_no_for_connected_person_for_dpsp_plan(String gwt) {
        dpspAdditionalInfoPO.initPage(getContext());
        dpspAdditionalInfoPO.clickNoforconnectedperson();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user selects TFSA plan and clicks continue")
    public void user_selects_tfsa_plan_and_clicks_continue(String gwt){
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickSkipContinueButton();
        TestNGBase.takeScreenshot("");
    }
    @Step("{0} user validates beneficiaries Skip section and clicks continue")
    public void user_validates_beneficiaries_skip_section(String gwt){
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSkipContinueButton();

    }

    @Step("{0} user clicks back and reach add beneficiaries page")
    public void user_clicks_back_and_reach_add_beneficiaries_page(String gwt){
        planSelectionPO.clickBackButton();
        beneficiariesPO.initPage(getContext());
        beneficiariesPO.validateBeneficiariesDescription();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickSkipContinueButton();
        TestNGBase.takeScreenshot("");
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
        profileInformationPO.validateReviewProfileHeader();
        profileInformationPO.validateProfileDescription();
        profileInformationPO.validateProfileLabels();
        profileInformationPO.validateProfileInformation();
    }

    @Step("{0} user clicks continue button")
    public void user_clicks_continue_button(String gwt){
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks submit button")
    public void user_clicks_submit_button(String gwt){
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks back button")
    public void user_clicks_back_button(String gwt){
        planSelectionPO.clickBackButton();
    }

    @Step("{0} Member can view the Plan Profile Information and Details")
    public void user_can_view_the_plan_profile_information_and_details(String gwt){
        AppHelper.waitForXHR(2);
        profileInformationPO.initPage(getContext());
        profileInformationPO.validatePlanProfileHeader();
        profileInformationPO.validatePlanFieldLabels();
        profileInformationPO.validatePlanFieldData();
    }

    @Step("{0} Member can view the DPSP Plan Additional Information and Details")
    public void user_can_view_the_dpsp_plan_additional_information_and_details(String gwt){
        AppHelper.waitForXHR(2);
        profileInformationPO.initPage(getContext());
        profileInformationPO.validateAdditionalInfoHeader();
        profileInformationPO.validateAdditionalInfoDPSPLabel();
        profileInformationPO.validateAdditionalInfoDPSPData();
    }
}
