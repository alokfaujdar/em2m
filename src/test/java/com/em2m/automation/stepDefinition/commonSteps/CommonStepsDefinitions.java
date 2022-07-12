package com.em2m.automation.stepDefinition.commonSteps;

import com.em2m.automation.PageObjects.Header;
import com.em2m.automation.PageObjects.HomePage;
import com.em2m.automation.PageObjects.LoginPage;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.CommonMethods;
import com.em2m.automation.utility.GeneralHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.page;

public class CommonStepsDefinitions extends TestBase {

    public static LoginPage loginPage;
    public static Header header;
    public static WebDriver webDriver;
    public static HomePage homePage;


    @Given("Launch the URL do the necessary initializations")
    public void launchTheURLDoTheNecessaryInitializationsAndLogin() {
        logger.info("launching the URL");
        launchUrl();
        loginPage = page(LoginPage.class);
        webDriver = getWebDriver();
        header = page(Header.class);
        homePage = page(HomePage.class);
    }

    @And("User attempt to login")
    public void userLoginToApplication() {
        Assert.assertTrue(loginPage.logIn());
    }

    @Given("User has successfully logged In")
    public void userHasSuccessfullyLoggedIn() {

    }

    @Then("Click on the logout button and close the browser")
    public void ClickOnTheLogoutButtonAndCloseTheBrowser() {

    }

    @Then("Select the card named {string} then verify the page is loaded with name {string}")
    public void selectTheCardNamed(String cardName, String pageName) {
        homePage.clickOnCard(cardName);
        CommonMethods.checkPageLoadedByHeader(pageName);
    }

    @Then("Logout")
    public void logout() {
        header.logOut();
        closeTheWindow();
    }


}
