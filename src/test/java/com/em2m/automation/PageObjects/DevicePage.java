package com.em2m.automation.PageObjects;

import org.openqa.selenium.By;



public class DevicePage  {

    private By toggleFilterBtn =By.xpath("//button[@mattooltip='Toggle Filters']");
    private By refreshResultsBtn =By.xpath("//button[@mattooltip='Refresh Results']");
    private By searchBtn =By.xpath("//i[@class='material-icons' and contains(text(),'search')]");
    private By searchBar =By.xpath("//li[@class='search-input-wrapper']//input");
    private By advanceQueryBuilderBtn = By.xpath("//li[@class='search-input-wrapper']");
    private By changeViewBtn = By.xpath("//button[@mattooltip='Change View']");
    private By createDeviceBtn = By.xpath("//*[contains(text(),'Create Device')]");
    private By actionsDropDown = By.xpath("//span[@class='button-wrapper ng-star-inserted']//span[contains(text(),'Actions')]");

    private By editDetails = By.xpath("//i[contains(text(),'edit')]");
    private By viewActionsBtn = By.xpath("//div[@class='header']//div[@class='center-content']");
    private By transferDeviceBtn = By.xpath("//button[@tabindex='0']");


//Transfer Device
    private By trasferTargetOrg = By.xpath("//input[@id='organization']");
    private By orgSearcher = By.xpath("//input[@id='org-searcher']");
    private By genericOrgPicker = By.xpath("//li//span[text()='%Name%']");
    private By okBtn = By.xpath("//button[text()='Ok']");
    private By transferBtn = By.xpath("//button//span[text()=' Transfer ']");
    private By confirmationYesBtn = By.xpath("//button//span[text()=' Yes ']");
    private By transferPopup = By.xpath("//span[contains(text(),'Device Transfer Complete')]");
    private By subOrgText = By.xpath("//*[@class=contains(text(),'top-container ng-tns')]//div[3]//span[contains(text(),'Sub-Organizations for Root')]");

//Search Scrollable Side_Bar
 //Radio Buttons
    private By subOrganizationRadioBtn = By.xpath("//*[contains(text(),'Include sub-organizations')]");
    private By archivedRadioBtn = By.xpath("//*[contains(text(),'archived')]");

//Device Info Table
 //Table Header
    private By selectAllCheckBox = By.xpath("//table[@role='table']//thead//tr//th[1]");
    private By deviceID = By.xpath("//table[@role='table']//thead//tr//th[2]");
    private By SimId =By.xpath("//table[@role='table']//thead//tr//th[3]");
    private By productCode = By.xpath("//table[@role='table']//thead//tr//th[4]");
    private By serialNumber =By.xpath("//table[@role='table']//thead//tr//th[5]");
    private By organization = By.xpath("//table[@role='table']//thead//tr//th[6]");
    private By type = By.xpath("//table[@role='table']//thead//tr//th[7]");
    private By status = By.xpath("//table[@role='table']//thead//tr//th[8]");
    private By career = By.xpath("//table[@role='table']//thead//tr//th[9]"); /**
     .
    and so on
     .
     **/
 //Table Content
    private By tableDatadeviceId = By.xpath("//tbody//tr//td[2]");/*------>it returns multiple elements*/
                                                                               //increase tr value for next row, increase td value for next column
    private  By genaricTableDatadeviceId = By.xpath("//tbody//tr//td[2]//*[text()='%Name%']");

//Create Device
    private By deviceProfileDropDown = By.xpath("//surveyor-forms[@class='ng-star-inserted']//*[@role='combobox']");
    private By provisionAirtimeCheckBox = By.xpath("//label[@class='mat-checkbox-layout']//*[contains(text(),'Provision Airtime')]");
    private By serialNumberTextBox = By.xpath("//input[@id='mat-input-1']");
    private By deviceIdTextBox = By.xpath("//input[@id='mat-input-2']");
    private By IMEI_NumberTextBox = By.xpath("//input[@id='mat-input-3']");
    private By ESN_NumberTextBox = By.xpath("//input[@id='mat-input-4']");
    private By MEID_NumberTextBox = By.xpath("//input[@id='mat-input-5']");
    private By ExternalIdTextBox = By.xpath("//input[@id='mat-input-6']");
    private By SimIdTextBox = By.xpath("//input[@id='mat-input-7']");
    private By IMSI_NumberTextBox = By.xpath("//input[@id='mat-input-8']");
    private By PhoneNumberTextBox = By.xpath("//input[@id='mat-input-9']");
    private By BoxIdTextBox = By.xpath("//input[@id='mat-input-10']");
    private By TagsTextBox = By.xpath("//input[@id='mat-input-11']");
    private By cancelBtn = By.xpath("//div[@class='mdl-dialog__actions ng-star-inserted']//*[contains(text(),'Cancel')]");
    private By createDeviceConfirmBtn = By.xpath("//div[@class='mdl-dialog__actions ng-star-inserted']//*[contains(text(),'Create Device')]");
    private By deviceMissingPopup = By.xpath("//span[contains(text(),'Device is missing')]");
 //Device Profile
    private By  deviceRoleSelect = By.xpath("//*[@role='listbox']//*[text()='%Name%']");

//Device Details
    private By deviceDetails = By.xpath("//div[@class='EM2M-card-widget-left-right-container ng-star-inserted']//div[contains(text(),'%Name%')]");

//Update Device Details
    private By updateIMEI = By.xpath("//input[@id='mat-input-2']");
    private By updateExternalId = By.xpath("//input[@id='mat-input-5']");
    private By updateSIMId = By.xpath("//input[@id='mat-input-7']");
    private By updateDealerBoxId = By.xpath("//input[@id='mat-input-10']");
    private By updateBtn = By.xpath("//span[@class='mat-button-wrapper' and contains(text(),'Update')]");
    private By updatePopUp = By.xpath("//span[contains(text(),'Device successfully updated')]");



//Getters


    public By getToggleFilterBtn() {return toggleFilterBtn;}

    public By getRefreshResultsBtn() {return refreshResultsBtn;}

    public By getSearchBtn() {return searchBtn;}

    public By getSearchBar() {return searchBar;}

    public By getAdvanceQueryBuilderBtn() {return advanceQueryBuilderBtn;}

    public By getChangeViewBtn() {return changeViewBtn;}

    public By getCreateDeviceBtn() {return createDeviceBtn;}

    public By getActionsDropDown() {return actionsDropDown;}

    public By getSubOrganizationRadioBtn() {return subOrganizationRadioBtn;}

    public By getArchivedRadioBtn() {return archivedRadioBtn;}

    public By getSelectAllCheckBox() {return selectAllCheckBox;}

    public By getDeviceID() {return deviceID;}

    public By getSimId() {return SimId;}

    public By getProductCode() {return productCode;}

    public By getSerialNumber() {return serialNumber;}

    public By getOrganization() {return organization;}

    public By getType() {return type;}

    public By getStatus() {return status;}

    public By getCareer() {return career;}

    public By getDeviceProfileDropDown() {return deviceProfileDropDown;}

    public By getProvisionAirtimeCheckBox() {return provisionAirtimeCheckBox;}

    public By getSerialNumberTextBox() {return serialNumberTextBox;}

    public By getDeviceIdTextBox() {return deviceIdTextBox;}

    public By getIMEI_NumberTextBox() {return IMEI_NumberTextBox;}

    public By getESN_NumberTextBox() {return ESN_NumberTextBox;}

    public By getMEID_NumberTextBox() {return MEID_NumberTextBox;}

    public By getExternalIdTextBox() {return ExternalIdTextBox;}

    public By getSimIdTextBox() {return SimIdTextBox;}

    public By getIMSI_NumberTextBox() {return IMSI_NumberTextBox;}

    public By getPhoneNumberTextBox() {return PhoneNumberTextBox;}

    public By getBoxIdTextBox() {return BoxIdTextBox;}

    public By getTagsTextBox() {return TagsTextBox;}

    public By getCancelBtn() {return cancelBtn;}

    public By getCreateDeviceConfirmBtn() {return createDeviceConfirmBtn;}

    public By getDeviceRoleSelect() {return deviceRoleSelect;}

    public By getDeviceDetails() {return deviceDetails;}

    public By getTableDatadeviceId() {return tableDatadeviceId;}

    public By getGenaricTableDatadeviceId() {return genaricTableDatadeviceId;}

    public By getEditDetails() {return editDetails;}

    public By getUpdateIMEI() {return updateIMEI;}

    public By getUpdateExternalId() {return updateExternalId;}

    public By getUpdateSIMId() {return updateSIMId;}

    public By getUpdateDealerBoxId() {return updateDealerBoxId;}

    public By getUpdateBtn() {return updateBtn;}

    public By getUpdatePopUp() {return updatePopUp;}

    public By getViewActionsBtn() {return viewActionsBtn;}

    public By getTransferDeviceBtn() {return transferDeviceBtn;}

    public By getTrasferTargetOrg() {return trasferTargetOrg;}

    public By getOrgSearcher() {return orgSearcher;}

    public By getGenericOrgPicker() {return genericOrgPicker;}

    public By getOkBtn() {return okBtn;}

    public By getTransferBtn() {return transferBtn;}

    public By getConfirmationYesBtn() {return confirmationYesBtn;}

    public By getTransferPopup() {return transferPopup;}

    public By getDeviceMissingPopup() {return deviceMissingPopup;}

    public By getSubOrgText() {return subOrgText;}

    //Methods
    public void verifyDeviceIsCreatedByHeader(String deviceId) {
//       if($(By.xpath(getFinalXpath(header.getThrirdPlace(),deviceId)))
//               .waitUntil(Condition.visible, ApplicationConstants.WAIT_NORMAL).isDisplayed()){
//           logger.info("DeviceId is shown in Header");
//       } else {
//           logger.error("DeviceId is not shown in Header :: May be Device is not created");
//       }
    }

}
