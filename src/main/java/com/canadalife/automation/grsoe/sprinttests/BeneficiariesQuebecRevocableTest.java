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

public class BeneficiariesQuebecRevocableTest extends TestNGBase {

    @Features("Sprint11")
    @Stories("Members who live in Quebec are given the option to make their primary Beneficiary revocable")
    @Parameters("data-set")
    @Issue("GRSOE-420")
    @Test

    public void ValidateBeneficiariesQuebecRevocable(@Optional("data/beneficiaries_quebec_data_set_fr.xml")String dataSet) {

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_on_plan_selection_page);
        When(beneficiariesDO :: user_can_select_required_plan);
        Then(beneficiariesDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO :: user_clicks_continue_button);
        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO :: user_enters_person_beneficiary_details);
        And(beneficiariesDO :: user_selects_and_validates_primary_trustee);
        And(beneficiariesDO :: user_validates_quebec_question_and_checks_revocable_option);
        And(beneficiariesDO :: user_clicks_save_beneficiary);
        And(beneficiariesDO :: user_validates_salesforce_information_is_true_for_revocable);

    }
}
