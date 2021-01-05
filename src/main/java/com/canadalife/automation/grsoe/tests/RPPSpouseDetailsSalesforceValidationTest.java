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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class RPPSpouseDetailsSalesforceValidationTest extends TestNGBase {

    @Features("Sprint5")
    @Stories("Member changes answer to spousal question from RPP plan selection")
    @Parameters("data-set")
    @Issue("GRSOE-243")
    @Test

    public void ValidateRPPSpouseSavedInfo(@Optional("data/plan_rpp_salesforce_save_en.xml")String dataSet) {

        RPPPlanDO plan = new RPPPlanDO(getContext()).fromResource(dataSet);

        Given(plan ::user_on_plan_selection_page);
        When(plan ::user_can_select_required_plan);
        Then(plan ::user_can_see_plan_questions_in_additional_info);
        And(plan ::user_answers_both_questions_and_enters_spouse_details);
        And(plan ::user_enters_dob);
        And(plan ::user_is_able_to_see_salesforce_records_updated);
        And(plan::user_clicks_back_and_selects_no_for_spouse);
        And(plan :: user_is_able_to_see_salesforce_records_deleted);



    }
}
