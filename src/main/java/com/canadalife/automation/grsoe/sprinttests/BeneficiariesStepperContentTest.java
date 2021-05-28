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

public class BeneficiariesStepperContentTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member sees Beneficiary stepper content and Primary definition")
    @Parameters("data-set")
    @Issue("GRSOE-717")
    @Test

    public void ValidateBeneficiariesStepperContent(@Optional("data/beneficiaries_successor_data_set_fr.xml")String dataSet) {

        BeneficiariesSuccessorDO beneficiariesDO=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_is_on_plan_selection_page);
        When(beneficiariesDO :: user_is_able_select_required_plan);
        Then(beneficiariesDO :: user_validates_beneficiary_step_description_and_primary_description);


    }
}
