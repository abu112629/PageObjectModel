package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.canadalife.automation.grsoe.pageobjects.PlanSelectionPO;
import com.canadalife.automation.grsoe.pageobjects.RPPAdditionalInfoPO;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;

@XStreamAlias("plan-domain-object")
public class RPPPlanDO extends DomainObjectModel {

    private LoginPO loginPO;
    private RPPAdditionalInfoPO rppplanSelectionPO;
    private PlanSelectionPO planSelectionPO;

    private RPPPlanDO() {}
    public RPPPlanDO(TestContext context){
        this.context = context;
    }

    @Step("{0} User on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");

        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} user can see Plan Headers and sub Headers")
    public void user_can_see_plan_headers_and_subheaders(String gwt) {
        planSelectionPO.validatePlansHeader();
        planSelectionPO.validatePlanssubHeader();
    }

    @Step("{0} user can see Plan Questions in Additional Info")
    public void user_can_see_plan_questions_in_additional_info(String gwt) {
        rppplanSelectionPO.initPage(getContext());
        planSelectionPO.validateAdditionalQuestions();

    }

    @Step("{0} user can see error message on no questions answered")
    public void user_can_see_error_messages_on_no_questions_answered(String gwt) {
        planSelectionPO.clickContinueButton();
        rppplanSelectionPO.errorMessageNoselection();
    }

    @Step("{0} user answers all questions and enters Spouse First Name and LastName")
    public void user_answers_both_questions_and_enters_spouse_details(String gwt) {
        rppplanSelectionPO.clickYesforspouse();
        rppplanSelectionPO.clickYesforconnectedperson();
        rppplanSelectionPO.validateLabels();
        rppplanSelectionPO.enterFirstNameSpouse();
        rppplanSelectionPO.enterLastNameSpouse();
        rppplanSelectionPO.validateConnectedPersonDetailsLabel();
    }

    @Step("{0} user can see the updated Connected Person Additional Info Question")
    public void user_can_see_the_updated_connected_person_additional_info_question(String gwt) {
        rppplanSelectionPO.initPage(getContext());
        rppplanSelectionPO.validateConnectedPersonDetailsLabel();
    }

    @Step("{0} user can see error message for Future Date of Birth")
    public void user_can_see_error_message_for_future_dob(String gwt) {
        rppplanSelectionPO.enterDOBDetails();
        planSelectionPO.clickContinueButton();
        rppplanSelectionPO.validateFutureDOBError();
    }

    @Step("{0} user enters valid Date of Birth")
    public void user_enters_dob(String gwt) {
        rppplanSelectionPO.enterDOBDetails();
    }

    @Step("{0} user can see error message for No Spouse First,last Name and no connected person selection")
    public void user_can_see_error_message_for_no_first_last_name_and_connected_person(String gwt) {
        rppplanSelectionPO.clickYesforspouse();
        planSelectionPO.clickContinueButton();
        rppplanSelectionPO.errorMessageNospousedetails();
        rppplanSelectionPO.errorMessageNoselectionconnectedperson();
    }

    @Step("{0} user can see error message for No Spouse last name and no connected person selection")
    public void user_can_see_error_message_for_no_last_name_and_connected_person(String gwt) {
        rppplanSelectionPO.enterFirstNameSpouse();
        planSelectionPO.clickContinueButton();
        rppplanSelectionPO.errorMessageNospouselastname();
    }

    @Step("{0} Member can see the Hint Text Labels for all required fields")
    public void user_can_see_hint_text_labels(String gwt) {
        rppplanSelectionPO.validateHintTextSpouseFirstName();
        rppplanSelectionPO.validateHintTextSpouseLastName();
    }

    @Step("{0} user can see instructions for Connected Person in Additional Info when selecting Yes")
    public void user_can_see_instructions_for_connected_person_in_additional_info(String gwt){
            rppplanSelectionPO.initPage(getContext());
            rppplanSelectionPO.clickYesforconnectedperson();
            rppplanSelectionPO.validateConnectedPersonDisclaimer();

    }

    @Step("{0} user cannot see instructions for Connected Person in Additional Info when selecting No")
    public void user_cannot_see_instructions_for_connected_person_in_additional_info(String gwt){
        rppplanSelectionPO.validateConnectedPersonDisclaimernotVisible();

    }

    @Step("{0} user clicks back and selects no for spouse details")
    public void user_clicks_back_and_selects_no_for_spouse(String gwt){
        planSelectionPO.clickBackButton();
        rppplanSelectionPO.clickNoforspouse();

    }

    @Step("{0} user is able to see salesforce records updated for spouse first name and last name after continue")
    public void user_is_able_to_see_salesforce_records_updated(String gwt) {
        planSelectionPO.clickContinueButton();
        rppplanSelectionPO.validateSalesforceSpouseRecord();

    }

    @Step("{0} user is able to see salesforce records deleted for spouse first name and last name after continue")
    public void user_is_able_to_see_salesforce_records_deleted(String gwt) {
        planSelectionPO.clickContinueButton();
        rppplanSelectionPO.validateSalesforceSpouseRecordDeletion();

    }


}
