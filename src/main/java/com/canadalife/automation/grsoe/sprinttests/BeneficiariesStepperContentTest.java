package com.canadalife.automation.grsoe.sprinttests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

public class BeneficiariesStepperContentTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member sees Beneficiary stepper content and Primary definition")
    @Parameters("data-set")
    @Issue("GRSOE-717")
    @Test

    public void ValidateBeneficiariesStepperContent(@Optional("data/beneficiaries_trustee_data_set_en.xml")String dataSet) {

    }
}
