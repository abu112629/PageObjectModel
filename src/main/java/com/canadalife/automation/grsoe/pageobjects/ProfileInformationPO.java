package com.canadalife.automation.grsoe.pageobjects;

import com.canadalife.automation.grsoe.components.VlocityInput;
import com.canadalife.automation.grsoe.support.AppHelper;
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

    @FindBy(xpath="//*[@data-omni-key='PlanSelectedHeadingTextBlock']//h3")
    private WebComponent reviewPlanProfileHeader;

    @FindBy(xpath="//*[@data-omni-key='ReviewPlanSelectionLWC']")
    private VlocityInput reviewFieldLabel;

    @FindBy(xpath="//*[@data-omni-key='ReviewPlanSelectionLWC']")
    private VlocityInput reviewPlanFieldData;

    @FindBy(xpath="//*[@data-omni-key='TB_EmploymentInfo']//h3")
    private WebComponent employmentInfoHeader;

    @FindBy(xpath="//*[@data-omni-key='CLWC_EmploymentInfo']")
    private VlocityInput employeeNumberLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_EmploymentInfo']")
    private VlocityInput employeeNumberData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_EmploymentInfo']")
    private VlocityInput employeeDOHLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_EmploymentInfo']")
    private VlocityInput employeeDOHData;

    @FindBy(xpath="//*[@data-omni-key='CLWC_EmploymentInfo']")
    private VlocityInput employeeProvinceLabel;

    @FindBy(xpath="//*[@data-omni-key='CLWC_EmploymentInfo']")
    private VlocityInput employeeProvinceData;

    @FindBy(xpath="//*[@data-omni-key='AdditionalInformationHeadingTextBlock']//h4")
    private WebComponent additionalInfoHeader;

    @FindBy(xpath="//*[@data-omni-key='AdditionalInformationDPSPLWC']")
    private VlocityInput additionalInfoDPSPLabel;

    @FindBy(xpath="//*[@data-omni-key='AdditionalInformationDPSPLWC']")
    private VlocityInput additionalInfoDPSPData;

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

    public void validatePlanProfileHeader(){
        reviewPlanProfileHeader.validateData(DataTypes.Data);
    }

    public void validatePlanFieldLabels(){
        reviewFieldLabel.getInformationLabel();
        reviewFieldLabel.validateInformationText(DataTypes.Expected);
    }

    public void validatePlanFieldData(){
        reviewPlanFieldData.getAllocationPercentage();
        reviewPlanFieldData.validateAllocationPercentage(DataTypes.Expected);
    }

    public void validateEmploymentInfoHeader(){
        AppHelper.scrollToView(employmentInfoHeader.getCoreElement());
        employmentInfoHeader.validateData(DataTypes.Data);
    }

    public void validateEmploymentFieldLabels(){
        employeeNumberLabel.getInformationLabel();
        employeeNumberLabel.validateInformationText(DataTypes.Expected);

        employeeDOHLabel.getInformationLabel();
        employeeDOHLabel.validateInformationText(DataTypes.Expected);

        employeeProvinceLabel.getInformationLabel();
        employeeProvinceLabel.validateInformationText(DataTypes.Expected);
    }

    public void validateEmploymentFieldData(){
        employeeNumberData.getAllocationPercentage();
        employeeNumberData.validateAllocationPercentage(DataTypes.Expected);

        employeeDOHData.getAllocationPercentage();
        employeeDOHData.validateAllocationPercentage(DataTypes.Expected);

        employeeProvinceData.getAllocationPercentage();
        employeeProvinceData.validateAllocationPercentage(DataTypes.Expected);
    }

    public void validateAdditionalInfoHeader(){
        AppHelper.scrollToView(additionalInfoHeader.getCoreElement());
        additionalInfoHeader.validateData(DataTypes.Data);
    }

    public void validateAdditionalInfoDPSPLabel(){
        additionalInfoDPSPLabel.getInformationLabel();
        additionalInfoDPSPLabel.validateInformationText(DataTypes.Expected);
    }

    public void validateAdditionalInfoDPSPData(){
        additionalInfoDPSPData.getAllocationPercentage();
        additionalInfoDPSPData.validateAllocationPercentage(DataTypes.Expected);
    }
}
