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

public class BeneficiariesPersonAddTest extends TestNGBase {

    @Features("Sprint10")
    @Stories("Member can add a person as a Primary beneficiary")
    @Parameters("data-set")
    @Issue("GRSOE-65")
    @Test

    public void ValidateBeneficiariesPersonAddition(@Optional("data/beneficiaries_skip_data_set_en.xml")String dataSet) {

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_on_plan_selection_page);
        When(beneficiariesDO :: user_can_select_required_plan);
        Then(beneficiariesDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO :: delete_all_salesforce_test_records);
        And(beneficiariesDO :: user_selects_and_validates_person_beneficiary);
        And(beneficiariesDO :: user_clicks_continue_and_is_able_to_validate_all_errors);
        And(beneficiariesDO :: user_enters_invalid_person_beneficiary);
        And(beneficiariesDO :: user_enters_person_beneficiary_details);
        And(beneficiariesDO :: user_selects_and_validates_primary_trustee);
        And(beneficiariesDO :: user_clicks_save_beneficiary);
        And(beneficiariesDO ::user_validates_pill_information_after_saving_the_details);
        And(beneficiariesDO ::user_validates_salesforce_information_is_saved_for_member);




    }
}
