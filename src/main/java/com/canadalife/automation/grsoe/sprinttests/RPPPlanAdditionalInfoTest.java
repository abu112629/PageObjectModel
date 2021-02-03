package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.RPPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class RPPPlanAdditionalInfoTest extends TestNGBase {

    @Features("Sprint3")
    @Stories("Member answers RPP specific questions")
    @Parameters("data-set")
    @Issue("GRSOE-71")
    @Test
    public void ValidateRPPPlanAdditionalInfo(@Optional("data/plan_rpp_additional_info_en.xml")String dataSet) {

        RPPPlanDO plan = new RPPPlanDO(getContext()).fromResource(dataSet);

        Given(plan ::user_on_plan_selection_page);
        When(plan ::user_can_select_required_plan);
        Then(plan ::user_can_see_plan_headers_and_subheaders);
        And(plan :: user_can_see_plan_questions_in_additional_info);
        And(plan ::user_can_see_error_messages_on_no_questions_answered);
        And(plan ::user_answers_both_questions_and_enters_spouse_details);
        And(plan ::user_can_see_error_message_for_future_dob);

    }


}
