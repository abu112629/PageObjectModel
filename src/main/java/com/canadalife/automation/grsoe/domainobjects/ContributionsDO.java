package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;

@XStreamAlias("plan-domain-object")
public class ContributionsDO extends DomainObjectModel {
    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;
    private RPPAdditionalInfoPO rppAdditionalInfoPO;
    private ContributionsPO contributionsPO;

    private ContributionsDO() {}
    public ContributionsDO(TestContext context){
        this.context = context;
    }


    @Step("{0} Member on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.update_locale();
        loginPO.update_asset();
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");

        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can see contribution page for RPP plan")
    public void user_can_see_contribution_page_for_rpp_plan(String gwt) {
        rppAdditionalInfoPO.initPage(getContext());
        contributionsPO.initPage(getContext());
        rppAdditionalInfoPO.clickNoforspouse();
        rppAdditionalInfoPO.clickNoforconnectedperson();
        planSelectionPO.clickContinueButton();
        contributionsPO.validateContributionAccount();

    }

    @Step("{0} user can see contribution rules in accordion for RPP plan")
    public void user_can_see_contribution_rules_accordion_for_rpp_plan(String gwt) {
        rppAdditionalInfoPO.initPage(getContext());
        contributionsPO.initPage(getContext());
        rppAdditionalInfoPO.clickNoforspouse();
        rppAdditionalInfoPO.clickNoforconnectedperson();
        planSelectionPO.clickContinueButton();
        contributionsPO.validateClickforAccordionDropdown();
        contributionsPO.validateContributionAccordionContent();

    }


    @Step("{0} user can see contribution page for NRSP plan")
    public void user_can_see_contribution_page_for_nrsp_plan(String gwt) {
        nrspAdditionalInfoPO.initPage(getContext());
        contributionsPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        planSelectionPO.clickContinueButton();
        contributionsPO.validateContributionAccount();

    }
    @Step("{0} user can see contribution rules in accordion for NRSP plan")
    public void user_can_see_contribution_rules_accordion_for_nrsp_plan(String gwt) {
        nrspAdditionalInfoPO.initPage(getContext());
        contributionsPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        planSelectionPO.clickContinueButton();
        contributionsPO.validateClickforAccordionDropdown();
        contributionsPO.validateContributionAccordionContent();

    }


    @Step("{0} user can see contribution page for RRSP,DPSP or TFSA plan")
    public void user_can_see_contribution_page_for_other_plans(String gwt) {
        contributionsPO.initPage(getContext());
        contributionsPO.validateContributionAccount();
    }

    @Step("{0} user can see contribution rules in accordion for RRSP,DPSP or TFSA plan")
    public void user_can_see_contribution_rules_accordion_for_other_plans(String gwt) {
        contributionsPO.initPage(getContext());
        contributionsPO.validateClickforAccordionDropdown();
        contributionsPO.validateContributionAccordionContent();

    }

    @Step("{0} user can see Contribution Plan Headers and sub Headers")
    public void user_can_see_contribution_progress_bar_and_subheaders(String gwt) {
        planSelectionPO.validatePlanProgressBarInfo();
        planSelectionPO.validatePlanProgressBarStep();
        planSelectionPO.validatePlanssubHeader();
    }

    @Step("{0} user can see Additional Info Page for RPP when they click back from Contributions Page")
    public void user_can_see_additional_info_page_for_rpp_when_click_back(String gwt) {
        planSelectionPO.clickBackButton();
        rppAdditionalInfoPO.clickYesforspouse();
        rppAdditionalInfoPO.clickNoforspouse();

    }

    @Step("{0} user can see Additional Info Page for NRSP when they click back from Contributions Page")
    public void user_can_see_additional_info_page_for_nrsp_when_click_back(String gwt) {
        planSelectionPO.clickBackButton();
        nrspAdditionalInfoPO.clickYesforUSCitizen();
        nrspAdditionalInfoPO.clickNoforUSCitizen();

    }

    @Step("{0} user can see Plan Selection Page for RRSP,DPSP or TFSA when they click back from Contributions Page")
    public void user_can_see_additional_info_page_for_other_plans_when_click_back(String gwt) {
        planSelectionPO.clickBackButton();
        planSelectionPO.selectRequiredPlan();
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can see Contribution Heading and Label on the Accounts")
    public void user_can_see_contribution_heading_and_label(String gwt) {
        nrspAdditionalInfoPO.initPage(getContext());
        contributionsPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        planSelectionPO.clickContinueButton();
        contributionsPO.validateContributionHeadingDollarPercentage();
        contributionsPO.validateContributionLabel();

    }

    @Step("{0} user can see hint text for Accounts with available inputs")
    public void user_can_see_hint_text_for_account_with_input(String gwt) {
        planSelectionPO.validateHinttextLabels();
    }

    @Step("{0} user can see error on the accounts when click on continue without any entering amount")
    public void user_can_see_error_on_accounts_with_no_values_and_click_continue(String gwt) {
        planSelectionPO.clickContinueButton();
        //contributionsPO.validateErrorPercentageEmployer();
        contributionsPO.validateContributionErrorMember();
    }

    @Step("{0} user can only enter valid values in the range provided for the accounts")
    public void user_can_only_enter_values_in_the_provided_range(String gwt) {
        contributionsPO.clickEmployerPercentageEnterInput();
        contributionsPO.clickEmployerDollarEnterInput();
        contributionsPO.enterMemberValidInput();
    }

    @Step("{0} user can see error on the accounts when click on continue if we enter any invalid amount")
    public void user_can_see_error_on_accounts_with_invalid_amounts(String gwt) {
        contributionsPO.enterMemberInvalidInput();
        contributionsPO.validateContributionErrorMember();
    }

    @Step("{0} user can see Contribution details for Account with no input available")
    public void user_can_see_contribution_details_for_account_with_no_input(String gwt) {
        contributionsPO.validatePlanNoContributionsText();

    }

    @Step("{0} user clicks continue and clicks back , then the account input details are retained")
    public void user_can_see_account_input_details_retained(String gwt) {
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickBackButton();
        contributionsPO.validateContributionAmountRetained();
    }


}
