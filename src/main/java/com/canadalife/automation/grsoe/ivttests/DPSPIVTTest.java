package com.canadalife.automation.grsoe.ivttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.DPSPPlanDO;
import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import com.canadalife.automation.grsoe.domainobjects.RPPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class DPSPIVTTest extends TestNGBase {
    @Features("DPSPIVTTest")
    @Stories("Members able to select DPSP Plan and navigate through all the pages")
    @Parameters({"data-set","data-set2"})
    @Test

    public void ValidateDPSPIVT(@Optional("data/plan_dpsp_additional_info_fr.xml")String dataSet,
                                @Optional("data/investment_data_set_fr_RPP.xml")String dataSet2){

        DPSPPlanDO plan = new DPSPPlanDO(getContext()).fromResource(dataSet);
        Given(plan ::user_on_plan_selection_page);
        When(plan ::user_can_select_required_plan);
        Then(plan ::user_can_see_plan_headers_and_subheaders);
        And(plan :: user_can_view_the_plan_progress_bar_info_and_step_details);
        And(plan ::user_can_see_error_messages_on_no_selection_and_click_continue);
        And(plan ::user_selects_yes_for_connected_person_and_is_able_to_validate_disclaimer);
        And(plan ::user_selects_yes_for_connected_person_and_is_not_able_to_continue);
        And(plan ::user_selects_no_for_connected_person_and_is_able_to_continue);

        InvestmentDO investmentDO=new InvestmentDO(getContext()).fromResource(dataSet2);
        And(investmentDO :: user_validates_investment_age_input_and_clicks_show_funds_button);
        And(investmentDO :: user_validates_updated_investment_fund_fees_and_fund_name);

        }
}
