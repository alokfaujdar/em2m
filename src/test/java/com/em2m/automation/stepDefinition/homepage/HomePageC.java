package com.em2m.automation.stepDefinition.homepage;

import com.em2m.automation.PageObjects.Header;
import com.em2m.automation.PageObjects.HomePage;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.CommonMethods;
import com.em2m.automation.utility.GeneralHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;


public class HomePageC extends TestBase {

    public static Header header = page(Header.class);
    public static HomePage homePage = page(HomePage.class);
    public static GeneralHelper helper = new GeneralHelper();
    public static WebDriver webDriver = getWebDriver();
    CommonMethods commonMethods = new CommonMethods();


    @Then("User is navigating to the root page")
    public void userIsOnTheHomePage() {
        header.clickRoot();
    }

    @Then("Verify the below tabs are visible")
    public void verifyTheBelowTabsAreVisible(DataTable dataTable) {
        List<String> tabs = dataTable.asList();
        List<String> elementsPath = helper.updatedXPATH(ConfigProperties.getProperty("allTabElements"),tabs,"%Name%");
        Assert.assertTrue(commonMethods.checkVisibilityOfMultipleElement(elementsPath, true));
    }

    @Given("Verify the below tiles are visible")
    public void verifyTheBelowTilesAreVisible(DataTable dataTable) {
       List<String> tiles = dataTable.asList();
       List<String> elementsPath = helper.updatedXPATH(ConfigProperties.getProperty("AllTiles"),tiles,"%Name%");
       Assert.assertTrue(commonMethods.checkVisibilityOfMultipleElement(elementsPath, true));

    }

    @And("Click on hamburger button")
    public void clickOnHamburgerButton() {
        header.clickHamburger();
    }

    @Then("Verify the hamburger menu elements visibility")
    public void verifyTheHamburgerMenuElementsVisibility(DataTable dataTable) {
            List<String> menuElements = dataTable.asList();
            List<String> elementsPath = helper.updatedXPATH(ConfigProperties.getProperty("hamburgerElements"),menuElements,"%Name%");
            Assert.assertTrue(commonMethods.checkVisibilityOfMultipleElement(elementsPath, true));
    }

    @AfterStep("@HomePage")
    public void takeScreenshotOnFail(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(helper.getByteScreenshot(), "image/png", "screenshot Name");
        }
    }

    @After("@HomePage")
    public void closeTheBrowser(){}

}