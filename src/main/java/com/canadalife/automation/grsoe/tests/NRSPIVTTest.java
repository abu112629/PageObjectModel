package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.ContributionsSkipDO;
import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import com.canadalife.automation.grsoe.domainobjects.NRSPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class NRSPIVTTest extends TestNGBase {

    @Features("NRSPIVTTest")
    @Stories("Members able to select NRSP Plan and navigate through all the pages")
    @Parameters({"data-set","data-set2","data-set3","data-set4"})
    @Test

    public void ValidateNRSPIVT(@Optional("data/plan_nrsp_additional_info_en.xml")String dataSet,
                                @Optional("data/contributions_mandatory_voluntary_skip_data_set_en.xml")String dataSet2,
                                @Optional("data/investment_skip_data_set_en.xml")String dataSet3,
                                @Optional("data/beneficiaries_skip_data_set_en.xml")String dataSet4){
        NRSPPlanDO plan = new NRSPPlanDO(getContext()).fromResource(dataSet);
        Given(plan ::user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_can_see_error_messages_for_no_us_tin_entered);
        And(plan :: user_enters_us_tin);
        And(plan:: user_can_see_error_messages_for_no_country_selection);
        And(plan ::user_can_select_country_from_dropdown);
        And(plan ::user_can_see_additional_tin_question);
        And(plan :: user_enters_additional_tin_for_other_country);
        And(plan :: user_can_see_additional_reasons);
        And(plan::user_selects_radio_button_for_additional_reasons);
        And(plan :: user_can_see_error_when_no_details_provided_in_reason);

        ContributionsSkipDO contributionsSkipDO=new ContributionsSkipDO(getContext()).fromResource(dataSet2);
        And(contributionsSkipDO :: user_enters_no_value_for_voluntary_percentage_and_enters_valid_input_in_the_mandatory_account);
        And(contributionsSkipDO :: user_reaches_the_investment_section_and_is_able_to_navigate_back_to_the_contributions_section_directly);
        And(contributionsSkipDO :: user_enters_no_value_for_voluntary_dollar_and_enters_valid_input_in_the_mandatory_account);

        InvestmentDO investmentDO=new InvestmentDO(getContext()).fromResource(dataSet3);
        And(investmentDO:: user_validates_investment_skip_details_and_questionnaire);
        And(investmentDO ::user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page);

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet4);
        And(beneficiariesDO :: user_validates_beneficiaries_section);
        And(beneficiariesDO :: user_validates_beneficiaries_skip_section);
        And(beneficiariesDO ::user_clicks_back_and_reach_add_beneficiaries_page_and_back_to_investments);
    }
}
