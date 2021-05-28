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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class DeleteOnlyPrimaryRemovesContingentTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member deletes only primary which deletes contingents")
    @Parameters({"data-set","data-set2","data-set3"})
    @Issue("GRSOE-655")
    @Test

    public void ValidateDeleteOnlyPrimaryRemovesContingent(@Optional("data/beneficiaries_delete_data_set_fr.xml")String dataSet,
                                                           @Optional("data/beneficiaries_organisation_data_set_fr.xml")String dataSet2,
                                                           @Optional("data/contingent_beneficiaries_data_set_fr.xml")String dataSet3) {
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

        BeneficiariesDO beneficiariesOrgDO = new BeneficiariesDO(getContext()).fromResource(dataSet2);
        And(beneficiariesOrgDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesOrgDO :: user_selects_organization_beneficiary);
        And(beneficiariesOrgDO :: user_enters_and_clicks_save_beneficiary_for_organization);

        ContingentBeneficiariesDO contingentbeneficiariesDO=new ContingentBeneficiariesDO(getContext()).fromResource(dataSet3);
        And(contingentbeneficiariesDO :: user_clicks_add_contingent_beneficiary);
        And(contingentbeneficiariesDO :: delete_all_salesforce_test_records);
        And(contingentbeneficiariesDO :: user_enters_person_beneficiary_details);
        And(contingentbeneficiariesDO :: user_selects_and_validates_primary_trustee);
        And(contingentbeneficiariesDO :: user_is_able_to_validate_all_trustee_form_labels);
        And(contingentbeneficiariesDO :: user_selects_yes_and_is_able_to_validate_all_trustee_errors_when_empty);
        And(contingentbeneficiariesDO :: user_enters_trustee_details_and_clicks_save);
        And(contingentbeneficiariesDO :: user_validates_pill_information_after_saving_the_details_for_trustee);
        And(contingentbeneficiariesDO :: user_validates_salesforce_information_is_saved_for_member);
        And(contingentbeneficiariesDO :: user_validates_pill_information_after_saving_the_details);

        And(beneficiariesDO :: user_clicks_delete_beneficiary_information_and_clicks_back);
        And(beneficiariesDO :: user_validates_pill_information_after_saving_the_details);
        And(beneficiariesDO :: user_deletes_beneficiary_person_information);
        And(beneficiariesDO :: user_validates_salesforce_information_is_deleted_for_member);

        And(beneficiariesDO :: user_clicks_delete_only_beneficiary_information_and_clicks_back);
        And(beneficiariesOrgDO :: user_validates_pill_information_for_organization_after_saving_the_details);
        And(beneficiariesDO :: user_deletes_only_beneficiary_information);
        And(beneficiariesOrgDO :: user_validates_salesforce_information_is_deleted_for_organization);

        And(contingentbeneficiariesDO :: user_validates_salesforce_information_is_deleted_for_member);


    }
}
