package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.PlanDO;
import com.canadalife.automation.grsoe.domainobjects.ProfileInformationDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class PlanSwitchTest extends TestNGBase {

    @Features("Sprint13")
    @Stories("Member changes plan selection and is warned that inputs will be lost")
    @Parameters("data-set")
    @Issue("GRSOE-649")
    @Test

    public void ValidatePlanSwitch(@Optional("data/plan_change_data_set_fr.xml")String dataSet) {

        PlanDO planDO=new PlanDO(getContext()).fromResource(dataSet);
        Given(planDO :: user_on_plan_selection_page);
        When(planDO :: user_select_required_plan);
        Then(planDO :: user_clicks_continue_button);
        Then(planDO :: user_enters_information_for_rpp_plan);
        And(planDO :: user_clicks_back_button);
        And(planDO :: user_select_new_plan);
        And(planDO :: user_clicks_continue_button);
        And(planDO :: user_selects_different_plan_and_is_able_to_see_warning_message);
        And(planDO :: user_selects_no_go_back_and_previous_plan_selection_retained);
        And(planDO :: user_select_new_plan);
        And(planDO :: user_clicks_continue_button);
        And(planDO :: user_clicks_skip_continue_button);
        And(planDO :: user_enters_information_for_nrsp_plan);
    }
}
