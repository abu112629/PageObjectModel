package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class ShowFundInformationTDFAgeTest extends TestNGBase {

    @Features("Sprint11")
    @Stories("Member can select a custom retirement year for Target Date Fund")
    @Parameters("data-set")
    @Issue("GRSOE-268")
    @Test
    public void validateShowFundInformationTDFAge(@Optional("data/investment_data_set_fr_RPP.xml") String dataSet){

        InvestmentDO investment= new InvestmentDO(getContext()).fromResource(dataSet);
        Given(investment :: user_on_plan_selection_page);
        When(investment :: user_can_select_required_plan);
        Then(investment :: user_clicks_continue_and_selects_no_for_both_questions);
        And(investment :: user_validates_investment_age_input_error_when_invalid_age_entered);
        And(investment :: user_validates_investment_age_input_and_clicks_show_funds_button);
        And(investment :: user_validates_updated_investment_fund_fees_and_fund_name);
        And(investment :: user_validates_updated_age_input_and_investment_fund_details_when_clicks_back);
    }
}
