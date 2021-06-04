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

public class DPSPReviewPageTest extends TestNGBase {

    @Features("Sprint18")
    @Stories("Member can see additional question for review - DPSP")
    @Parameters("data-set")
    @Issue("GRSOE-1303")
    @Test

    public void ValidateDPSPReviewPage(@Optional("data/review_and_submit_information_data_set_dpsp_fr.xml")String dataSet) {

        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_clicks_no_for_connected_person_for_dpsp_plan);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_dpsp_plan_additional_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_submit_button);

    }
}
