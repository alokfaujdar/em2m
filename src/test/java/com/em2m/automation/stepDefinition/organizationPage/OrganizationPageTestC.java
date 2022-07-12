package com.em2m.automation.stepDefinition.organizationPage;

import com.em2m.automation.PageObjects.OrganizationPage;
import com.em2m.automation.base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class OrganizationPageTestC extends TestBase {

    public static OrganizationPage organizationPage = page(OrganizationPage.class);

    @Given("User is organization page")
    public void userIsOrganizationPage() {
    }

    @When("Click on Create Organization button")
    public void clickOnCreateOrganizationButton() {
        organizationPage.clickCreateOrganization();
       }

    @Then("Select the {string} organization template")
    public void selectTheOrganizationTemplate(String template) {
        organizationPage.selectTheOrganizationTemplate(template);
    }

    @Then("Click next")
    public void clickNext() {
        organizationPage.clickNext();
    }

    @Then("Select the following products")
    public void selectTheFollowingProducts(DataTable productsTable) {
        List<String> productList = productsTable.asList();
        organizationPage.checkProducts(productList);
     }

    @Then("Enter description")
    public void enterDescription(DataTable descriptionTable) {
        List<Map<String, String>> descriptionMaps = descriptionTable.asMaps();
        organizationPage.addDescription(descriptionMaps.get(0).get("Customer Name"),descriptionMaps.get(0).get("Description"),descriptionMaps.get(0).get("Time Zone"));
      }

    @Then("Check on add administrator checkbox")
    public void checkOnAddAdministratorCheckbox() {
    }

    @Then("Enter first name {string}")
    public void enterFirstName(String firstName) {
     }

    @Then("Enter last name {string}")
    public void enterLastName(String lastName) {
       }

    @Then("Enter unique email")
    public void enterUniqueEmail() {
       }

    @Then("Enter phone number {string}")
    public void enterPhoneNumber(String phoneNumber) {
    }

    @Then("Verify preview")
    public void verifyPreview() {
     }

    @Then("Click complete")
    public void clickComplete() {
    }

    @Then("Verify popup {string}")
    public void verifyPopup(String message) {
    }

    @When("First organization is selected")
    public void firstOrganizationIsSelected() {
    }

    @Then("Update name to random name")
    public void updateNameToRandomName() {
     }

    @Then("Click RENAME ORGANIZATION button")
    public void clickRENAMEORGANIZATIONButton() {
     }

    @Then("Update description to random description")
    public void updateDescriptionToRandomDescription() {
     }

    @Then("Click {string} UPDATE button")
    public void clickUPDATEButton(String section) {
     }

    @Then("verify the updated name and description")
    public void verifyTheUpdatedNameAndDescription() {
     }

    @When("Check the visibility of create organization button")
    public void checkTheVisibilityOfCreateOrganizationButton() {
      }

    @AfterStep("@OrganizationPage")
    public void takeScreenShotOnFail(Scenario scenario){
     }

    @After("@OrganizationPage")
    public void closeTheBrowser(){
      }
}
