package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.canadalife.automation.grsoe.support.AppHelper;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class ContingentBeneficiariesDO extends DomainObjectModel {

    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;
    private InvestmentPO investmentPO;
    private ContingentBeneficiaryPO contingentBeneficiaryPO;
    private ContingentBeneficiaryEstatePO contingentbeneficiaryEstatePO;
    private ContingentBeneficiaryOrganizationPO contingentbeneficiaryOrganizationPO;
    private ContingentBeneficiaryTrusteePO contingentbeneficiaryTrusteePO;

    private ContingentBeneficiariesDO() {}
    public ContingentBeneficiariesDO(TestContext context){
        this.context = context;
    }

    @Step("{0} user validates Contingent Beneficiary Header and Description")
    public void user_validates_contingent_beneficiary_header_and_description(String gwt){
        contingentBeneficiaryPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        contingentBeneficiaryPO.validateContingentBeneficiaryHeaderAndDescription();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks add Contingent Beneficiary")
    public void user_clicks_add_contingent_beneficiary(String gwt){
        contingentBeneficiaryPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        contingentBeneficiaryPO.addContingentBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks add additional Contingent Beneficiary")
    public void user_clicks_add_additional_contingent_beneficiary(String gwt){
        contingentBeneficiaryPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        contingentBeneficiaryPO.addMultipleContingentBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user clicks continue and is able to validate all errors")
    public void user_clicks_continue_and_is_able_to_validate_all_errors(String gwt){
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateErrors();
    }

    @Step("{0} user selects and validates person beneficiary details")
    public void user_selects_and_validates_person_beneficiary(String gwt){
        contingentBeneficiaryPO.addBeneficiary();
        contingentBeneficiaryPO.validateBeneficiaryFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user selects and validates estate beneficiary details")
    public void user_selects_and_validates_estate_beneficiary(String gwt){
        contingentBeneficiaryPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        contingentBeneficiaryPO.additionalBeneficiary();
        contingentbeneficiaryEstatePO.initPage(getContext());
        contingentbeneficiaryEstatePO.validateEstateBeneFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user selects and validates organization beneficiary details")
    public void user_selects_and_validates_organization_beneficiary(String gwt){
        contingentBeneficiaryPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        contingentBeneficiaryPO.additionalBeneficiary();
        contingentbeneficiaryOrganizationPO.initPage(getContext());
        contingentbeneficiaryOrganizationPO.validateOrganisationBeneFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user clicks continue and is able to validate all estate errors")
    public void user_clicks_continue_and_is_able_to_validate_all_estate_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryEstatePO.validateEstateError();
    }

    @Step("{0} user clicks continue and is able to validate all organization errors")
    public void user_clicks_continue_and_is_able_to_validate_all_organization_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryOrganizationPO.validateOrganizationError();
    }

    @Step("{0} user enters invalid person beneficiary details")
    public void user_enters_invalid_person_beneficiary(String gwt){
        contingentBeneficiaryPO.selectPersonRelationBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateInvalidPersonBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters invalid estate beneficiary details")
    public void user_enters_invalid_estate_beneficiary(String gwt){
        contingentbeneficiaryEstatePO.validateInvalidEstateBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters invalid organization beneficiary details")
    public void user_enters_invalid_organization_beneficiary(String gwt){
        contingentbeneficiaryOrganizationPO.validateInvalidOrganizationBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters person beneficiary details")
    public void user_enters_person_beneficiary_details(String gwt){
        contingentBeneficiaryPO.selectPersonRelationBeneficiary();
        contingentBeneficiaryPO.validateAndEnterDetailsContingentBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.enterDOBDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters duplicate person beneficiary details")
    public void user_enters_duplicate_person_beneficiary_details(String gwt){
        contingentBeneficiaryPO.selectAdditionalPersonRelationBeneficiary();
        contingentBeneficiaryPO.validateAndEnterDuplicateDetailsContingentBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryTrusteePO.initPage(getContext());
        contingentbeneficiaryTrusteePO.selectContingentTrusteeNoDuplicate();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user enters duplicate person beneficiary details for contingent as in primary")
    public void user_enters_duplicate_person_beneficiary_details_like_primary(String gwt){
        contingentBeneficiaryPO.selectAdditionalPersonRelationBeneficiary();
        contingentBeneficiaryPO.validateAndEnterDuplicateDetailsBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryTrusteePO.initPage(getContext());
        contingentbeneficiaryTrusteePO.selectContingentTrusteeNoDuplicate();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects organization beneficiary")
    public void user_selects_organization_beneficiary(String gwt){
        contingentBeneficiaryPO.additionalBeneficiary();
        contingentbeneficiaryOrganizationPO.initPage(getContext());
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user selects Estate beneficiary")
    public void user_selects_estate_beneficiary(String gwt){
        contingentBeneficiaryPO.additionalBeneficiary();
        contingentbeneficiaryEstatePO.initPage(getContext());
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user enters duplicate organization beneficiary details")
    public void user_enters_duplicate_organization_beneficiary_details(String gwt){
        contingentBeneficiaryPO.additionalBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryOrganizationPO.initPage(getContext());
        contingentbeneficiaryOrganizationPO.enterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user enters duplicate organization beneficiary details for contingent as in primary")
    public void user_enters_duplicate_organization_beneficiary_details_like_primary(String gwt){
        contingentBeneficiaryPO.additionalBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryOrganizationPO.initPage(getContext());
        contingentbeneficiaryOrganizationPO.enterDetailsDuplicateOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user enters duplicate estate beneficiary details")
    public void user_enters_duplicate_estate_beneficiary_details(String gwt){
        contingentBeneficiaryPO.additionalBeneficiary();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryEstatePO.initPage(getContext());
        contingentbeneficiaryEstatePO.enterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
    }
    @Step("{0} user clicks save and is able to validate all duplicate bene errors")
    public void user_clicks_save_and_is_able_to_validate_all_duplicate_bene_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateDuplicateBeneDetailsError();
    }

    @Step("{0} user clicks save and is able to validate all duplicate primary contingent errors")
    public void user_clicks_save_and_is_able_to_validate_all_duplicate_primary_contingent_errors(String gwt){
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateDuplicateContingentPrimaryDetailsError();
    }

    @Step("{0} user selects and validates primary Trustee")
    public void user_selects_and_validates_primary_trustee(String gwt){
        contingentbeneficiaryTrusteePO.initPage(getContext());
        contingentbeneficiaryTrusteePO.validateBeneficaryTrusteeQuestion();
        contingentbeneficiaryTrusteePO.selectContingentTrusteeNo();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user clicks on Save Beneficiary Form")
    public void user_clicks_save_beneficiary(String gwt){
        AppHelper.waitForXHR(2);
        contingentBeneficiaryPO.validateAndEnterContingentAllocation();
        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Estate")
    public void user_clicks_save_beneficiary_for_estate(String gwt){
        AppHelper.waitForXHR(2);
        contingentbeneficiaryEstatePO.validateAndEnterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }
    @Step("{0} user enters and clicks on Save Beneficiary Form for Estate")
    public void user_enters_and_clicks_save_beneficiary_for_estate(String gwt){
        AppHelper.waitForXHR(2);
        contingentbeneficiaryEstatePO.enterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Organization")
    public void user_clicks_save_beneficiary_for_organization(String gwt){
        AppHelper.waitForXHR(2);
        contingentbeneficiaryOrganizationPO.validateAndEnterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Organization")
    public void user_enters_and_clicks_save_beneficiary_for_organization(String gwt){
        AppHelper.waitForXHR(2);
        contingentbeneficiaryOrganizationPO.enterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user validates Pill information after saving the details")
    public void user_validates_pill_information_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validatePillInformation();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Pill information for Estate after saving the details")
    public void user_validates_pill_information_for_estate_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryEstatePO.validatePillInformationEstate();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Pill information for Organization after saving the details")
    public void user_validates_pill_information_for_organization_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryOrganizationPO.validatePillInformationOrganization();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Salesforce Information is saved for member")
    public void user_validates_salesforce_information_is_saved_for_member(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.validateSalesforceBeneficiaryRecord();
    }

    @Step("{0} user validates Salesforce Information is deleted for member")
    public void user_validates_salesforce_information_is_deleted_for_member(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.validateSalesforceBeneficiaryRecordDeleted();
    }

    @Step("{0} user validates Salesforce Information is saved for Estate")
    public void user_validates_salesforce_information_is_saved_for_estate(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryEstatePO.validateSalesforceEstateRecord();
    }

    @Step("{0} user validates Salesforce Information is saved for Organization")
    public void user_validates_salesforce_information_is_saved_for_organization(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryOrganizationPO.validateSalesforceOrganizationRecord();
    }

    @Step("{0} user clicks continue and is able to validate no selection Trustee error")
    public void user_clicks_continue_and_is_able_to_validate_no_selection_trustee_error(String gwt){
        planSelectionPO.clickSaveButton();
        contingentbeneficiaryTrusteePO.initPage(getContext());
        contingentbeneficiaryTrusteePO.validateContingentTrusteeError();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user selects yes for Trustee and is able to validate all Trustee errors when left empty")
    public void user_selects_yes_and_is_able_to_validate_all_trustee_errors_when_empty(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryTrusteePO.validateContingentTrusteeEmptyErrors();
    }

    @Step("{0} user is able to validate all Trustee form labels")
    public void user_is_able_to_validate_all_trustee_form_labels(String gwt){
        contingentbeneficiaryTrusteePO.initPage(getContext());
        contingentbeneficiaryTrusteePO.validateBeneficaryTrusteeQuestion();
        contingentbeneficiaryTrusteePO.selectContingentTrusteeYes();
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        contingentbeneficiaryTrusteePO.validateTrusteeFormLabels();
    }

    @Step("{0} user enters invalid trustee details")
    public void user_enters_invalid_trustee_details(String gwt){
       contingentbeneficiaryTrusteePO.validateInvalidTrusteeDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters duplicate trustee details and beneficiary details")
    public void user_enters_duplicate_trustee_and_beneficiary_details(String gwt){
        contingentbeneficiaryTrusteePO.validateDuplicateBeneTrusteeDetails();
        planSelectionPO.clickSaveButton();
        contingentbeneficiaryTrusteePO.validateDuplicateBeneTrusteeDetailsError();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters duplicate trustee details as primary and beneficiary details")
    public void user_enters_duplicate_trustee_as_primary_and_beneficiary_details(String gwt){
        contingentbeneficiaryTrusteePO.validateDuplicateTrusteePrimaryDetails();
        planSelectionPO.clickSaveButton();
        contingentbeneficiaryTrusteePO.validateDuplicatePrimaryTrusteeDetailsError();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters trustee details and clicks save")
    public void user_enters_trustee_details_and_clicks_save(String gwt){
        contingentbeneficiaryTrusteePO.validateAndEnterDetailsTrusteeBeneficiary();
        contingentBeneficiaryPO.validateAndEnterContingentAllocation();
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user validates Pill information after saving the details for Trustee")
    public void user_validates_pill_information_after_saving_the_details_for_trustee(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryTrusteePO.validatePillInformationTrustee();
        TestNGBase.takeScreenshot("");
    }
    @Step("{0} user validates Salesforce Information is saved for Trustee")
    public void user_validates_salesforce_information_is_saved_for_trustee(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryTrusteePO.validateSalesforceTrusteeRecord();
    }

    @Step("{0} user validates Quebec Question and Checks Revocable Option")
    public void user_validates_quebec_question_and_checks_revocable_option(String gwt){
        contingentBeneficiaryPO.validateQuebecQuestionAndLabels();
        contingentBeneficiaryPO.validateRevocableCheckBox();
        TestNGBase.takeScreenshot("");

    }
    @Step("{0} user validates Salesforce Information is true for Revocable when selected")
    public void user_validates_salesforce_information_is_true_for_revocable(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.validateSalesforceRevocableBox("true");
    }

    @Step("{0} user validates Salesforce Information is false for Revocable when selected")
    public void user_validates_salesforce_information_is_false_for_revocable(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.validateSalesforceRevocableBox("false");
    }

    @Step("{0} user edits Beneficiary Person Information and updates revocable checkbox")
    public void user_edits_beneficiary_person_information(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.editContingentBeneficiary();
        contingentBeneficiaryPO.validateContingentBeneficiaryOnEdit();
        contingentBeneficiaryPO.unCheckRevocableCheckBox();
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks delete Beneficiary Information and clicks back")
    public void user_clicks_delete_beneficiary_information_and_clicks_back(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        contingentBeneficiaryPO.deleteContingentBeneficiary();
        contingentBeneficiaryPO.validateBeneficiariesDeleteQuestion();
        planSelectionPO.clickSkipBackButton();
    }
    @Step("{0} user deletes Beneficiary Person Information")
    public void user_deletes_beneficiary_person_information(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.deleteContingentBeneficiary();
        contingentBeneficiaryPO.validateBeneficiariesDeleteQuestion();
        planSelectionPO.clickSkipContinueButton();
    }
    @Step("{0} Delete all salesforce Test records")
    public void delete_all_salesforce_test_records(String gwt){
        AppHelper.waitForXHR(1);
        contingentBeneficiaryPO.deleteAllTestRecords();
    }

    @Step("{0} Delete all salesforce Estate Test records")
    public void delete_all_salesforce_estate_test_records(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryEstatePO.initPage(getContext());
        contingentbeneficiaryEstatePO.deleteAllTestRecords();
    }

    @Step("{0} Delete all salesforce Organization Test records")
    public void delete_all_salesforce_organization_test_records(String gwt){
        AppHelper.waitForXHR(1);
        contingentbeneficiaryOrganizationPO.deleteAllTestRecords();
    }

    @Step("{0} user clicks continue and is able to validate all allocation errors")
    public void user_clicks_continue_and_is_able_to_validate_all_allocation_errors(String gwt){
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateAllocationError();
        contingentBeneficiaryPO.validateAllocationErrorTotalAndLogo();
    }
    @Step("{0} user clicks continue and is able to validate all additional allocation errors")
    public void user_clicks_continue_and_is_able_to_validate_all_additional_allocation_errors(String gwt){
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateAllocationError();
        contingentBeneficiaryPO.validateAdditionalAllocationErrorTotalAndLogo();
    }

    @Step("{0} user is able to continue with allocation as 100%")
    public void user_is_able_to_continue_with_allocation_as_100(String gwt){
        TestNGBase.takeScreenshot("");
        contingentBeneficiaryPO.validateAllocationSuccessTotalAndLogo();
    }


}
