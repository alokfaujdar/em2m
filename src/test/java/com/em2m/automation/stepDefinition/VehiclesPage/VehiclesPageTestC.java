package com.em2m.automation.stepDefinition.VehiclesPage;

import com.em2m.automation.base.TestBase;
import com.em2m.automation.stepDefinition.loginPage.LoginPageTestC;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;


public class VehiclesPageTestC extends TestBase {
    private final static Logger logger = Logger.getLogger(LoginPageTestC.class);
    @Given("After login user is on vehicles page")
    public void afterLoginUserIsAlreadyOnVehiclesPage() {
    }

    @Then("User clicks on global search button")
    public void userClicksOnGlobalSearchButton() {
      }

    @And("User selects for an organization {string}")
    public void userSelectsForAnOrganization(String organization) throws InterruptedException {
    }

    @Given("verify User is on selected organization description {string} home page")
    public void verifyUserIsOnSelectedOrganizationHomePage(String orgDescription) {

     }

    @Then("User navigates to selected organization vehicle page")
    public void userNavigatesToSelectedOrganizationVehiclePage() {
    }

    @Then("User removes vehicle inventory filter and picks a vehicle device that does not have a VIN")
    public void userRemovesVehicleInventoryFilterAndPicksAVehicleDeviceThatDoesNotHaveAVIN() {
       }

    @Then("verify that selected device have a VIN or not")
    public void verifyThatSelectedDeviceHaveAVINOrNot() {
    }

    @Then("User clicks on the install device icon")
    public void userClicksOnTheInstallDeviceIcon() {
    }

    @Given("Verify user is on {string} page to provide VIN")
    public void verifyUserIsOnPageToProvideVIN(String setting) {
    }
    @Then("click on next button and wait till listening got completed")
    public void clickOnNextButtonAndWaitTillListeningGotCompleted() {
      }

    @AfterStep("@VehiclesPage")
    public void takeScreenShotOnFail(Scenario scenario){
      }

    @Then("User removes vehicle inventory filter from search text box")
    public void userRemovesVehicleInventoryFilterFromSearchBox() {
    }

    @Then("select the searched device from the table and will check whether the device is installed or not")
    public void selectTheSearchedDeviceFromTheTableAndWillCheckWhetherTheDeviceIsInstalledOrNot() {
    }
}

