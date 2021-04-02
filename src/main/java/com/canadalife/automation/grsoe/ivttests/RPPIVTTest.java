package com.canadalife.automation.grsoe.ivttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import com.canadalife.automation.grsoe.domainobjects.RPPPlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class RPPIVTTest extends TestNGBase {
    @Features("RPPIVTTest")
    @Stories("Members able to select RPP Plan and navigate through all the pages")
    @Parameters({"data-set","data-set2","data-set3","data-set4"})
    @Test

    public void ValidateRPPIVT(@Optional("data/plan_rpp_salesforce_save_fr.xml")String dataSet,
                                @Optional("data/investment_skip_data_set_fr.xml")String dataSet2,
                                @Optional("data/beneficiaries_skip_data_set_fr.xml")String dataSet3,
                               @Optional("data/beneficiaries_organisation_data_set_fr.xml")String dataSet4){

        RPPPlanDO plan=new RPPPlanDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_can_select_required_plan);
        Then(plan ::user_can_see_plan_questions_in_additional_info);
        And(plan :: user_can_see_error_messages_on_no_questions_answered);
        And(plan :: user_answers_both_questions_and_enters_spouse_details);
        And(plan :: user_enters_dob);
        And(plan ::user_is_able_to_see_salesforce_records_updated);
        And(plan::user_clicks_back_and_selects_no_for_spouse);
        And(plan :: user_is_able_to_see_salesforce_records_deleted);

        InvestmentDO investmentDO=new InvestmentDO(getContext()).fromResource(dataSet2);
        And(investmentDO:: user_validates_investment_skip_details_and_questionnaire);
        And(investmentDO ::user_reaches_beneficiaries_section_when_clicks_skip_continue_from_investment_skip_page);

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet3);
        And(beneficiariesDO :: user_validates_beneficiaries_skip_section);
        And(beneficiariesDO :: user_clicks_back_and_reach_add_beneficiaries_page_and_back_to_investments);
        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);

        BeneficiariesDO beneficiariesDO2=new BeneficiariesDO(getContext()).fromResource(dataSet4);
        And(beneficiariesDO2 :: user_selects_and_validates_organization_beneficiary);
        And(beneficiariesDO2 :: delete_all_salesforce_organization_test_records);
        And(beneficiariesDO2 :: user_clicks_save_beneficiary_for_organization);
        And(beneficiariesDO2 :: user_validates_pill_information_for_organization_after_saving_the_details);
        And(beneficiariesDO2 :: user_validates_salesforce_information_is_saved_for_organization);


        }
}
