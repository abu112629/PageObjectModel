package com.canadalife.automation.grsoe.sprinttests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

public class DeleteOnlyPrimaryRemovesContingentTest extends TestNGBase {

    @Features("Sprint17")
    @Stories("Member deletes only primary which deletes contingents")
    @Parameters("data-set")
    @Issue("GRSOE-655")
    @Test

    public void ValidateDeleteOnlyPrimaryRemovesContingent(@Optional("data/beneficiaries_trustee_data_set_en.xml")String dataSet) {

    }
}
