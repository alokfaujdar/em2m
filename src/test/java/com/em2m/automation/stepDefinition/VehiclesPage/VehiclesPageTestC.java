package com.em2m.automation.stepDefinition.VehiclesPage;

import com.em2m.automation.PageObjects.Header;
import com.em2m.automation.PageObjects.HomePage;
import com.em2m.automation.PageObjects.VehiclesPage;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.stepDefinition.loginPage.LoginPageTestC;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;


public class VehiclesPageTestC extends TestBase {
    private final static Logger logger = Logger.getLogger(LoginPageTestC.class);

    Header header = new Header();
    HomePage homePage = new HomePage();
    VehiclesPage vehiclesPage = new VehiclesPage();
    GeneralHelper helper = new GeneralHelper();

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

    @Given("Verify user is on setting tab to provide VIN")
    public void verifyUserIsOnSettingTabToProvideVIN() {
        logger.info("verify settings tab is visible or not to provide VIN");
        if(SelenideUtil.isVisible(ConfigProperties.getProperty("settingstab"),TimeConstant.WAIT_NORMAL)){
            logger.info("Settings tab is visible.");
            SelenideUtil.sendKeys(ConfigProperties.getProperty("vininputtextBox"),"1FTSX21R38ED56695",TimeConstant.WAIT_NORMAL);
            logger.info("VIN is provided in the text box");
        }

    }

    @Then("select the searched device from the list and will verify whether the device is installed or not")
    public void selectTheSearchedDeviceFromTheTableAndWillCheckWhetherTheDeviceIsInstalledOrNot() {
        vehiclesPage.selectSearchedDevice();
        if(SelenideUtil.isVisible(ConfigProperties.getProperty("installDeviceBtn"), TimeConstant.WAIT_NORMAL)){
            logger.info("Install Device Button is visible.....");
        }
        else {
            logger.error("Install Device Button is not visible.....Device is already installed into a vehicle.");
            Assert.fail();
        }
    }

    @Then("Click on next button and wait till listening got completed")
    public void clickOnNextButtonAndWaitTillListeningGotCompleted() {



    }


    @Then("User clicks on the install device icon")
    public void userClicksOnTheInstallDeviceIcon() {
        SelenideUtil.click(ConfigProperties.getProperty("installDeviceBtn"));
    }

    @AfterStep("@VehiclesPage")
    public void takeScreenShotOnFail(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(helper.getByteScreenshot(), "image/png", "screenshot Name");
        }
    }


}

