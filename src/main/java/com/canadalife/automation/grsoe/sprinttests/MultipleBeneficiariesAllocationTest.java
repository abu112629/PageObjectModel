package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class MultipleBeneficiariesAllocationTest extends TestNGBase {

    @Features("Sprint14")
    @Stories("Members beneficiary allocation must equal 100%")
    @Parameters({"data-set","data-set2","data-set3"})
    @Issue("GRSOE-586")
    @Test

    public void ValidateMultipleBeneficiariesAllocation(@Optional("data/beneficiaries_skip_data_set_fr.xml")String dataSet,
                                                      @Optional("data/beneficiaries_organisation_data_set_fr.xml")String dataSet2,
                                                      @Optional("data/beneficiaries_estate_data_set_fr.xml")String dataSet3) {

        BeneficiariesDO beneficiariesDO = new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO::user_on_plan_selection_page);
        When(beneficiariesDO::user_can_select_required_plan);
        Then(beneficiariesDO::user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO::user_clicks_continue_button);
        And(beneficiariesDO::user_clicks_add_primary_beneficiary);
        And(beneficiariesDO::user_enters_person_beneficiary_details);
        And(beneficiariesDO::user_selects_and_validates_primary_trustee);
        And(beneficiariesDO::user_clicks_save_beneficiary);
        And(beneficiariesDO::user_clicks_continue_button);
        And(beneficiariesDO::user_clicks_continue_and_is_able_to_validate_all_allocation_errors);
        And(beneficiariesDO::user_clicks_back_button);
        And(beneficiariesDO::user_clicks_continue_button);

        BeneficiariesDO beneficiariesDO2 = new BeneficiariesDO(getContext()).fromResource(dataSet2);
        And(beneficiariesDO2::user_clicks_add_primary_beneficiary);
        And(beneficiariesDO2::user_selects_organization_beneficiary);
        And(beneficiariesDO2::user_enters_and_clicks_save_beneficiary_for_organization);
        And(beneficiariesDO2::user_clicks_continue_button);
        And(beneficiariesDO::user_clicks_continue_and_is_able_to_validate_all_additional_allocation_errors);


        BeneficiariesDO beneficiariesDO3 = new BeneficiariesDO(getContext()).fromResource(dataSet3);
        And(beneficiariesDO3::user_clicks_add_additional_primary_beneficiary);
        And(beneficiariesDO3::user_selects_estate_beneficiary);
        And(beneficiariesDO3::user_enters_and_clicks_save_beneficiary_for_estate);
        And(beneficiariesDO3::user_is_able_to_continue_with_allocation_as_100);
        And(beneficiariesDO3::user_clicks_continue_button);
    }
}
