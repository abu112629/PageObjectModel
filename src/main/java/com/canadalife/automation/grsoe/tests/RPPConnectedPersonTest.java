package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.RPPPlanDO;
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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class RPPConnectedPersonTest extends TestNGBase {

    @Features("Sprint4")
    @Stories("Member who is connected person answers question for RPP")
    @Parameters("data-set")
    @Issue("GRSOE-219")
    @Test

    public void connectedPersonStepsValidation(@Optional("data/plan_rpp_additional_info_fr.xml") String dataSet){
        RPPPlanDO plan = new RPPPlanDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_instructions_for_connected_person_in_additional_info);
        And (plan :: user_cannot_see_instructions_for_connected_person_in_additional_info);

    }
}
