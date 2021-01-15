package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.Given;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.When;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.Then;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class InvestmentsFundingTest extends TestNGBase {
    @Features("Sprint7")
    @Stories("Member is presented the Target Date Fund based on normal retirement age")
    @Parameters("data-set")
    @Issue("GRSOE-80")
    @Test

    public void ValidateInvestmentFunding(@Optional("data/investment_data_set_en_RPP.xml")String dataSet){

        InvestmentDO investment= new InvestmentDO(getContext()).fromResource(dataSet);
        Given(investment :: user_on_plan_selection_page);
        When(investment :: user_can_select_required_plan);
        Then(investment :: user_clicks_continue_and_selects_no_for_both_questions);
        And(investment ::  user_validates_investment_description_and_target_date_based_funds);

    }
}
