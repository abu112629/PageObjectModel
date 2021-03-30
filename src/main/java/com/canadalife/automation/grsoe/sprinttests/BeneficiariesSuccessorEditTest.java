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

public class BeneficiariesSuccessorEditTest extends TestNGBase {

    @Features("Sprint12")
    @Stories("Member can edit a TFSA Successor Holder")
    @Parameters("data-set")
    @Issue("GRSOE-582")
    @Test

    public void ValidateBeneficiariesSuccessorEdit(@Optional("data/beneficiaries_successor_data_set_fr.xml")String dataSet) {

        BeneficiariesSuccessorDO beneficiariesDO=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_is_on_plan_selection_page);
        When(beneficiariesDO :: user_is_able_select_required_plan);
        Then(beneficiariesDO :: user_clicks_add_successor_beneficiary);
        And(beneficiariesDO :: user_enters_successor_beneficiary_details);
        And(beneficiariesDO :: user_clicks_save_beneficiary);
        And(beneficiariesDO ::user_validates_salesforce_information_is_saved_for_member);
        And(beneficiariesDO :: user_edits_beneficiary_successor_information);
        And(beneficiariesDO ::user_validates_pill_information_after_saving_the_details);
        And(beneficiariesDO ::user_validates_salesforce_information_is_saved_for_member);

    }
}
