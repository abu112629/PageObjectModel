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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class RPPPlanAdditionalInfoErrorsTest extends TestNGBase {

    @Features("Sprint5")
    @Stories("Member see's errors for plan selection extra questions (RPP)")
    @Parameters("data-set")
    @Issue("GRSOE-189")
    @Test

    public void ValidateRPPPlanAdditionalInfoErrors(@Optional("data/plan_rpp_additional_info_errors_fr.xml")String dataSet){

        RPPPlanDO plan = new RPPPlanDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan:: user_can_see_plan_questions_in_additional_info);
        And(plan:: user_can_see_error_message_for_no_first_last_name_and_connected_person);
        And(plan :: user_enters_dob);
        And(plan:: user_can_see_error_message_for_no_last_name_and_connected_person);
        And(plan ::user_can_see_hint_text_labels);


    }
}
