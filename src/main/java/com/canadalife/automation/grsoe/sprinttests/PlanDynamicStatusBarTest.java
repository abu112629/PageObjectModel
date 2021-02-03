package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.PlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class PlanDynamicStatusBarTest extends TestNGBase {
    @Features("Sprint4")
    @Stories("Member can see a progress bar to know where they are in the enrolment process")
    @Parameters("data-set")
    @Issue("GRSOE-53")
    @Test
    /*The below validations are also a part of User Story 396 in Sprint 8*/
    public void validateDynamicStatusPlanBar(@Optional("data/plan_data_set_fr.xml") String dataSet1){
        PlanDO plan = new PlanDO(getContext()).fromResource(dataSet1);
        Given(plan::user_on_plan_selection_page);
        Then(plan::user_can_view_the_plan_progress_bar_info_and_step_details);
    }

    @Features("Sprint4")
    @Stories("Member can see a progress bar to know where they are in the enrolment process")
    @Parameters("data-set2")
    @Issue("GRSOE-53")
    @Test(dependsOnMethods = "validateDynamicStatusPlanBar", alwaysRun = true)

    public void validateDynamicStatusPlanBarRPPNRSP(@Optional("data/plan_data_set_fr_RPP.xml") String dataSet2){

        PlanDO plan =new PlanDO(getContext()).fromResource(dataSet2);
        Given(plan::user_on_plan_selection_page);
        When(plan :: user_select_required_plan);
        Then(plan :: user_clicks_continue_button);
        And(plan :: user_can_view_the_plan_progress_bar_info_and_step_details);



    }
}
