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

public class SuccessorSINTest extends TestNGBase {

    @Features("Sprint16")
    @Stories("TFSA Successor Holder SIN# validation and can't be the same as the member SIN#")
    @Parameters("data-set")
    @Issue("GRSOE-593")
    @Test

    public void ValidateSuccessorSIN(@Optional("data/beneficiaries_successor_data_set_fr.xml")String dataSet){

        BeneficiariesSuccessorDO beneficiariesDO=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_is_on_plan_selection_page);
        When(beneficiariesDO :: user_is_able_select_required_plan);
        Then(beneficiariesDO :: user_clicks_add_successor_beneficiary);
        And(beneficiariesDO :: user_enters_successor_beneficiary_name_and_dob);
        And(beneficiariesDO :: user_enters_invalid_successor_beneficiary_sin);
        And(beneficiariesDO :: user_enters_valid_successor_beneficiary_sin);
        And(beneficiariesDO :: user_clicks_save_beneficiary);


    }
}
