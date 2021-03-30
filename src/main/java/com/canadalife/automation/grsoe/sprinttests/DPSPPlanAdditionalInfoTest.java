package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.DPSPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class DPSPPlanAdditionalInfoTest extends TestNGBase {

    @Features("Sprint12")
    @Stories("Member is asked a DPSP specific question")
    @Parameters("data-set")
    @Issue("GRSOE-125")
    @Test
    public void ValidateRPPPlanAdditionalInfo(@Optional("data/plan_dpsp_additional_info_fr.xml")String dataSet) {

        DPSPPlanDO plan = new DPSPPlanDO(getContext()).fromResource(dataSet);

        Given(plan ::user_on_plan_selection_page);
        When(plan ::user_can_select_required_plan);
        Then(plan ::user_can_see_plan_headers_and_subheaders);
        And(plan :: user_can_view_the_plan_progress_bar_info_and_step_details);
        And(plan ::user_can_see_error_messages_on_no_selection_and_click_continue);
        And(plan ::user_selects_yes_for_connected_person_and_is_able_to_validate_disclaimer);
        And(plan ::user_selects_yes_for_connected_person_and_is_not_able_to_continue);
        And(plan ::user_selects_no_for_connected_person_and_is_not_able_to_continue);

    }


}
