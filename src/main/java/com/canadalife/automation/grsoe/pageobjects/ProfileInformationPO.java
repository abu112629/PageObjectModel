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

    @FindBy(xpath="//*[@data-omni-key='CLWC_FullName']")
    private VlocityInput profileNameLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_DOB']")
    private VlocityInput profileDOBLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_SIN']")
    private VlocityInput profileSINLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_Email']")
    private VlocityInput profileEmailLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_Address']")
    private VlocityInput profileMailingAddressLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_FullName']")
    private VlocityInput profileNameData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_DOB']")
    private VlocityInput profileDOBData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_SIN']")
    private VlocityInput profileSINData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_Email']")
    private VlocityInput profileEmailData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_Address']")
    private VlocityInput profileMailingAddressData;

    public void validateProfileDescription(){
        profileDescription.validateData(DataTypes.Data);
    }
    public void validateProfileHeader(){
        profileHeader.validateData(DataTypes.Data);
    }

    public void validateProfileLabels(){
        profileNameLabel.validateInformationText(DataTypes.Data);
        profileDOBLabel.validateInformationText(DataTypes.Data);
        profileSINLabel.validateInformationText(DataTypes.Data);
        profileEmailLabel.validateInformationText(DataTypes.Data);
        profileMailingAddressLabel.validateInformationText(DataTypes.Data);
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
