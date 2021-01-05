package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.ContributionsDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;


public class PlanContributionsPayrollInputTest extends TestNGBase {
    @Features("Sprint7")
    @Stories("Member is able to select and edit payroll contribution amount")
    @Parameters("data-set")
    @Issue("GRSOE-74")
    @Test

    public void ValidatePlanContributionPayrollInput(@Optional("data/plan_data_set_edit_contributions_fr.xml")String dataSet){
        ContributionsDO plan=new ContributionsDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_contribution_heading_and_label);
        And(plan :: user_can_see_hint_text_for_account_with_input);
        And(plan :: user_can_see_error_on_accounts_with_no_values_and_click_continue);
        And(plan :: user_can_see_error_on_accounts_with_invalid_amounts);
        And(plan :: user_can_only_enter_values_in_the_provided_range);
        And(plan :: user_can_see_contribution_details_for_account_with_no_input);
        And(plan :: user_can_see_account_input_details_retained);

    }
}
