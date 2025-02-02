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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class InvestmentSkipTest extends TestNGBase {

    @Features("Sprint9")
    @Stories("Member skips investment section")
    @Parameters("data-set")
    @Issue("GRSOE-269")
    @Test

    public void ValidateInvestmentSkipSection(@Optional("data/investment_skip_data_set_fr.xml")String dataSet){

        InvestmentDO invest=new InvestmentDO(getContext()).fromResource(dataSet);
        Given(invest :: user_on_plan_selection_page);
        When(invest :: user_can_select_required_plan);
        Then(invest :: user_clicks_continue_and_selects_no_for_both_questions);
        And(invest :: user_validates_investment_skip_details_and_questionnaire);
        And(invest :: user_reaches_investment_page_when_clicks_back_from_investment_skip_page);
        And(invest :: user_validates_investment_skip_details_and_questionnaire);
        And(invest :: user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page);

    }
}
