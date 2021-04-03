package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesSuccessorDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class BeneficiariesSuccessorDeleteTest extends TestNGBase {

    @Features("Sprint13")
    @Stories("Member deletes Successor Holder")
    @Parameters("data-set")
    @Issue("GRSOE-656")
    @Test

    public void ValidateBeneficiariesSuccessorDelete(@Optional("data/beneficiaries_successor_delete_data_set_fr.xml")String dataSet) {

        BeneficiariesSuccessorDO beneficiariesDO=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_is_on_plan_selection_page);
        When(beneficiariesDO :: user_is_able_select_required_plan);
        Then(beneficiariesDO :: user_clicks_add_successor_beneficiary);
        And(beneficiariesDO :: user_selects_and_validates_successor_beneficiary);
        And(beneficiariesDO :: delete_all_salesforce_test_records);
        And(beneficiariesDO :: user_enters_successor_beneficiary_details);
        And(beneficiariesDO :: user_clicks_save_beneficiary);
        And(beneficiariesDO ::user_validates_salesforce_information_is_saved_for_member);
        And(beneficiariesDO :: user_clicks_delete_beneficiary_information_and_clicks_back);
        And(beneficiariesDO ::user_validates_pill_information_after_saving_the_details);
        And(beneficiariesDO :: user_deletes_beneficiary_person_information);
        And(beneficiariesDO :: user_validates_salesforce_information_is_deleted_for_successor);




    }
}
