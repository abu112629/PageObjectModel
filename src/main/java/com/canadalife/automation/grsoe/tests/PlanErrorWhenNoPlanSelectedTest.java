package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.PlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class PlanErrorWhenNoPlanSelectedTest extends TestNGBase {
    @Features("Sprint4")
    @Stories("Member sees error when trying to continue without selecting a plan")
    @Parameters("data-set")
    @Issue("GRSOE-164")
    @Test
    public void validateErrorWhenNoPlanIsSelected(@Optional("data/plan_data_set_fr.xml") String dataSet) {
        PlanDO plan = new PlanDO(getContext()).fromResource(dataSet);

        Given(plan::user_on_plan_selection_page);
        When(plan::user_clicks_continue_button);
        Then(plan::the_correct_error_message_is_presented_to_user);
        And(plan::user_select_plan_and_error_message_vanishes);
    }
}
