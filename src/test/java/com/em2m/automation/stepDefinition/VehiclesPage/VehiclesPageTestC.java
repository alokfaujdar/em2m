package com.em2m.automation.stepDefinition.VehiclesPage;

import com.em2m.automation.PageObjects.Header;
import com.em2m.automation.PageObjects.HomePage;
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

    Header header = new Header();
    HomePage homePage = new HomePage();

    @Then("After login user is on {string} page")
    public void afterLoginUserIsAlreadyOnVehiclesPage(String pageNameHeader) {
        header.checkWorkspaceNameOnHeader(pageNameHeader);
    }

    @Given("verify User is on selected organization {string} home page")
    public void verifyUserIsOnSelectedOrganizationHomePage(String orgName) {
        homePage.checkOrganizationNameOnHomePage(orgName);
     }

    @Then("User navigates to organization {string} page")
    public void userNavigatesToOrganizationVehiclesPage(String workspaceName) {
        header.clickHamburger();
        header.selectMenuElement(workspaceName);

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


    @Then("select the searched device from the table and will check whether the device is installed or not")
    public void selectTheSearchedDeviceFromTheTableAndWillCheckWhetherTheDeviceIsInstalledOrNot() {


    }


    @AfterStep("@VehiclesPage")
    public void takeScreenShotOnFail(Scenario scenario){
    }


}

