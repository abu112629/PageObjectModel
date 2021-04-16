package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.MemberLandingDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class MemberLandingPageTest extends TestNGBase {

    @Features("Sprint14")
    @Stories("Member views GRSOE Intro page after registration")
    @Parameters("data-set")
    @Issue("GRSOE-477")
    @Test

    public void ValidateMemberLandingPage(@Optional("data/member_landing_data_set_fr.xml")String dataSet){
        MemberLandingDO plan=new MemberLandingDO(getContext()).fromResource(dataSet);
        Given(plan :: user_on_plan_selection_page);
        When(plan :: user_on_member_landing_page);
        Then(plan :: validate_member_landing_page_information);
    }
}
