package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class FundInformationTDFTest extends TestNGBase {

    @Features("Sprint8")
    @Stories("Member sees fund information about TDF in investment selection")
    @Parameters("data-set")
    @Issue("GRSOE-261")
    @Test
    public void validateFundInformationTDF(@Optional("data/investment_data_set_fr_RPP.xml") String dataSet){

        InvestmentDO investment= new InvestmentDO(getContext()).fromResource(dataSet);
        Given(investment :: user_on_plan_selection_page);
        When(investment :: user_can_select_required_plan);
        Then(investment :: user_clicks_continue_and_selects_no_for_both_questions);
        And(investment ::  user_validates_investment_fund_fees_and_fund_name);
    }
}
