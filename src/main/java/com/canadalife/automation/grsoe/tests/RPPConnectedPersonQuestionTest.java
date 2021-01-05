package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.RPPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class RPPConnectedPersonQuestionTest extends TestNGBase {

    @Features("Sprint8")
    @Stories("Connected Person wording change for RPP additional question")
    @Parameters("data-set")
    @Issue("GRSOE-358")
    @Test

    public void ValidateRPPConnectedPersonQuestion(@Optional("data/plan_rpp_additional_info_fr.xml")String dataSet) {

        RPPPlanDO plan = new RPPPlanDO(getContext()).fromResource(dataSet);

        Given(plan ::user_on_plan_selection_page);
        When(plan ::user_can_select_required_plan);
        Then(plan ::user_can_see_the_updated_connected_person_additional_info_question);

    }
}
