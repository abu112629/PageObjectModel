package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
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

        InvestmentDO plan=new InvestmentDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_clicks_continue_and_selects_no_for_both_questions);
        And(plan :: user_validates_investment_skip_details_and_questionnaire);
        And(plan :: user_reaches_investment_page_when_clicks_back_from_investment_skip_page);
        And(plan :: user_validates_investment_skip_details_and_questionnaire);
        And(plan :: user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page);

    }
}
