package com.canadalife.automation.grsoe.ivttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.ContributionsSkipDO;
import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class RRSPIVTTest extends TestNGBase {
    @Features("RRSPIVTTest")
    @Stories("Members able to select RRSP Plan and navigate through all the pages")
    @Parameters({"data-set","data-set2","data-set3"})
    @Test

    public void ValidateRRSPIVT(@Optional("data/contributions_all_voluntary_skip_data_set_en.xml")String dataSet,
                               @Optional("data/investment_skip_data_set_en.xml")String dataSet2,
                               @Optional("data/beneficiaries_skip_data_set_en.xml")String dataSet3){

        ContributionsSkipDO plan=new ContributionsSkipDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan :: user_enters_no_value_or_enters_zero_in_the_contributions_account_input);
        And(plan :: user_clicks_continue_and_is_able_to_navigate_to_the_contributions_skip_section);
        And(plan :: user_reaches_the_investment_section_and_is_able_to_navigate_back_to_the_contributions_section_directly);
        And(plan :: user_reaches_the_contribution_section_and_enters_zero_dollar_input_for_voluntary_account);
        And(plan :: user_clicks_continue_and_is_able_to_navigate_to_the_contributions_skip_section);


        InvestmentDO investmentDO=new InvestmentDO(getContext()).fromResource(dataSet2);
        And(investmentDO:: user_validates_investment_skip_details_and_questionnaire);
        And(investmentDO ::user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page);

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet3);
        And(beneficiariesDO :: user_validates_beneficiaries_section);
        And(beneficiariesDO :: user_validates_beneficiaries_skip_section);
        And(beneficiariesDO ::user_clicks_back_and_reach_add_beneficiaries_page_and_back_to_investments);
    }
}
