package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.VlocitySelect;
import com.canadalife.automation.grsoe.support.AppHelper;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.components.WebComponentList;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class MemberLandingPagePO extends PageObjectModel {

    @FindBy(xpath="//*[contains(@class,'slds-rich-text-editor__output')]//h1")
    private WebComponent memberWelcomeLine;

    @FindBy(xpath="//*[contains(@class,'slds-rich-text-editor__output')]//h2")
    private WebComponent memberWelcomeIntro;

    @FindBy(xpath="//*[contains(@class,'slds-rich-text-editor__output')]//h3")
    private WebComponent memberQuebecIntro;

    @FindBy(xpath="//*[contains(@class,'slds-rich-text-editor__output')]//h4")
    private WebComponentList memberQuebecAdditionalInformation;

    @FindBy(xpath="//*[contains(@class,'nds-text-body_regular')]")
    private VlocitySelect memberWelcomeBulletPointOne;

    @FindBy(xpath="//*[contains(@class,'nds-text-body_regular')]")
    private VlocitySelect memberWelcomeBulletPointTwo;

    @FindBy(xpath="//*[contains(@class,'nds-text-body_regular')]")
    private VlocitySelect memberWelcomeBulletPointThree;

    @FindBy(xpath="//*[contains(@class,'nds-text-body_regular')]")
    private VlocitySelect memberWelcomeBulletPointFour;

    @FindBy(xpath="//p[contains(@class,'x-small')]")
    private WebComponentList memberAccordionContent;

    public void validateMemberWelcomeLine(){
        memberWelcomeLine.validateData(DataTypes.Data);
    }

    public void validateMemberWelcomeIntro(){
        memberWelcomeIntro.validateData(DataTypes.Data);
    }

    public void validateMemberQuebecIntro(){
        memberQuebecIntro.validateData(DataTypes.Data);
    }

    public void validateQuebecAdditionalInformation(){
        memberQuebecAdditionalInformation.initPage(getContext());
        memberQuebecAdditionalInformation.validateAll();
    }

    public void validateMemberBulletPoints(){

        AppHelper.scrollToView(memberWelcomeBulletPointOne.getCoreElement());
        memberWelcomeBulletPointOne.getListDetails();
        memberWelcomeBulletPointOne.validateListDetails(DataTypes.Initial);

        memberWelcomeBulletPointTwo.getListDetails();
        memberWelcomeBulletPointTwo.validateListDetails(DataTypes.Initial);

        memberWelcomeBulletPointThree.getListDetails();
        memberWelcomeBulletPointThree.validateListDetails(DataTypes.Initial);

        memberWelcomeBulletPointFour.getListDetails();
        memberWelcomeBulletPointFour.validateListDetails(DataTypes.Initial);
    }


    public void validateMemberAccordionContent(){
        memberAccordionContent.initPage(getContext());
        memberAccordionContent.validateAll();
    }
}
