package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.ContingentBeneficiariesDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class DuplicateContingentBeneficiariesTest extends TestNGBase {

    @Features("Sprint15")
    @Stories("Members should have added validation for contingent beneficiaries")
    @Parameters({"data-set","data-set2","data-set3","data-set4","data-set5","data-set6"})
    @Issue("GRSOE-987")
    @Test

    public void ValidateDuplicateContingentBeneficiaries(@Optional("data/beneficiaries_skip_data_set_fr.xml") String dataSet,
                                                @Optional("data/beneficiaries_organisation_data_set_fr.xml")String dataSet2,
                                                @Optional("data/contingent_beneficiaries_data_set_fr.xml") String dataSet3,
                                                @Optional("data/contingent_beneficiaries_organisation_data_set_fr.xml") String dataSet4,
                                                @Optional("data/beneficiaries_estate_data_set_fr.xml")String dataSet5,
                                                @Optional("data/contingent_beneficiaries_estate_data_set_fr.xml") String dataSet6) {

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_on_plan_selection_page);
        When(beneficiariesDO :: user_can_select_required_plan);
        Then(beneficiariesDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO :: user_clicks_continue_button);
        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO :: delete_all_salesforce_test_records);
        And(beneficiariesDO :: user_enters_person_beneficiary_details);
        And(beneficiariesDO :: user_selects_and_validates_primary_trustee);
        And(beneficiariesDO :: user_clicks_save_beneficiary);

        BeneficiariesDO beneficiariesDO2=new BeneficiariesDO(getContext()).fromResource(dataSet2);
        And(beneficiariesDO2 :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO2 :: user_selects_organization_beneficiary);
        And(beneficiariesDO2 :: user_enters_and_clicks_save_beneficiary_for_organization);

        ContingentBeneficiariesDO contingentbeneficiariesDO=new ContingentBeneficiariesDO(getContext()).fromResource(dataSet3);
        And(contingentbeneficiariesDO :: user_validates_contingent_beneficiary_header_and_description);
        And(contingentbeneficiariesDO :: user_clicks_add_contingent_beneficiary);
        And(contingentbeneficiariesDO :: user_enters_person_beneficiary_details);
        And(contingentbeneficiariesDO :: user_selects_and_validates_primary_trustee);
        And(contingentbeneficiariesDO :: user_clicks_save_beneficiary);

        And(contingentbeneficiariesDO :: user_clicks_add_additional_contingent_beneficiary);
        And(contingentbeneficiariesDO :: user_enters_duplicate_person_beneficiary_details);
        And(contingentbeneficiariesDO :: user_clicks_save_and_is_able_to_validate_all_duplicate_bene_errors);
        And(beneficiariesDO :: user_clicks_cancel_button);

        And(contingentbeneficiariesDO :: user_clicks_add_additional_contingent_beneficiary);
        And(contingentbeneficiariesDO :: user_enters_duplicate_person_beneficiary_details_like_primary);
        And(contingentbeneficiariesDO :: user_clicks_save_and_is_able_to_validate_all_duplicate_primary_contingent_errors);
        And(beneficiariesDO :: user_clicks_cancel_button);

        ContingentBeneficiariesDO contingentbeneficiariesDO2=new ContingentBeneficiariesDO(getContext()).fromResource(dataSet4);
        And(contingentbeneficiariesDO2 :: user_clicks_add_contingent_beneficiary);
        And(contingentbeneficiariesDO2 :: user_selects_and_validates_organization_beneficiary);
        And(contingentbeneficiariesDO2 :: user_enters_and_clicks_save_beneficiary_for_organization);

        And(contingentbeneficiariesDO2 :: user_clicks_add_additional_contingent_beneficiary);
        And(contingentbeneficiariesDO2 :: user_enters_duplicate_organization_beneficiary_details);
        And(contingentbeneficiariesDO2 :: user_clicks_save_and_is_able_to_validate_all_duplicate_bene_errors);
        And(beneficiariesDO :: user_clicks_cancel_button);

        And(contingentbeneficiariesDO2 :: user_clicks_add_additional_contingent_beneficiary);
        And(contingentbeneficiariesDO2 :: user_enters_duplicate_organization_beneficiary_details_like_primary);
        And(contingentbeneficiariesDO2 :: user_clicks_save_and_is_able_to_validate_all_duplicate_primary_contingent_errors);
        And(beneficiariesDO :: user_clicks_cancel_button);

        BeneficiariesDO beneficiariesDO3=new BeneficiariesDO(getContext()).fromResource(dataSet5);
        And(beneficiariesDO3 :: user_clicks_add_additional_primary_beneficiary);
        And(beneficiariesDO3 :: user_selects_estate_beneficiary);
        And(beneficiariesDO3 :: user_enters_and_clicks_save_beneficiary_for_estate);

        ContingentBeneficiariesDO contingentbeneficiariesDO3=new ContingentBeneficiariesDO(getContext()).fromResource(dataSet6);
        And(contingentbeneficiariesDO3 :: user_clicks_add_contingent_beneficiary);
        And(contingentbeneficiariesDO3 :: user_enters_duplicate_estate_beneficiary_details);
        And(contingentbeneficiariesDO3 :: user_clicks_save_and_is_able_to_validate_all_duplicate_primary_contingent_errors);
        And(beneficiariesDO :: user_clicks_cancel_button);
        And(beneficiariesDO3 :: user_deletes_beneficiary_estate_information);

        And(contingentbeneficiariesDO3 :: user_clicks_add_contingent_beneficiary);
        And(contingentbeneficiariesDO3 :: user_selects_and_validates_estate_beneficiary);
        And(contingentbeneficiariesDO3 :: user_enters_and_clicks_save_beneficiary_for_estate);

        And(contingentbeneficiariesDO3 :: user_clicks_add_additional_contingent_beneficiary);
        And(contingentbeneficiariesDO3 :: user_enters_duplicate_estate_beneficiary_details);
        And(contingentbeneficiariesDO3 :: user_clicks_save_and_is_able_to_validate_all_duplicate_bene_errors);

    }

}