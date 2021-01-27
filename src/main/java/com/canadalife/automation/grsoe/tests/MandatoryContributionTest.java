package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.ContributionsSkipDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class MandatoryContributionTest extends TestNGBase {

    @Features("Sprint9")
    @Stories("Member leaves voluntary contribution blank")
    @Parameters("data-set")
    @Issue("GRSOE-202")
    @Test

    public void ValidateContributionSkipSection(@Optional("data/contributions_mandatory_voluntary_skip_data_set_en.xml")String dataSet){
        ContributionsSkipDO plan=new ContributionsSkipDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_clicks_continue_and_selects_no_for_both_questions);
        And(plan :: user_enters_no_value_for_voluntary_percentage_and_enters_valid_input_in_the_mandatory_account);
        And(plan :: user_reaches_the_investment_section_and_is_able_to_navigate_back_to_the_contributions_section_directly);
        And(plan :: user_enters_no_value_for_voluntary_dollar_and_enters_valid_input_in_the_mandatory_account);
        And(plan :: user_reaches_the_investment_section_and_is_able_to_navigate_back_to_the_contributions_section_directly);
        And(plan :: user_reaches_the_contribution_section);


    }
}
