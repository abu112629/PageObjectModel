package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.PlanDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.Given;
import static com.canadalife.automation.grsoe.support.GivenWhenThen.Then;

public class CanadaLifeHeaderFooterTest extends TestNGBase {
    @Features("Sprint7")
    @Stories("Member sees header and footer")
    @Parameters("data-set")
    @Issue("GRSOE-106")
    @Test

    public void ValidateHeaderFooterLinks(@Optional("data/plan_data_set_fr.xml")String dataSet){

        PlanDO plan=new PlanDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        Then(plan :: user_can_view_the_canada_life_logo_and_footer_links);

    }
}
