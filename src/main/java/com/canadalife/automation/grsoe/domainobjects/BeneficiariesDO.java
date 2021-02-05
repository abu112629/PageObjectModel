package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;

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
    }

    @Step("{0} Member can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user clicks continue and selects no for both questions")
    public void user_clicks_continue_and_selects_no_for_both_questions(String gwt){
        nrspAdditionalInfoPO.initPage(getContext());
        nrspAdditionalInfoPO.clickNoforUSCitizen();
        nrspAdditionalInfoPO.clickNoforOtherCitizen();
        planSelectionPO.clickContinueButton();

    }

    @Step("{0} user validates beneficiaries section")
    public void user_validates_beneficiaries_section(String gwt){
        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        planSelectionPO.validatePlanProgressBarStep();
        beneficiariesPO.initPage(getContext());
        beneficiariesPO.validateBeneficiariesDescription();
        planSelectionPO.clickContinueButton();

    }

    @Step("{0} user validates beneficiaries Skip section and clicks continue")
    public void user_validates_beneficiaries_skip_section(String gwt){
        beneficiariesPO.initPage(getContext());
        planSelectionPO.initPage(getContext());
        beneficiariesPO.validateBeneficiariesSkipQuestionandDetails();
        planSelectionPO.clickSkipContinueButton();

    }

    @Step("{0} user clicks Skip back and reach add beneficiaries page and clicks back to reach investments")
    public void user_clicks_back_and_reach_add_beneficiaries_page_and_back_to_investments(String gwt){
        planSelectionPO.clickBackButton();
        planSelectionPO.clickContinueButton();
        planSelectionPO.clickSkipBackButton();
        beneficiariesPO.validateBeneficiariesDescription();
        planSelectionPO.clickBackButton();
        investmentPO.initPage(getContext());
        investmentPO.validateInvestmentCardSelected();

    }

    @Step("{0} user clicks add Primary Beneficiary")
    public void user_clicks_add_primary_beneficiary(String gwt){
        planSelectionPO.clickContinueButton();
        beneficiariesPO.initPage(getContext());
        beneficiariesPO.addPrimaryBeneficiary();
    }

    @Step("{0} user clicks continue and is able to validate all errors")
    public void user_clicks_continue_and_is_able_to_validate_all_errors(String gwt){
        planSelectionPO.clickSaveButton();
        beneficiariesPO.validateErrors();
    }

    @Step("{0} user selects and validates person beneficiary details")
    public void user_selects_and_validates_person_beneficiary(String gwt){
        beneficiariesPO.addPersonBeneficiary();
        beneficiariesPO.validateBeneficiaryFormLabels();
        planSelectionPO.validateHinttextLabels();

    }

    @Step("{0} user enters invalid person beneficiary details")
    public void user_enters_invalid_person_beneficiary(String gwt){
        beneficiariesPO.selectPersonRelationBeneficiary();
        beneficiariesPO.validateInvalidPersonBeneficiaryDetails();

    }

    @Step("{0} user enters person beneficiary details")
    public void user_enters_person_beneficiary_details(String gwt){
        beneficiariesPO.selectPersonRelationBeneficiary();
        beneficiariesPO.validateAndEnterDetailsPrimaryBeneficiary();
        rppAdditionalInfoPO.initPage(getContext());
        rppAdditionalInfoPO.enterDOBDetails();

    }
    @Step("{0} user clicks on Save Beneficiary Form")
    public void user_clicks_save_beneficiary(String gwt){
        planSelectionPO.clickSaveButton();
    }


}
