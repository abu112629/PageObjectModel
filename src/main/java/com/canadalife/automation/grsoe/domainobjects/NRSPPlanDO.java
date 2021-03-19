package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.*;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class NRSPPlanDO extends DomainObjectModel {
    private LoginPO loginPO;
    private PlanSelectionPO planSelectionPO;
    private NRSPAdditionalInfoPO nrspAdditionalInfoPO;

    private NRSPPlanDO() {}
    public NRSPPlanDO(TestContext context){
        this.context = context;
    }

    @Step("{0} Member on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        TestNGBase.takeScreenshot("");

        planSelectionPO.initPage(getContext());
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.initPage(getContext());
    }

    @Step("{0} Member can select required Plan")
    public void user_can_select_required_plan(String gwt) {
        planSelectionPO.selectRequiredPlan();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} Member can see Plan Headers and sub Headers")
    public void user_can_see_plan_headers_and_subheaders(String gwt) {
        planSelectionPO.validatePlansHeader();
        planSelectionPO.validatePlanssubHeader();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member is able to see the first two FACTA with yes/no answers")
    public void user_can_see_two_facta_with_yes_or_no(String gwt) {
        planSelectionPO.validateAdditionalQuestions();
    }

    @Step("{0} Member has not answered a question and selects continue, then the member will see an in-line error message")
    public void user_can_see_inline_error_messages_for_no_selection(String gwt) {
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageNoselection();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member selects yes for first question and did not enter US TIN and selects continue, then they see an error message")
    public void user_can_see_error_messages_for_no_us_tin_entered(String gwt) {
        nrspAdditionalInfoPO.clickYesforUSCitizen();
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageNoUSTIN();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member enters US TIN for first question")
    public void user_enters_us_tin(String gwt) {
        nrspAdditionalInfoPO.validateUStaxPayerLabel();
        nrspAdditionalInfoPO.enterTINforUSCitizen();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member selects yes for the second question and does not select country, then they see an error message")
    public void user_can_see_error_messages_for_no_country_selection(String gwt) {
        nrspAdditionalInfoPO.clickYesforOtherCitizen();
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageNoCountrySelection();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member selects yes for the second question, then they will see a drop down field to select their Country of residency")
    public void user_can_select_country_from_dropdown(String gwt) {
        nrspAdditionalInfoPO.selectCountry();
    }

    @Step("{0} Member can see the Hint Text Labels for all required fields")
    public void user_can_see_hint_text_labels(String gwt) {
        planSelectionPO.validateHinttextLabels();
    }

    @Step("{0} Member did not answer for additional TIN, then they see an error message")
    public void user_can_see_error_messages_for_no_additional_tin_selection(String gwt) {
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageNoSelectionsecondaryTIN();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member selects country, they will see another question asking if they have additional TIN number and yes/no button")
    public void user_can_see_additional_tin_question(String gwt) {
        nrspAdditionalInfoPO.clickYesforOtherTIN();
        nrspAdditionalInfoPO.validateAdditionalTINinputlabel();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} Member can see error message if no additional TIN number or invalid TIN number is provided")
    public void user_can_see_error_message_for_no_additional_tin_provided(String gwt) {

        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageNoOtherCountryTIN();
        TestNGBase.takeScreenshot("");

        nrspAdditionalInfoPO.enterInvalidTINforNonUSCitizen();
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageInvalidOtherCountryTIN();
        TestNGBase.takeScreenshot("");

    }


    @Step("{0} Member selects yes for the additional TIN question, then they see a field to enter their TIN number")
    public void user_enters_additional_tin_for_other_country(String gwt){
        nrspAdditionalInfoPO.enterTINforNonUSCitizen();
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Member can see an error when they no reason for the additional TIN question after selecting No")
    public void user_can_see_additional_reasons(String gwt) {
        nrspAdditionalInfoPO.clickNoforOtherTIN();
        planSelectionPO.clickContinueButton();
        nrspAdditionalInfoPO.errorMessageNoRadioSelectionAdditionalTIN();
        TestNGBase.takeScreenshot("");

    }

    @Step("{0} Member selects a reason for the additional TIN question")
    public void user_selects_radio_button_for_additional_reasons(String gwt) {

        nrspAdditionalInfoPO.selectRadioButtonforNoAdditionalTIN();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();
    }

    @Step("{0} Member sees an error message when no details provided in the reason input")
    public void user_can_see_error_when_no_details_provided_in_reason(String gwt) {
        nrspAdditionalInfoPO.validateReasonforAdditionalTINLabel();
        nrspAdditionalInfoPO.errorMessageNoAdditionalDetailsProvided();
        nrspAdditionalInfoPO.enterAdditionalDetailsforNoTIN();
        TestNGBase.takeScreenshot("");
        planSelectionPO.clickContinueButton();

    }
}
