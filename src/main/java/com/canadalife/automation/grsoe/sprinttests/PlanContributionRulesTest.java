package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.ContributionsDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class PlanContributionRulesTest extends TestNGBase {

    @Features("Sprint6")
    @Stories("Member can view contributions rules and details")
    @Issue("GRSOE-95")
    //@Parameters({"data-set","data-set2","data-set3","data-set4","data-set5"})
    @Parameters("data-set")
    @Test
    public void ValidatePlanContributionRulesRPP(@Optional("data/plan_data_set_contributions_en_rpp.xml") String dataSet) {

        ContributionsDO plan = new ContributionsDO(getContext()).fromResource(dataSet);
        Given(plan::user_on_plan_selection_page);
        When(plan::user_can_select_required_plan);
        Then(plan::user_can_see_contribution_rules_accordion_for_rpp_plan);

    }

    @Features("Sprint6")
    @Stories("Member can view contributions rules and details")
    @Issue("GRSOE-95")
    @Parameters("data-set2")
    @Test(dependsOnMethods = "ValidatePlanContributionRulesRPP", alwaysRun = true)
    public void ValidatePlanContributionRulesNRSP(@Optional("data/plan_data_set_contributions_en_nrsp.xml") String dataSet2) {


        ContributionsDO plan = new ContributionsDO(getContext()).fromResource(dataSet2);
        Given(plan::user_on_plan_selection_page);
        When(plan::user_can_select_required_plan);
        Then(plan::user_can_see_contribution_rules_accordion_for_nrsp_plan);
    }
/*
    @Features("Sprint6")
    @Stories("Member can view contributions rules and details")
    @Issue("GRSOE-95")
    @Parameters("data-set3")
    @Test(dependsOnMethods = "ValidatePlanContributionRules2", alwaysRun = true)
    public void ValidatePlanContributionRules3(@Optional("data/plan_data_set_contributions_en_rrsp.xml") String dataSet3) {


        ContributionsDO plan = new ContributionsDO(getContext()).fromResource(dataSet3);
        Given(plan::user_on_plan_selection_page);
        When(plan::user_can_select_required_plan);
        Then(plan::user_can_see_contribution_rules_accordion_for_other_plans);

    }*/

    @Features("Sprint6")
    @Stories("Member can view contributions rules and details")
    @Issue("GRSOE-95")
    @Parameters("data-set4")
    @Test(dependsOnMethods = "ValidatePlanContributionRulesNRSP", alwaysRun = true)
    public void ValidatePlanContributionRulesDPSP(@Optional("data/plan_data_set_contributions_en_dpsp.xml") String dataSet4) {


        ContributionsDO plan = new ContributionsDO(getContext()).fromResource(dataSet4);
        Given(plan::user_on_plan_selection_page);
        When(plan::user_can_select_required_plan);
        Then(plan::user_can_see_contribution_rules_accordion_for_dpsp_plan);
    }

    @Features("Sprint6")
    @Stories("Member can view contributions rules and details")
    @Issue("GRSOE-95")
    @Parameters("data-set5")
    @Test(dependsOnMethods = "ValidatePlanContributionRulesDPSP", alwaysRun = true)
    public void ValidatePlanContributionRulesTFSA(@Optional("data/plan_data_set_contributions_en_dpsp.xml") String dataSet5) {


        ContributionsDO plan = new ContributionsDO(getContext()).fromResource(dataSet5);
        Given(plan::user_on_plan_selection_page);
        When(plan::user_can_select_required_plan);
        Then(plan::user_can_see_contribution_rules_accordion_for_other_plans);
    }
}