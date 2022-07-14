package com.em2m.automation.stepDefinition.loginPage;

import com.em2m.automation.PageObjects.Header;
import com.em2m.automation.PageObjects.LoginPage;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;


public class LoginPageTestC extends TestBase {

    LoginPage loginPage = page(LoginPage.class);
    Header header = page(Header.class);
    public static WebDriver webDriver = getWebDriver();

    @Then("Verify User is on login page")
    public void userIsOnLoginPageToAttemptLogin() {
        logger.info("Verified the page is  loaded");
        Assert.assertTrue(loginPage.verifyLoginPageIsLoaded());
    }


    @When("We are on login page and we use invalid username and password for login")
    public void weAreOnLoginPageAndWeUseInvalidUsernameAndPasswordForLogin(DataTable table) {
        logger.info("trying to login with invalid credentials");
        List<Map<String, String>> lstData = table.asMaps();
           String userName = lstData.get(0).get("username");
           String password = lstData.get(0).get("password");
            Assert.assertTrue(loginPage.logIn(userName, password));
    }

    @When("We are on login page and we use valid username and password for login")
    public void weAreOnLoginPageAndWeUseValidUsernameAndPasswordForLogin(DataTable table) {
        logger.info("trying to login with valid credentials");
        List<Map<String, String>> lstData = table.asMaps();
        String userName = lstData.get(0).get("username");
        String password = lstData.get(0).get("password");
        loginPage.logIn(userName, password);
    }

    @Then("Verify the login error message {string}")
    public void verifyTheLoginErrorMessage(String errorMessage){
        logger.info("verifying the error message");
        Assert.assertTrue("Error Message for Invalid Credentials not occur", loginPage.verifyErrorMessage());
        Assert.assertTrue(errorMessage.equals(SelenideUtil.getText(ConfigProperties.getProperty("msg_loginError"))));
    }

    @Then("Verify the user is successfully logged in")
    public void verifyTheSuccessfulLoginByCheckingTheVisibilityOfHomePageHeader() {
        logger.info("verifying the user is successfully login");
        Assert.assertTrue(
                (SelenideUtil.isVisible(ConfigProperties.getProperty("homePageHeader"), TimeConstant.WAIT_HIGH))
                      && (SelenideUtil.isVisible(ConfigProperties.getProperty("homePageHeader"),TimeConstant.WAIT_HIGH))
        );
   }

   @AfterStep("@LoginPage")
   public void takeScreenshotOnFail(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(GeneralHelper.getByteScreenshot(), "image/png", "screenshot Name");
        }
    }




//    @After("@LoginPage")
//    public void closeTheBrowser(){
//        closeTheWindow();
//    }

}

