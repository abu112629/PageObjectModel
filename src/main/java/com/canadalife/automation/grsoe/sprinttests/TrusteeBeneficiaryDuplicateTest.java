package com.canadalife.automation.grsoe.sprinttests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

public class TrusteeBeneficiaryDuplicateTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member can't add a Trustee that is the same person as the beneficiary")
    @Parameters("data-set")
    @Issue("GRSOE-994")
    @Test

    public void ValidateTrusteeBeneficiaryDuplicate(@Optional("data/beneficiaries_trustee_data_set_en.xml")String dataSet) {

    }
}
