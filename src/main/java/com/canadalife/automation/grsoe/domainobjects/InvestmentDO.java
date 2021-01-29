package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;

@XStreamAlias("plan-domain-object")
public class InvestmentDO extends DomainObjectModel {
    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private RPPAdditionalInfoPO rppAdditionalInfoPO;
    private InvestmentPO investmentPO;
    private BeneficiariesPO beneficiariesPO;

    private InvestmentDO(){}
    public InvestmentDO(TestContext context){this.context = context;}

    @Step("{0} Member on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");

        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} Member can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks continue and selects no for both questions")
    public void user_clicks_continue_and_selects_no_for_both_questions(String gwt){
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.clickNoforspouse();
        rppAdditionalInfoPO.clickNoforconnectedperson();
        planSelectionPO.clickContinueButton();

    }

    @Step("{0} user validates investment description and target date based funds")
    public void user_validates_investment_description_and_target_date_based_funds(String gwt){
        investmentPO.initPage(getContext());
        investmentPO.validateInvestmentDescription();
        investmentPO.validateInputFieldQuestion();
        investmentPO.validateInputFieldTip();
        investmentPO.validateAgeInput();
        investmentPO.enterAge();
        investmentPO.validateInvestmentCardHeader();
        investmentPO.validateInvestmentCardSelected();

    }

    @Step("{0} user validates investment Fund Fees and Fund Name")
    public void user_validates_investment_fund_fees_and_fund_name(String gwt){
        investmentPO.initPage(getContext());
        investmentPO.validateInvestmentFundName();
        investmentPO.validateFundFeeLines();

    }

    @Step("{0} user reaches investment page when clicks back from investment Skip Page")
    public void user_reaches_investment_page_when_clicks_back_from_investment_skip_page(String gwt){
        planSelectionPO.clickSkipBackButton();
        investmentPO.validateInvestmentCardSelected();

    }

    @Step("{0} user clicks Skip button and validates investment Skip Details and Questionnaire")
    public void user_validates_investment_skip_details_and_questionnaire(String gwt){
       planSelectionPO.clickSkipStepButton();
       investmentPO.initPage(getContext());
       investmentPO.validateInvestmentSkipQuestionandDetails();

    }

    @Step("{0} user reaches beneficiaries section when clicks skip continue from Investment skip Page")
    public void user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page(String gwt){
       planSelectionPO.clickSkipContinueButton();
       beneficiariesPO.initPage(getContext());
       beneficiariesPO.validateBeneficiariesDescription();

    }
}
