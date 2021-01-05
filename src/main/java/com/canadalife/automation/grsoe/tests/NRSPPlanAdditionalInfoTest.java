package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.NRSPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class NRSPPlanAdditionalInfoTest extends TestNGBase {

    @Features("Sprint4")
    @Stories("Member answers NRSP/EPSP specific questions")
    @Parameters("data-set")
    @Issue("GRSOE-115")
    @Test

    public void ValidateNRSPPlanAdditionalInfo(@Optional("data/plan_epsp_additional_info_fr.xml")String dataSet){

        NRSPPlanDO plan = new NRSPPlanDO(getContext()).fromResource(dataSet);
        Given(plan ::user_on_plan_selection_page);
        When(plan ::user_can_select_required_plan);
        Then(plan ::user_can_see_plan_headers_and_subheaders);
        And(plan ::user_can_see_two_facta_with_yes_or_no);
        And(plan ::user_can_see_inline_error_messages_for_no_selection);
        And(plan:: user_can_see_error_messages_for_no_us_tin_entered);
        And(plan :: user_enters_us_tin);
        And(plan:: user_can_see_error_messages_for_no_country_selection);
        And(plan ::user_can_select_country_from_dropdown);
        And(plan :: user_can_see_hint_text_labels);
        And(plan :: user_can_see_error_messages_for_no_additional_tin_selection);
        And(plan ::user_can_see_additional_tin_question);
        And(plan :: user_can_see_error_message_for_no_additional_tin_provided);
        And(plan :: user_enters_additional_tin_for_other_country);
        And(plan :: user_can_see_additional_reasons);
        And(plan::user_selects_radio_button_for_additional_reasons);
        And(plan :: user_can_see_error_when_no_details_provided_in_reason);

    }
}
