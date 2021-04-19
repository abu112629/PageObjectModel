package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class BeneficiariesDO extends DomainObjectModel {

    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;
    private RPPAdditionalInfoPO rppAdditionalInfoPO;
    private InvestmentPO investmentPO;
    private BeneficiariesPO beneficiariesPO;
    private BeneficiaryEstatePO beneficiaryEstatePO;
    private BeneficiaryOrganisationPO beneficiaryOrganisationPO;
    private BeneficiaryTrusteePO beneficiaryTrusteePO;

    private BeneficiariesDO() {}
    public BeneficiariesDO(TestContext context){
        this.context = context;
    }

    @Step("{0} Member on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        TestNGBase.takeScreenshot("Plan Selection Page");
    }

    @Step("{0} Member can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("Select Plan");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks continue and selects no for both questions")
    public void user_clicks_continue_and_selects_no_for_both_questions(String gwt){
        nrspAdditionalInfoPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();

    }

    @Step("{0} user validates beneficiaries section")
    public void user_validates_beneficiaries_section(String gwt){
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        planSelectionPO.validatePlanProgressBarStep();
        beneficiariesPO.initPage(getContext());
        beneficiariesPO.validateBeneficiariesDescription();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();

    }

    @Step("{0} user validates beneficiaries Skip section and clicks continue")
    public void user_validates_beneficiaries_skip_section(String gwt){
        beneficiariesPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        beneficiariesPO.validateBeneficiariesSkipQuestionandDetails();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSkipContinueButton();

    }

    @Step("{0} user clicks Skip back and reach add beneficiaries page and clicks back to reach investments")
    public void user_clicks_back_and_reach_add_beneficiaries_page_and_back_to_investments(String gwt){
        planSelectionPO.clickBackButton();
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickSkipBackButton();
        beneficiariesPO.validateBeneficiariesDescription();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickBackButton();
        investmentPO.initPage(getContext());
        investmentPO.validateInvestmentCardSelected();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks continue button")
    public void user_clicks_continue_button(String gwt){
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks back button")
    public void user_clicks_back_button(String gwt){
        planSelectionPO.clickBackButton();
    }

    @Step("{0} user clicks cancel button")
    public void user_clicks_cancel_button(String gwt){
        planSelectionPO.clickCancelButton();
    }
    @Step("{0} user clicks add Primary Beneficiary")
    public void user_clicks_add_primary_beneficiary(String gwt){
        beneficiariesPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        beneficiariesPO.addPrimaryBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks add additional Primary Beneficiary")
    public void user_clicks_add_additional_primary_beneficiary(String gwt){
        beneficiariesPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        beneficiariesPO.addMultiplePrimaryBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks continue and is able to validate all errors")
    public void user_clicks_continue_and_is_able_to_validate_all_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateErrors();
    }

    @Step("{0} user selects and validates person beneficiary details")
    public void user_selects_and_validates_person_beneficiary(String gwt){
        beneficiariesPO.addBeneficiary();
        beneficiariesPO.validateBeneficiaryFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user selects and validates estate beneficiary details")
    public void user_selects_and_validates_estate_beneficiary(String gwt){
        beneficiariesPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        beneficiariesPO.addBeneficiary();
        beneficiaryEstatePO.initPage(getContext());
        beneficiaryEstatePO.validateEstateBeneFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user selects and validates organization beneficiary details")
    public void user_selects_and_validates_organization_beneficiary(String gwt){
        beneficiariesPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        beneficiariesPO.addBeneficiary();
        beneficiaryOrganisationPO.initPage(getContext());
        beneficiaryOrganisationPO.validateOrganisationBeneFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user clicks continue and is able to validate all estate errors")
    public void user_clicks_continue_and_is_able_to_validate_all_estate_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiaryEstatePO.validateEstateError();
    }

    @Step("{0} user clicks continue and is able to validate all organization errors")
    public void user_clicks_continue_and_is_able_to_validate_all_organization_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiaryOrganisationPO.validateOrganizationError();
    }

    @Step("{0} user enters invalid person beneficiary details")
    public void user_enters_invalid_person_beneficiary(String gwt){
        beneficiariesPO.selectPersonRelationBeneficiary();
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateInvalidPersonBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters invalid estate beneficiary details")
    public void user_enters_invalid_estate_beneficiary(String gwt){
        beneficiaryEstatePO.validateInvalidEstateBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters invalid organization beneficiary details")
    public void user_enters_invalid_organization_beneficiary(String gwt){
        beneficiaryOrganisationPO.validateInvalidOrganizationBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters person beneficiary details")
    public void user_enters_person_beneficiary_details(String gwt){
        beneficiariesPO.selectPersonRelationBeneficiary();
        beneficiariesPO.validateAndEnterDetailsPrimaryBeneficiary();
        TestNGBase.takeScreenshot("");
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.enterDOBDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters duplicate person beneficiary details")
    public void user_enters_duplicate_person_beneficiary_details(String gwt){
        beneficiariesPO.selectAdditionalPersonRelationBeneficiary();
        beneficiariesPO.validateAndEnterDuplicateDetailsPrimaryBeneficiary();
        TestNGBase.takeScreenshot("");
        beneficiaryTrusteePO.initPage(getContext());
        beneficiaryTrusteePO.selectPrimaryTrusteeNoDuplicate();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects organization beneficiary")
    public void user_selects_organization_beneficiary(String gwt){
        beneficiariesPO.additionalBeneficiary();
        beneficiaryOrganisationPO.initPage(getContext());
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user selects Estate beneficiary")
    public void user_selects_estate_beneficiary(String gwt){
        beneficiariesPO.additionalBeneficiary();
        beneficiaryEstatePO.initPage(getContext());
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user enters duplicate organization beneficiary details")
    public void user_enters_duplicate_organization_beneficiary_details(String gwt){
        beneficiariesPO.additionalBeneficiary();
        TestNGBase.takeScreenshot("");
        beneficiaryOrganisationPO.initPage(getContext());
        beneficiaryOrganisationPO.enterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user enters duplicate estate beneficiary details")
    public void user_enters_duplicate_estate_beneficiary_details(String gwt){
        beneficiariesPO.additionalBeneficiary();
        TestNGBase.takeScreenshot("");
        beneficiaryEstatePO.initPage(getContext());
        beneficiaryEstatePO.enterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
    }
    @Step("{0} user clicks save and is able to validate all duplicate bene errors")
    public void user_clicks_save_and_is_able_to_validate_all_duplicate_bene_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateDuplicateBeneDetailsError();
    }

    @Step("{0} user selects and validates primary Trustee")
    public void user_selects_and_validates_primary_trustee(String gwt){
        beneficiaryTrusteePO.initPage(getContext());
        beneficiaryTrusteePO.validateBeneficaryTrusteeQuestion();
        beneficiaryTrusteePO.selectPrimaryTrusteeNo();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user clicks on Save Beneficiary Form")
    public void user_clicks_save_beneficiary(String gwt){
        AppHelper.waitForXHR(2);
        beneficiariesPO.validateAndEnterPrimaryallocation();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Estate")
    public void user_clicks_save_beneficiary_for_estate(String gwt){
        AppHelper.waitForXHR(2);
        beneficiaryEstatePO.validateAndEnterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }
    @Step("{0} user enters and clicks on Save Beneficiary Form for Estate")
    public void user_enters_and_clicks_save_beneficiary_for_estate(String gwt){
        AppHelper.waitForXHR(2);
        beneficiaryEstatePO.enterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Organization")
    public void user_clicks_save_beneficiary_for_organization(String gwt){
        AppHelper.waitForXHR(2);
        beneficiaryOrganisationPO.validateAndEnterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Organization")
    public void user_enters_and_clicks_save_beneficiary_for_organization(String gwt){
        AppHelper.waitForXHR(2);
        beneficiaryOrganisationPO.enterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user validates Pill information after saving the details")
    public void user_validates_pill_information_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validatePillInformation();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Pill information for Estate after saving the details")
    public void user_validates_pill_information_for_estate_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryEstatePO.validatePillInformationEstate();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Pill information for Organization after saving the details")
    public void user_validates_pill_information_for_organization_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryOrganisationPO.validatePillInformationOrganization();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Salesforce Information is saved for member")
    public void user_validates_salesforce_information_is_saved_for_member(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceBeneficiaryRecord();
    }

    @Step("{0} user validates Salesforce Information is deleted for member")
    public void user_validates_salesforce_information_is_deleted_for_member(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceBeneficiaryRecordDeleted();
    }

    @Step("{0} user validates Salesforce Information is saved for Estate")
    public void user_validates_salesforce_information_is_saved_for_estate(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryEstatePO.validateSalesforceEstateRecord();
    }

    @Step("{0} user validates Salesforce Information is saved for Organization")
    public void user_validates_salesforce_information_is_saved_for_organization(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryOrganisationPO.validateSalesforceOrganizationRecord();
    }

    @Step("{0} user clicks continue and is able to validate no selection Trustee error")
    public void user_clicks_continue_and_is_able_to_validate_no_selection_trustee_error(String gwt){
        planSelectionPO.clickSaveButton();
        beneficiaryTrusteePO.initPage(getContext());
        beneficiaryTrusteePO.validatePrimaryTrusteeError();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects yes for Trustee and is able to validate all Trustee errors when left empty")
    public void user_selects_yes_and_is_able_to_validate_all_trustee_errors_when_empty(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiaryTrusteePO.validatePrimaryTrusteeEmptyErrors();
    }

    @Step("{0} user is able to validate all Trustee form labels")
    public void user_is_able_to_validate_all_trustee_form_labels(String gwt){
        beneficiaryTrusteePO.initPage(getContext());
        beneficiaryTrusteePO.validateBeneficaryTrusteeQuestion();
        beneficiaryTrusteePO.selectPrimaryTrusteeYes();
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiaryTrusteePO.validateTrusteeFormLabels();
    }

    @Step("{0} user enters invalid trustee details")
    public void user_enters_invalid_trustee_details(String gwt){
        beneficiaryTrusteePO.validateInvalidTrusteeDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters duplicate trustee details and beneficiary details")
    public void user_enters_duplicate_trustee_and_beneficiary_details(String gwt){
        beneficiaryTrusteePO.validateDuplicateBeneTrusteeDetails();
        planSelectionPO.clickSaveButton();
        beneficiaryTrusteePO.validateDuplicateBeneTrusteeDetailsError();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters trustee details and clicks save")
    public void user_enters_trustee_details_and_clicks_save(String gwt){
        beneficiaryTrusteePO.validateAndEnterDetailsTrusteeBeneficiary();
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user validates Pill information after saving the details for Trustee")
    public void user_validates_pill_information_after_saving_the_details_for_trustee(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryTrusteePO.validatePillInformationTrustee();
        TestNGBase.takeScreenshot("");
    }
    @Step("{0} user validates Salesforce Information is saved for Trustee")
    public void user_validates_salesforce_information_is_saved_for_trustee(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryTrusteePO.validateSalesforceTrusteeRecord();
    }

    @Step("{0} user validates Quebec Question and Checks Revocable Option")
    public void user_validates_quebec_question_and_checks_revocable_option(String gwt){
        beneficiariesPO.validateQuebecQuestionAndLabels();
        beneficiariesPO.validateRevocableCheckBox();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user validates Salesforce Information is true for Revocable when selected")
    public void user_validates_salesforce_information_is_true_for_revocable(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceRevocableBox("true");
    }

    @Step("{0} user validates Salesforce Information is false for Revocable when selected")
    public void user_validates_salesforce_information_is_false_for_revocable(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceRevocableBox("false");
    }

    @Step("{0} user edits Beneficiary Person Information and updates revocable checkbox")
    public void user_edits_beneficiary_person_information(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.editPrimaryBeneficiary();
        beneficiariesPO.validatePrimaryBeneficiaryOnEdit();
        beneficiariesPO.unCheckRevocableCheckBox();
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks delete Beneficiary Information and clicks back")
    public void user_clicks_delete_beneficiary_information_and_clicks_back(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        beneficiariesPO.deletePrimaryBeneficiary();
        beneficiariesPO.validateBeneficiariesDeleteQuestion();
        planSelectionPO.clickSkipBackButton();
    }
    @Step("{0} user deletes Beneficiary Person Information")
    public void user_deletes_beneficiary_person_information(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.deletePrimaryBeneficiary();
        beneficiariesPO.validateBeneficiariesDeleteQuestion();
        planSelectionPO.clickSkipContinueButton();
    }
    @Step("{0} Delete all salesforce Test records")
    public void delete_all_salesforce_test_records(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.deleteAllTestRecords();
    }

    @Step("{0} Delete all salesforce Estate Test records")
    public void delete_all_salesforce_estate_test_records(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryEstatePO.initPage(getContext());
        beneficiaryEstatePO.deleteAllTestRecords();
    }

    @Step("{0} Delete all salesforce Organization Test records")
    public void delete_all_salesforce_organization_test_records(String gwt){
        AppHelper.waitForXHR(1);
        beneficiaryOrganisationPO.deleteAllTestRecords();
    }

    @Step("{0} user clicks continue and is able to validate all allocation errors")
    public void user_clicks_continue_and_is_able_to_validate_all_allocation_errors(String gwt){
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateAllocationError();
        beneficiariesPO.validateAllocationErrorTotalAndLogo();
    }
    @Step("{0} user clicks continue and is able to validate all additional allocation errors")
    public void user_clicks_continue_and_is_able_to_validate_all_additional_allocation_errors(String gwt){
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateAllocationError();
        beneficiariesPO.validateAdditionalAllocationErrorTotalAndLogo();
    }

    @Step("{0} user is able to continue with allocation as 100%")
    public void user_is_able_to_continue_with_allocation_as_100(String gwt){
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateAllocationSuccessTotalAndLogo();
    }

}
