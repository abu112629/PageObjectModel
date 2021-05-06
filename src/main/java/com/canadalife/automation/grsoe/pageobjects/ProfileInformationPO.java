package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.VlocityInput;
import org.openqa.selenium.support.FindBy;
import ui.auto.core.components.WebComponent;
import ui.auto.core.data.DataTypes;
import ui.auto.core.support.PageObjectModel;

public class ProfileInformationPO extends PageObjectModel {

    @FindBy(xpath="//*[@data-omni-key='TB_Description_Header']//p")
    private WebComponent profileDescription;

    @FindBy(xpath="//*[@data-omni-key='TB_PersonalInfo']//h3")
    private WebComponent profileHeader;

    @FindBy(xpath="//*[@data-omni-key='TB_PersonalInfo']//div/div")
    private WebComponent reviewProfileHeader;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileNameLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileDOBLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileSINLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileEmailLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileMailingAddressLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileNameData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileDOBData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileSINData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileEmailData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_PersonalInfo']")
    private VlocityInput profileMailingAddressData;

    public void validateProfileDescription(){
        profileDescription.validateData(DataTypes.Data);
    }
    public void validateProfileHeader(){
        profileHeader.validateData(DataTypes.Data);
    }
    public void validateReviewProfileHeader(){
        reviewProfileHeader.validateData(DataTypes.Data);
    }
    public void validateProfileLabels(){
        profileNameLabel.getInformationLabel();
        profileNameLabel.validateInformationText(DataTypes.Initial);

        profileDOBLabel.getInformationLabel();
        profileDOBLabel.validateInformationText(DataTypes.Initial);

        profileSINLabel.getInformationLabel();
        profileSINLabel.validateInformationText(DataTypes.Initial);

        profileEmailLabel.getInformationLabel();
        profileEmailLabel.validateInformationText(DataTypes.Initial);

        profileMailingAddressLabel.getInformationLabel();
        profileMailingAddressLabel.validateInformationText(DataTypes.Initial);
    }

    public void validateProfileInformation(){
        profileNameData.getAllocationPercentage();
        profileNameData.validateAllocationPercentage(DataTypes.Initial);

        profileDOBData.getAllocationPercentage();
        profileDOBData.validateAllocationPercentage(DataTypes.Initial);

        profileSINData.getAllocationPercentage();
        profileSINData.validateAllocationPercentage(DataTypes.Initial);

        profileEmailData.getAllocationPercentage();
        profileEmailData.validateAllocationPercentage(DataTypes.Initial);

        profileMailingAddressData.getAllocationPercentage();
        profileMailingAddressData.validateAllocationPercentage(DataTypes.Initial);
    }
}
