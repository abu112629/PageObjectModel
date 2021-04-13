package com.canadalife.automation.grsoe.sprinttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.ProfileInformationDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class ProfileInformationTest extends TestNGBase {

    @Features("Sprint13")
    @Stories("Member views pre-populated information from mock data")
    @Parameters("data-set")
    @Issue("GRSOE-63")
    @Test

    public void ValidateProfileInformation(@Optional("data/profile_information_data_set_en.xml")String dataSet) {

        ProfileInformationDO profileInformationDO=new ProfileInformationDO(getContext()).fromResource(dataSet);
        Given(profileInformationDO :: user_is_on_profile_information_page);
        When(profileInformationDO :: user_can_view_the_profile_progress_bar_info_and_step_details);
        Then(profileInformationDO :: user_can_view_the_profile_information_and_details);
    }
}
