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

    @Step("{0} user clicks add Primary Beneficiary")
    public void user_clicks_add_primary_beneficiary(String gwt){
        planSelectionPO.clickContinueButton();
        beneficiariesPO.initPage(getContext());
        AppHelper.waitForXHR(2);
        beneficiariesPO.addPrimaryBeneficiary();
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
        beneficiariesPO.addBeneficiary();
        beneficiariesPO.validateEstateBeneFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user selects and validates organization beneficiary details")
    public void user_selects_and_validates_organization_beneficiary(String gwt){
        beneficiariesPO.addBeneficiary();
        beneficiariesPO.validateOrganisationBeneFormLabels();
        TestNGBase.takeScreenshot("");
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user clicks continue and is able to validate all estate errors")
    public void user_clicks_continue_and_is_able_to_validate_all_estate_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateEstateError();
    }

    @Step("{0} user clicks continue and is able to validate all organization errors")
    public void user_clicks_continue_and_is_able_to_validate_all_organization_errors(String gwt){
        planSelectionPO.clickSaveButton();
        TestNGBase.takeScreenshot("");
        beneficiariesPO.validateOrganizationError();
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
        beneficiariesPO.validateInvalidEstateBeneficiaryDetails();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} user enters invalid organization beneficiary details")
    public void user_enters_invalid_organization_beneficiary(String gwt){
        beneficiariesPO.validateInvalidOrganizationBeneficiaryDetails();
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

    @Step("{0} user selects and validates primary Trustee")
    public void user_selects_and_validates_primary_trustee(String gwt){
       beneficiariesPO.validateBeneficaryTrusteeQuestion();
       beneficiariesPO.selectPrimaryTrusteeYesorNo();
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
        beneficiariesPO.validateAndEnterDetailsEstateBeneficiary();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickSaveButton();
    }

    @Step("{0} user clicks on Save Beneficiary Form for Organization")
    public void user_clicks_save_beneficiary_for_organization(String gwt){
        AppHelper.waitForXHR(2);
        beneficiariesPO.validateAndEnterDetailsOrganizationBeneficiary();
        TestNGBase.takeScreenshot("");
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
        beneficiariesPO.validatePillInformationEstate();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Pill information for Organization after saving the details")
    public void user_validates_pill_information_for_organization_after_saving_the_details(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validatePillInformationOrganization();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} user validates Salesforce Information is saved for member")
    public void user_validates_salesforce_information_is_saved_for_member(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceBeneficiaryRecord();
    }

    @Step("{0} user validates Salesforce Information is saved for Estate")
    public void user_validates_salesforce_information_is_saved_for_estate(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceEstateRecord();
    }

    @Step("{0} user validates Salesforce Information is saved for Organization")
    public void user_validates_salesforce_information_is_saved_for_organization(String gwt){
        AppHelper.waitForXHR(1);
        beneficiariesPO.validateSalesforceOrganizationRecord();
    }

}
