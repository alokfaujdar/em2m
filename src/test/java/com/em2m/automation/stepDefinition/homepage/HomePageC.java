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


    @When("User is navigating to the root page")
    public void userIsOnTheHomePage() {
        header.clickRoot();
    }

    @Then("Verify the below tabs are visible")
    public void verifyTheBelowTabsAreVisible(DataTable dataTable) {
        List<String> cards = dataTable.asList();
        List<String> elementsPath = helper.updatedXPATH(ConfigProperties.XPATH.getProperty("allTabElements"),cards,"%Name%");
        Assert.assertTrue(CommonMethods.checkVisibilityOfMultipleElement(elementsPath, true));
    }

    @Given("Verify the below cards are visible")
    public void verifyTheBelowCardsAreVisible(DataTable dataTable) {
       List<String> cards = dataTable.asList();
       List<String> elementsPath = helper.updatedXPATH(ConfigProperties.XPATH.getProperty("AllTiles"),cards,"%Name%");
       Assert.assertTrue(CommonMethods.checkVisibilityOfMultipleElement(elementsPath, true));

    }

    @And("Click on hamburger button")
    public void clickOnHamburgerButton() {
        header.clickHamburger();
    }

    @Then("Verify the hamburger elements visibility")
    public void verifyTheHamburgerElementsVisibility(DataTable dataTable) {
            List<String> cards = dataTable.asList();
            List<String> elementsPath = helper.updatedXPATH(ConfigProperties.XPATH.getProperty("hamburgerElelments"),cards,"%Replaceable%");
            Assert.assertTrue(CommonMethods.checkVisibilityOfMultipleElement(elementsPath, true));

    }


    @After("@HomePage")
    public void closeTheBrowser(){

    }

    @AfterStep("@HomePage")
    public void takeScreenshotOnFail(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(GeneralHelper.getByteScreenshot(), "image/png", "screenshot Name");
        }
    }



}