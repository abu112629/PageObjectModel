package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class BeneficiariesSuccessorDO extends DomainObjectModel {

    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private BeneficiariesPO beneficiariesPO;
    private RPPAdditionalInfoPO rppAdditionalInfoPO;
    private BeneficiarySuccessorPO beneficiarySuccessorPO;

    private BeneficiariesSuccessorDO() {}
    public BeneficiariesSuccessorDO(TestContext context){
        this.context = context;
    }

    @Step("{0} Member is on plan selection page")
    public void user_is_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("Plan Selection Page");
    }

    @Step("{0} Member is able select required Plan")
    public void user_is_able_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("Select Plan");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks add Successor Beneficiary")
    public void user_clicks_add_successor_beneficiary(String gwt){
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickSkipContinueButton();
        planSelectionPO.clickContinueButton();

        beneficiarySuccessorPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        beneficiarySuccessorPO.validateBeneficiariesSuccessorDescription();
        beneficiarySuccessorPO.addSuccessorBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks continue and is able to validate all errors")
    public void user_clicks_continue_and_is_able_to_validate_all_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiarySuccessorPO.validateErrors();
    }

    @Step("{0} user selects and validates successor beneficiary details")
    public void user_selects_and_validates_successor_beneficiary(String gwt){
        beneficiarySuccessorPO.validateSuccessorBeneficiaryFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user enters invalid successor beneficiary details")
    public void user_enters_invalid_successor_beneficiary(String gwt){
        TestNGBase.takeScreenshot("");
        beneficiarySuccessorPO.validateInvalidSuccessorBeneficiaryDetails();

    }

    @Step("{0} user enters incomplete DOB for Successor")
    public void user_enters_incomplete_DOB(String gwt){
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.enterIncompleteDOBDetails();
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiarySuccessorPO.validateIncompleteDOBDetails();
    }

    @Step("{0} user enters invalid DOB for Successor")
    public void user_enters_invalid_DOB(String gwt){
        rppAdditionalInfoPO.enterInvalidDOBDetails();
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiarySuccessorPO.validateInvalidDOBDetails();
    }

    @Step("{0} user enters successor beneficiary details")
    public void user_enters_successor_beneficiary_details(String gwt){
        beneficiarySuccessorPO.validateAndEnterDetailsSuccessorBeneficiary();
        TestNGBase.takeScreenshot("");
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.enterDOBDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user clicks on Save Beneficiary Form")
    public void user_clicks_save_beneficiary(String gwt){
        AppHelper.waitForXHR(2);
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user validates Pill information after saving the details")
    public void user_validates_pill_information_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        beneficiarySuccessorPO.validateSuccessorPillInformation();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Salesforce Information is saved for member")
    public void user_validates_salesforce_information_is_saved_for_member(String gwt){
        AppHelper.waitForXHR(1);
        beneficiarySuccessorPO.validateSalesforceBeneficiarySuccessorRecord();
    }

    @Step("{0} user edits Beneficiary Successor Information and updates SIN Number")
    public void user_edits_beneficiary_successor_information(String gwt){
        AppHelper.waitForXHR(1);
        beneficiarySuccessorPO.editPrimarySuccessorBeneficiary();
        beneficiarySuccessorPO.validatePrimarySuccessorBeneficiaryOnEdit();
        beneficiarySuccessorPO.enterSINSuccessorBeneficiary();
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} Delete all salesforce Test records")
    public void delete_all_salesforce_test_records(String gwt){
        AppHelper.waitForXHR(1);
        beneficiarySuccessorPO.deleteAllTestRecords();
    }

    @Step("{0} user validates Salesforce Information is deleted for Successor")
    public void user_validates_salesforce_information_is_deleted_for_successor(String gwt){
        AppHelper.waitForXHR(3);
        beneficiarySuccessorPO.validateSalesforceBeneficiaryRecordDeleted();
    }

    @Step("{0} user clicks delete Beneficiary Information and clicks back")
    public void user_clicks_delete_beneficiary_information_and_clicks_back(String gwt){
        AppHelper.waitForXHR(1);
        beneficiarySuccessorPO.deletePrimarySuccessorBeneficiary();
        beneficiarySuccessorPO.validateBeneficiariesDeleteQuestion();
        planSelectionPO.clickSkipBackButton();
    }
    @Step("{0} user deletes Beneficiary Person Information")
    public void user_deletes_beneficiary_person_information(String gwt){
        AppHelper.waitForXHR(1);
        beneficiarySuccessorPO.deletePrimarySuccessorBeneficiary();
        beneficiarySuccessorPO.validateBeneficiariesDeleteQuestion();
        planSelectionPO.clickSkipContinueButton();
    }
}
