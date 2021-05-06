package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.ReviewAndSubmitDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class ReviewAndSubmitTest extends TestNGBase {

    @Features("Sprint16")
    @Stories("Member can see personal info for review")
    @Parameters("data-set")
    @Issue("GRSOE-839")
    @Test

    public void ValidateReviewAndSubmitInformation(@Optional("data/review_and_submit_information_data_set_fr.xml")String dataSet) {

        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_profile_progress_bar_info_and_step_details);
        And(reviewAndSubmitDO :: user_can_view_the_profile_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_back_and_reach_add_beneficiaries_page);
        And(reviewAndSubmitDO :: user_clicks_submit_button);
    }
}
