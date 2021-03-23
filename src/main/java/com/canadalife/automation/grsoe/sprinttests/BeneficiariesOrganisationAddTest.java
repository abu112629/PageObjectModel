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

public class BeneficiariesOrganisationAddTest extends TestNGBase {

    @Features("Sprint10")
    @Stories("Member can add an Organization as a Primary beneficiary")
    @Parameters("data-set")
    @Issue("GRSOE-414")
    @Test

    public void ValidateBeneficiariesOrganisationAddition(@Optional("data/beneficiaries_organisation_data_set_fr.xml")String dataSet) {

        BeneficiariesDO beneficiariesDO = new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO::user_on_plan_selection_page);
        When(beneficiariesDO::user_can_select_required_plan);
        Then(beneficiariesDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO :: user_clicks_add_primary_beneficiary);
        And(beneficiariesDO :: user_selects_and_validates_organization_beneficiary);
        And(beneficiariesDO :: user_clicks_continue_and_is_able_to_validate_all_organization_errors);
        And(beneficiariesDO :: user_enters_invalid_organization_beneficiary);
        And(beneficiariesDO :: user_clicks_save_beneficiary_for_organization);
        And(beneficiariesDO ::user_validates_pill_information_for_organization_after_saving_the_details);
        And(beneficiariesDO :: user_validates_salesforce_information_is_saved_for_organization);

    }


}
