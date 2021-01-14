package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.InvestmentPO;
import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.canadalife.automation.grsoe.pageobjects.PlanSelectionPO;
import com.canadalife.automation.grsoe.pageobjects.RPPAdditionalInfoPO;
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
        investmentPO.validateInvestmentCardHeader();
        investmentPO.validateInvestmentCardSelected();

    }

    @Step("{0} user validates investment Fund Fees and Fund Name")
    public void user_validates_investment_fund_fess_and_fund_name(String gwt){
        investmentPO.initPage(getContext());
       investmentPO.validateInvestmentFundName();
       investmentPO.validateFundFeeLines();

    }
}
