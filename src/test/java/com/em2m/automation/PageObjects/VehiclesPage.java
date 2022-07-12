package com.em2m.automation.PageObjects;

import org.openqa.selenium.By;

public class VehiclesPage {

// Vehicle Page Element Locators

    public By toggleFilterBtn = By.xpath("//*[@class='mat-tooltip-trigger mdl-button mdl-js-button mdl-js-ripple-effect ng-star-inserted mdl-button--primary']");
    public By refreshResultsBtn = By.xpath("//*[@class='mat-tooltip-trigger mdl-button mdl-js-button mdl-js-ripple-effect ng-star-inserted']");
    public By totalResultsBtn = By.xpath("//span[contains(text(),'Total Results')]");
    public By suborganizationChkBox = By.xpath("//span[contains(text(),' Include sub-organizations ')]");
    public By archivedChkBox = By.xpath("//span[contains(text(),' Include archived')]");
    public By searchBox = By.xpath("//div[@class='mdl-cell mdl-cell--12-col mdl-card search-wrapper']//ul/li[2]");
    public By changeViewBtn = By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger mat-menu-trigger view-button mat-icon-button mat-button-base ng-star-inserted']");
    public By mapBtn = By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger mat-icon-button mat-button-base ng-star-inserted view-active']");
    public By tableBtn = By.xpath("//span[@class='mat-button-wrapper']/i[@class='fa fa-th-list fa-lg']");
    public By galleryBtn = By.xpath("//span[@class='mat-button-wrapper']/i[@class='fa fa-th-large fa-lg']");
    public By vehiclesSortBtn = By.xpath("//i[@class='fa sort-icon fa-sort-amount-up']");
    public By vehicleInventoryText = By.xpath("//li[@class='search-constraint ng-star-inserted']/span/span");
    public By vehicleInventoryDeleteBtn = By.xpath("//button[@class='mdl-chip__action']/i[text()='cancel']");
    public By nameeditTextfield = By.xpath("//input[@id='mat-input-189']");
    public By stockbreederTextField = By.xpath("//input[@id='mat-input-190']");
    public By firstVehicleLink = By.xpath("//div[@class='table-content scrollable']/div[1]");
    public By editVehicleBtn = By.xpath("//span[@class='mat-button-wrapper']/i[contains(text(),'edit')]");
    public By alertVehicleBtn = By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger mat-icon-button center-content mat-button-base ng-star-inserted']");
    public By firstdevicewithoutVINSelect = By.xpath("//div[@class='table-content scrollable']/div");
    public By installDeviceBtn = By.xpath("//button[@class='mat-focus-indicator mat-tooltip-trigger mat-icon-button center-content mat-button-base ng-star-inserted']");
    public By listBox= By.xpath("//*[@role='listbox']");
    public By devicelistBox = By.xpath("//div[@class='table-content scrollable']");
    public By dropdownlistitem = By.xpath("//*[@role='option']/span");
    public By comboBox = By.xpath("//*[@role='combobox' and @tabindex='0']");

    public By tablistItems = By.xpath("//div[@class='mat-tab-links']/a[text()=' %Name% ']");

    public By vininputtextBox = By.xpath("//surveyor-forms[@class='ng-star-inserted'][2]//div[1]//surveyor-vin-field//input");

    public By colorDialogBox = By.xpath("//div[@class='mdl-dialog show-modal animated slideInRight']");
    public By vehiclecolorListBox = By.xpath("//ul[@class='ng-star-inserted']");
    public By colorList = By.xpath("//ul[@class='ng-star-inserted']//div[@class='color-title']//following-sibling::ul");
    public By okBtn = By.xpath("//div[@class='mdl-dialog__actions']/button[1]");

    public By nextBtn = By.xpath("//div[@class='button-container ng-star-inserted']/button[1]");

    public By submitVerificationBtn = By.xpath("//span[contains(text(),'Submit without verification')]/parent::button//span[2]");

    public By selectColorBox = By.xpath("//surveyor-picker-field[@class='ng-star-inserted']//input");

    public By cancelVerificationBtn = By.xpath("//span[contains(text(),'Cancel Verification')]/parent::button");

    //Getters Method
    public By getToggleFilterBtn() {return toggleFilterBtn;}

    public By getRefreshResultsBtn() {return refreshResultsBtn;}

    public By getTotalResultsBtn() {return totalResultsBtn;}

    public By getSuborganizationChkBox() {return suborganizationChkBox;}

    public By getArchivedChkBox() {return archivedChkBox;}

    public By getSearchBox() {return searchBox;}

    public By getChangeViewBtn() {return changeViewBtn;}

    public By getMapBtn() {return mapBtn;}

    public By getTableBtn() {return tableBtn;}

    public By getGalleryBtn() {return galleryBtn;}

    public By getVehiclesSortBtn() {return vehiclesSortBtn;}

    public By getSubmitVerificationBtn() {return submitVerificationBtn;}

    public By getVehicleInventoryText() {return vehicleInventoryText;}

    public By getNameeditTextfield() {return nameeditTextfield;}

    public By getStockbreederTextField() {return stockbreederTextField;}

    public By getFirstVehicleLink() {return firstVehicleLink;}

    public By getEditVehicleBtn() {return editVehicleBtn;}

    public By getAlertVehicleBtn() {return alertVehicleBtn;}

    public By getVehicleInventoryDeleteBtn() {return vehicleInventoryDeleteBtn;}

    public By getFirstdevicewithoutVINSelect() {return firstdevicewithoutVINSelect;}

    public By getInstallDeviceBtn() {return installDeviceBtn;}

    public By getListBox() {return listBox;}

    public By getDropdownlistitem() {return dropdownlistitem;}

    public By getComboBox() {return comboBox;}

    public By getDevicelistBox() {return devicelistBox;}

    public By getTablistItems() {return tablistItems;}

    public By getVininputtextBox() {return vininputtextBox;}

    public By getVehiclecolorListBox() {return vehiclecolorListBox;}

    public By getColorList() {return colorList;}

    public By getOkBtn() {return okBtn;}

    public By getNextBtn() {return nextBtn;}

    public By getSelectColorBox() {return selectColorBox;}

    public By getColorDialogBox() {return colorDialogBox;}

    public By getCancelVerificationBtn() {return cancelVerificationBtn;}
}
