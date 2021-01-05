package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.ContributionsDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class PlanContributionRulesTest extends TestNGBase {

    @Features("Sprint6")
    @Stories("Member can view contributions rules and details")
    @Parameters({"data-set","data-set2","data-set3","data-set4","data-set5"})
    @Issue("GRSOE-95")
    @Test
    public void ValidatePlanContributionRules(@Optional("data/plan_data_set_contributions_fr_rpp.xml")String dataSet,
                                              @Optional("data/plan_data_set_contributions_fr_nrsp.xml") String dataSet2,
                                              @Optional("data/plan_data_set_contributions_fr_rrsp.xml") String dataSet3,
                                              @Optional("data/plan_data_set_contributions_fr_dpsp.xml") String dataSet4,
                                              @Optional("data/plan_data_set_contributions_fr_dpsp.xml") String dataSet5){

        ContributionsDO plan=new ContributionsDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_contribution_rules_accordion_for_rpp_plan);
        closeDriver();

        plan=new ContributionsDO(getContext()).fromResource(dataSet2);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_contribution_rules_accordion_for_nrsp_plan);
        closeDriver();

        plan=new ContributionsDO(getContext()).fromResource(dataSet3);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_contribution_rules_accordion_for_other_plans);
        closeDriver();

        plan=new ContributionsDO(getContext()).fromResource(dataSet4);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_contribution_rules_accordion_for_other_plans);
        closeDriver();

        plan=new ContributionsDO(getContext()).fromResource(dataSet5);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_contribution_rules_accordion_for_other_plans);

    }
}
