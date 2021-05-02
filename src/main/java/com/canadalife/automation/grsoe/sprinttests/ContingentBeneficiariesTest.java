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

public class ContingentBeneficiariesTest extends TestNGBase {

    @Features("Sprint15")
    @Stories("Member can add contingent beneficiaries as a person/organization/estate")
    @Parameters({"data-set","data-set2"})
    @Issue("GRSOE-417")
    @Test

    public void ValidateContingentBeneficiaries(@Optional("data/beneficiaries_skip_data_set_en.xml") String dataSet,
                                                @Optional("data/contingent_beneficiaries_data_set_en.xml") String dataSet2) {

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

        ContingentBeneficiariesDO contingentbeneficiariesDO=new ContingentBeneficiariesDO(getContext()).fromResource(dataSet2);
        And(contingentbeneficiariesDO :: user_validates_contingent_beneficiary_header_and_description);
        And(contingentbeneficiariesDO :: user_clicks_add_contingent_beneficiary);
        And(contingentbeneficiariesDO :: delete_all_salesforce_test_records);
        And(contingentbeneficiariesDO :: user_clicks_continue_and_is_able_to_validate_all_errors);
        And(contingentbeneficiariesDO :: user_selects_and_validates_person_beneficiary);
        And(contingentbeneficiariesDO :: user_enters_invalid_person_beneficiary);
        And(contingentbeneficiariesDO :: user_enters_person_beneficiary_details);
        And(contingentbeneficiariesDO :: user_clicks_continue_and_is_able_to_validate_no_selection_trustee_error);
        And(contingentbeneficiariesDO :: user_selects_and_validates_primary_trustee);
        And(contingentbeneficiariesDO :: user_is_able_to_validate_all_trustee_form_labels);
        And(contingentbeneficiariesDO :: user_selects_yes_and_is_able_to_validate_all_trustee_errors_when_empty);
        And(contingentbeneficiariesDO :: user_enters_invalid_trustee_details);
        And(contingentbeneficiariesDO :: user_enters_duplicate_trustee_and_beneficiary_details);
        And(contingentbeneficiariesDO :: user_enters_trustee_details_and_clicks_save);
        And(contingentbeneficiariesDO :: user_validates_pill_information_after_saving_the_details_for_trustee);
        And(contingentbeneficiariesDO :: user_validates_salesforce_information_is_saved_for_trustee);
        And(contingentbeneficiariesDO ::user_validates_pill_information_after_saving_the_details);
        And(contingentbeneficiariesDO ::user_validates_salesforce_information_is_saved_for_member);
        And(contingentbeneficiariesDO :: user_validates_pill_information_after_saving_the_details);


    }

}