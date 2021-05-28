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
import static com.canadalife.automation.grsoe.support.GivenWhenThen.And;

public class SuccessorSinChangeTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member changes successor SIN")
    @Parameters("data-set")
    @Issue("GRSOE-805")
    @Test

    public void ValidateSuccessorSinChange(@Optional("data/beneficiaries_successor_data_set_fr.xml")String dataSet) {

        BeneficiariesSuccessorDO beneficiariesDO=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_is_on_plan_selection_page);
        When(beneficiariesDO :: user_is_able_select_required_plan);
        Then(beneficiariesDO :: user_clicks_add_successor_beneficiary);
        And(beneficiariesDO :: user_enters_successor_beneficiary_name_and_dob);
        And(beneficiariesDO :: user_enters_valid_successor_beneficiary_sin);
        And(beneficiariesDO :: user_clicks_save_beneficiary);
        And(beneficiariesDO ::user_validates_pill_information_after_saving_the_details);
        And(beneficiariesDO :: user_edits_beneficiary_successor_information_and_updates_SIN_information);
        And(beneficiariesDO :: user_enters_valid_successor_beneficiary_sin);
        And(beneficiariesDO :: user_clicks_save_beneficiary);
        And(beneficiariesDO ::user_validates_pill_information_after_saving_the_details);
        And(beneficiariesDO ::user_validates_salesforce_information_is_saved_for_member);

    }
}
