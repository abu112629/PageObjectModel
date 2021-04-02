package com.canadalife.automation.grsoe.ivttests;

import com.canadalife.automation.grsoe.domainobjects.BeneficiariesDO;
import com.canadalife.automation.grsoe.domainobjects.BeneficiariesSuccessorDO;
import com.canadalife.automation.grsoe.domainobjects.ContributionsSkipDO;
import com.canadalife.automation.grsoe.domainobjects.InvestmentDO;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;

import static com.canadalife.automation.grsoe.support.GivenWhenThen.*;

public class TFSAIVTTest extends TestNGBase {
    @Features("TFSAIVTTest")
    @Stories("Members able to select TFSA Plan and navigate through all the pages")
    @Parameters({"data-set","data-set2"})
    @Test

    public void ValidateTFSAIVT(@Optional("data/beneficiaries_successor_data_set_fr.xml")String dataSet,
                               @Optional("data/beneficiaries_successor_delete_data_set_fr.xml")String dataSet2){

        BeneficiariesSuccessorDO plan=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet);
        Given(plan :: user_is_on_plan_selection_page);
        When(plan :: user_is_able_select_required_plan);
        Then(plan :: user_clicks_add_successor_beneficiary);
        And(plan :: user_selects_and_validates_successor_beneficiary);
        And(plan :: delete_all_salesforce_test_records);
        And(plan :: user_enters_successor_beneficiary_details);
        And(plan :: user_clicks_save_beneficiary);
        And(plan :: user_validates_pill_information_after_saving_the_details);
        And(plan :: user_validates_salesforce_information_is_saved_for_member);
        And(plan :: user_edits_beneficiary_successor_information);
        And(plan ::user_validates_pill_information_after_saving_the_details);
        And(plan ::user_validates_salesforce_information_is_saved_for_member);

        BeneficiariesSuccessorDO bene=new BeneficiariesSuccessorDO(getContext()).fromResource(dataSet2);
        And(bene :: user_clicks_delete_beneficiary_information_and_clicks_back);
        And(bene :: user_validates_pill_information_after_saving_the_details);
        And(bene :: user_deletes_beneficiary_person_information);
        And(bene :: user_validates_salesforce_information_is_deleted_for_successor);
    }
}
