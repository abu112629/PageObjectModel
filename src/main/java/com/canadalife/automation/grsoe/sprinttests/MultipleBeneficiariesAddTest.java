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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class MultipleBeneficiariesAddTest extends TestNGBase {

    @Features("Sprint14")
    @Stories("Member has already added a Primary beneficiary and wants to additional beneficiaries")
    @Parameters("data-set")
    @Issue("GRSOE-480")
    @Test

    public void ValidateMultipleBeneficiariesAddition(@Optional("data/beneficiaries_skip_data_set_en.xml")String dataSet) {

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

        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO :: user_enters_duplicate_person_beneficiary_details);
        And(beneficiariesDO :: user_clicks_save_and_is_able_to_validate_all_duplicate_bene_errors);





    }
}
