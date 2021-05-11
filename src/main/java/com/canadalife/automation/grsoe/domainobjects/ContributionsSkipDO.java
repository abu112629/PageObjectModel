package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class ContributionsSkipDO extends DomainObjectModel {

    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;
    private ContributionsPO contributionsPO;
    private InvestmentPO investmentPO;

    private ContributionsSkipDO() {}
    public ContributionsSkipDO(TestContext context){
        this.context = context;
    }

    @Step("{0} Member on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.update_locale();
        loginPO.update_asset();
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");

        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.initPage(getContext());
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("");
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

    @Step("{0} user enters no value or enters zero in the contributions account percentage input")
    public void user_enters_no_value_or_enters_zero_in_the_contributions_account_input(String gwt) {
        contributionsPO.initPage(getContext());
        contributionsPO.enterMemberVoluntaryValidInput();
        contributionsPO.enterMemberValidInput();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks continue and is able to navigate to the contributions skip section")
    public void user_clicks_continue_and_is_able_to_navigate_to_the_contributions_skip_section(String gwt) {
        planSelectionPO.clickContinueButton();
        contributionsPO.validateContributionSkipQuestionandDetails();
        contributionsPO.validateContributionSkipDescription();
        planSelectionPO.clickSkipContinueButton();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user reaches the investment section and is able to navigate back to the contributions section directly")
    public void user_reaches_the_investment_section_and_is_able_to_navigate_back_to_the_contributions_section_directly(String gwt) {
       investmentPO.initPage(getContext());
       investmentPO.validateInvestmentCardSelected();
        TestNGBase.takeScreenshot("");
       planSelectionPO.clickBackButton();
    }

    @Step("{0} user reaches the contribution section and enters zero dollar input for voluntary account")
    public void user_reaches_the_contribution_section_and_enters_zero_dollar_input_for_voluntary_account(String gwt) {
        contributionsPO.clickMemberVoluntaryDollarEnterInput();
        TestNGBase.takeScreenshot("");
        contributionsPO.enterMemberValidInput();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user reaches the contribution section")
    public void user_reaches_the_contribution_section(String gwt) {
        planSelectionPO.validatePlanssubHeader();
    }

    @Step("{0} user enters no value for voluntary percentage and enters valid input in the mandatory account")
    public void user_enters_no_value_for_voluntary_percentage_and_enters_valid_input_in_the_mandatory_account(String gwt) {
        contributionsPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        contributionsPO.clickEmployerPercentageEnterInput();
        TestNGBase.takeScreenshot("");
        contributionsPO.enterMemberValidInput();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user enters no value for voluntary dollar and enters valid input in the mandatory account")
    public void user_enters_no_value_for_voluntary_dollar_and_enters_valid_input_in_the_mandatory_account(String gwt) {
        contributionsPO.clickEmployerDollarEnterInput();
        contributionsPO.enterMemberValidInput();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
    }



}
