package com.canadalife.automation.grsoe.sprinttests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

public class SuccessorSinChangeTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member changes successor SIN")
    @Parameters("data-set")
    @Issue("GRSOE-805")
    @Test

    public void ValidateSuccessorSinChange(@Optional("data/beneficiaries_trustee_data_set_en.xml")String dataSet) {

    }
}
