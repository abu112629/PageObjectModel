package com.canadalife.automation.grsoe.tests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class BeneficiariesSkipTest extends TestNGBase {

    @Features("Sprint8")
    @Stories("Members navigates to beneficiaries section and is able to skip")
    @Parameters("data-set")
    @Issue("GRSOE-103")
    @Test

    public void ValidateBeneficiariesSkipSection(@Optional("data/beneficiaries_skip_data_set_en.xml")String dataSet){

        BeneficiariesDO beneficiariesDO=new BeneficiariesDO(getContext()).fromResource(dataSet);
        Given(beneficiariesDO :: user_on_plan_selection_page);
        When(beneficiariesDO :: user_can_select_required_plan);
        Then(beneficiariesDO :: user_clicks_continue_and_selects_no_for_both_questions);
        And(beneficiariesDO :: user_validates_beneficiaries_section);
        And(beneficiariesDO :: user_validates_beneficiaries_skip_section);
        And(beneficiariesDO :: user_clicks_back_and_reach_beneficiaries_skip_section);
        And(beneficiariesDO :: user_clicks_back_and_reach_add_beneficiaries_page_and_back_to_investments);



    }
}
