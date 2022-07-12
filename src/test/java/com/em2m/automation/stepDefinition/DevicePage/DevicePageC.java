package com.em2m.automation.stepDefinition.DevicePage;

import com.em2m.automation.base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DevicePageC extends TestBase {


    @Given("click on create device")
    public void clickOnCreateDevice() {
    }

    @Then("Fill the following fields and click Create Device button")
    public void fillTheFollowingFieldsAndClickCreateDeviceButton(DataTable dataTable) {
    }

    @Then("Click on Create Button")
    public void clickOnCreateButton() {
    }


    @Then("Verify the new Device is created with DeviceId {string}")
    public void verifyTheNewDeviceIsCreated(String DeviceId) {

    }


    @Then("Verify the following details on Device tab")
    public void verifyTheFollowingDetailsOnDeviceTab(DataTable dataTable) {

    }

    @Given("Search for Device with DeviceId {string} in search text box")
    public void searchForDeviceWithDeviceIdInSearchTextBox(String DeviceId) {
  }

    @Then("Open on the Device with DeviceId {string} on search result")
    public void openOnTheDeviceWithDeviceIdOnSearchResult(String DeviceId) {

    }

    @Then("Click on edit button")
    public void clickOnEditButton() {
    }

    @Then("Update the following details")
    public void updateTheFollowingDetails(DataTable dataTable) {
          }

    @Then("Click on update button")
    public void click_on_update_button() {
    }

    @Then("Verify Device updated pop-up")
    public void verifyDeviceUpdatedPopUp() {
    }

    @Then("click on View Actions Button")
    public void clickOnViewActionsButton() {
    }

    @Then("click on Transfer Device Button")
    public void clickOnTransferDeviceButton() {

    }

    @Then("Select {string} as Target Organization")
    public void selectTargetOrganization(String targetOrganization) {

    }

    @Then("Click on Transfer Button and click Yes to confirm")
    public void clickOnTransferButtonAndClickYesToConfirm() {
    }

    @Then("Verify By Device Transfer PopUp")
    public void verifyByDeviceTransferPopUp() {
    }

    @Then("Verify By PopUp as Device is missing")
    public void verifyByPopUpAsDeviceIsMissing() {
    }

    @AfterStep("@DevicesPage")
    public void takeScreenShotOnFail(Scenario scenario){
    }

    @After("@DevicesPage")
    public void closeTheBrowser(){
    }


}
