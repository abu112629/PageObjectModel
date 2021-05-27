package com.canadalife.automation.grsoe.sprinttests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

public class IdenticalBeneficiariesErrorTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member sees the right error message on identical beneficiaries")
    @Parameters("data-set")
    @Issue("GRSOE-1059")
    @Test

    public void ValidateIdenticalBeneficiariesError(@Optional("data/beneficiaries_trustee_data_set_en.xml")String dataSet) {

    }
}
