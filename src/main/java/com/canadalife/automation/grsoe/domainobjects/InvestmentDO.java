package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

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

        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} Member can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks continue and selects no for both questions")
    public void user_clicks_continue_and_selects_no_for_both_questions(String gwt){
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.clickNoforspouse();
        rppAdditionalInfoPO.clickNoforconnectedperson();
        TestNGBase.takeScreenshot("");
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
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user validates investment age input error when invalid age entered")
    public void user_validates_investment_age_input_error_when_invalid_age_entered(String gwt){
        investmentPO.initPage(getContext());
        investmentPO.enterInvalidAge();
        planSelectionPO.clickContinueButton();
        investmentPO.validateAgeInputError();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user validates investment age input and clicks show funds button")
    public void user_validates_investment_age_input_and_clicks_show_funds_button(String gwt){
        investmentPO.initPage(getContext());
        investmentPO.enterAge();
        investmentPO.clickShowFundsButton();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user validates investment Fund Fees and Fund Name")
    public void user_validates_investment_fund_fees_and_fund_name(String gwt){
        investmentPO.initPage(getContext());
        investmentPO.validateInvestmentFundName();
        investmentPO.validateFundFeeLines();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user validates updated investment Fund Fees and Fund Name")
    public void user_validates_updated_investment_fund_fees_and_fund_name(String gwt){
        planSelectionPO.initPage(getContext());
        investmentPO.validateInvestmentFundNameUpdated();
        investmentPO.validateInvestmentCardHeaderUpdated();
        investmentPO.validateUpdatedFundFeeLines();
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user validates updated age input and investment Fund details when clicks back")
    public void user_validates_updated_age_input_and_investment_fund_details_when_clicks_back(String gwt){
        planSelectionPO.clickBackButton();
        investmentPO.validateUpdatedAgeInput();
        investmentPO.validateInvestmentFundNameUpdated();
        investmentPO.validateInvestmentCardHeaderUpdated();
        investmentPO.validateUpdatedFundFeeLines();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user reaches investment Page when clicks back from investment Skip Page")
    public void user_reaches_investment_page_when_clicks_back_from_investment_skip_page(String gwt){
        planSelectionPO.clickSkipBackButton();
        investmentPO.validateInvestmentCardSelected();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user clicks Skip Button and validates investment Skip Details and Questionnaire")
    public void user_validates_investment_skip_details_and_questionnaire(String gwt){
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSkipStepButton();
        investmentPO.initPage(getContext());
        investmentPO.validateTheInvestmentSkipQuestionandDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user reaches Beneficiaries section when clicks skip continue from Investment skip Page")
    public void user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page(String gwt){
       planSelectionPO.clickSkipContinueButton();
       beneficiariesPO.initPage(getContext());
       beneficiariesPO.validateBeneficiariesDescription();
       TestNGBase.takeScreenshot("");
       planSelectionPO.clickContinueButton();

    }

    @Step("{0} user validates investment Accordion content")
    public void user_validates_investment_accordion_content(String gwt){
        investmentPO.initPage(getContext());
        investmentPO.validateTheInvestmentAccordionDetails();
        TestNGBase.takeScreenshot("");

    }
}
