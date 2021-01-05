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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.Then;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.When;

public class PlanRetentionTest extends TestNGBase {
    @Features("Sprint2")
    @Stories("Member can continue or go back on the plan selection page")
    @Parameters("data-set")
    @Issue("GRSOE-114")
    @Test
    public void validateSelectablePlansRetention(@Optional("data/plan_data_set_fr.xml") String dataSet) {
        PlanDO plan = new PlanDO(getContext()).fromResource(dataSet);

        Given(plan::user_on_plan_selection_page);
        When(plan::selected_plan_is_retained_when_user_clicks_back_button);
    }
}
