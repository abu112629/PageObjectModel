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

public class BeneficiariesTrusteeAddTest extends TestNGBase {

    @Features("Sprint11")
    @Stories("Member can add a Trustee for a Primary Beneficiary")
    @Parameters("data-set")
    @Issue("GRSOE-415")
    @Test

    public void ValidateBeneficiariesTrusteeAddition(@Optional("data/beneficiaries_trustee_data_set_en.xml")String dataSet) {

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_on_plan_selection_page);
        When(beneficiariesDO :: user_can_select_required_plan);
        Then(beneficiariesDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO :: user_enters_person_beneficiary_details);
        And(beneficiariesDO :: user_clicks_continue_and_is_able_to_validate_no_selection_trustee_error);
        And(beneficiariesDO :: user_is_able_to_validate_all_trustee_form_labels);
        And(beneficiariesDO :: user_selects_yes_and_is_able_to_validate_all_trustee_errors_when_empty);
        And(beneficiariesDO :: user_enters_invalid_trustee_details);
        And(beneficiariesDO :: user_enters_duplicate_trustee_and_beneficiary_details);
        And(beneficiariesDO :: user_enters_trustee_details_and_clicks_save);
        And(beneficiariesDO :: user_validates_pill_information_after_saving_the_details_for_trustee);
        And(beneficiariesDO :: user_validates_salesforce_information_is_saved_for_trustee);



    }
}
