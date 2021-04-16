package com.canadalife.automation.grsoe.domainobjects;

import com.canadalife.automation.grsoe.pageobjects.LoginPO;
import com.canadalife.automation.grsoe.pageobjects.MemberLandingPagePO;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.testng.TestNGBase;

@XStreamAlias("plan-domain-object")
public class MemberLandingDO extends DomainObjectModel {

    private LoginPO loginPO;
    private MemberLandingPagePO memberLandingPagePO;

    private MemberLandingDO() {}
    public MemberLandingDO(TestContext context){
        this.context = context;
    }


    @Step("{0} User on plan selection page")
    public void user_on_plan_selection_page(String gwt) {
        loginPO.initPage(getContext());
        loginPO.login();
        loginPO.navigate("s/grs-plan-selection");
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} User on member landing page")
    public void user_on_member_landing_page(String gwt) {
        loginPO.navigate("s/memberlandingpage");
        TestNGBase.takeScreenshot("");
    }

    @Step("{0} Validate member landing page information")
    public void validate_member_landing_page_information(String gwt) {
        memberLandingPagePO.initPage(getContext());
        memberLandingPagePO.validateMemberWelcomeLine();
        memberLandingPagePO.validateMemberWelcomeIntro();
        memberLandingPagePO.validateMemberBulletPoints();
        memberLandingPagePO.validateMemberQuebecIntro();
        memberLandingPagePO.validateMemberAccordionContent();
        memberLandingPagePO.validateQuebecAdditionalInformation();
    }
}
