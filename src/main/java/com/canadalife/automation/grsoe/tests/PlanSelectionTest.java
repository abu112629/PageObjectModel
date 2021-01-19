package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.PlanDO;
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

public class PlanSelectionTest extends TestNGBase {

    @Features("Sprint2")
    @Stories("Member is presented with the plans they are eligible for")
    @Parameters("data-set")
    @Issue("GRSOE-68")
    @Test

    /*The below validations are also a part of User Story 396 in Sprint 8*/
    public void validatePlansContent(@Optional("data/plan_data_set_fr.xml") String dataSet) {
        PlanDO plan = new PlanDO(getContext()).fromResource(dataSet);

        Given(plan::user_on_plan_selection_page);
        When(plan::user_presented_with_all_available_plans_and_with_specific_description);
        Then(plan ::user_can_select_each_plan);
        //Add Order Set of the Plan

    }
}
