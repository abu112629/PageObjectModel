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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class PlanSelectionReviewPageTest extends TestNGBase {

    @Features("Sprint18")
    @Stories("Member can see plan selection")
    @Parameters("data-set")
    @Issue("GRSOE-87")
    @Test

    public void ValidatePlanSelectionNRSPReviewPage(@Optional("data/review_and_submit_information_data_set_en.xml")String dataSet) {

        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_plan_profile_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_submit_button);

    }

    @Features("Sprint18")
    @Stories("Member can see plan selection")
    @Parameters("data-set2")
    @Issue("GRSOE-87")
    @Test(dependsOnMethods = "ValidatePlanSelectionNRSPReviewPage", alwaysRun = true)
    public void ValidatePlanSelectionRPPReviewPage(@Optional("data/review_and_submit_information_data_set_rpp_en.xml")String dataSet2) {
        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet2);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_clicks_continue_and_selects_no_for_both_questions_in_rpp);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_plan_profile_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_submit_button);
    }

    @Features("Sprint18")
    @Stories("Member can see plan selection")
    @Parameters("data-set3")
    @Issue("GRSOE-87")
    @Test(dependsOnMethods = "ValidatePlanSelectionRPPReviewPage", alwaysRun = true)

    public void ValidatePlanSelectionTFSAReviewPage(@Optional("data/review_and_submit_information_data_set_tfsa_en.xml")String dataSet3) {

        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet3);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_selects_tfsa_plan_and_clicks_continue);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_plan_profile_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_submit_button);
    }

    @Features("Sprint18")
    @Stories("Member can see plan selection")
    @Parameters("data-set4")
    @Issue("GRSOE-87")
    @Test(dependsOnMethods = "ValidatePlanSelectionTFSAReviewPage", alwaysRun = true)

    public void ValidatePlanSelectionDPSPReviewPage(@Optional("data/review_and_submit_information_data_set_dpsp_en.xml")String dataSet4) {
        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet4);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_clicks_no_for_connected_person_for_dpsp_plan);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_plan_profile_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_submit_button);
    }

    @Features("Sprint18")
    @Stories("Member can see plan selection")
    @Parameters("data-set5")
    @Issue("GRSOE-87")
    @Test(dependsOnMethods = "ValidatePlanSelectionDPSPReviewPage", alwaysRun = true)

    public void ValidatePlanSelectionRRSPReviewPage(@Optional("data/review_and_submit_information_data_set_rrsp_en.xml")String dataSet5) {
        ReviewAndSubmitDO reviewAndSubmitDO=new ReviewAndSubmitDO(getContext()).fromResource(dataSet5);
        Given(reviewAndSubmitDO :: user_on_plan_selection_page);
        When(reviewAndSubmitDO :: user_can_select_required_plan);
        Then(reviewAndSubmitDO :: user_clicks_continue_button);
        And(reviewAndSubmitDO :: user_validates_beneficiaries_skip_section);
        And(reviewAndSubmitDO :: user_can_view_the_plan_profile_information_and_details);
        And(reviewAndSubmitDO :: user_clicks_submit_button);
    }
}
