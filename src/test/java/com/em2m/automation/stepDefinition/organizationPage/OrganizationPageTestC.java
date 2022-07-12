package com.em2m.automation.stepDefinition.organizationPage;

import com.em2m.automation.base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class OrganizationPageTestC extends TestBase {

    private String organizationTemplate;
    private List<String> organizationProducts;
    private String organizationCustomerName;
    private String organizationDescription;
    private String organizationTimeZone;
    private String organizationType;
    private String organizationAdminFirstName;
    private String organizationAdminLastName;
    private String organizationAdminEmail;
    private String organizationAdminPhoneNumber;

    private String updateName;
    private String updateDescription;

    @Given("User is organization page")
    public void userIsOrganizationPage() {
    }

    @When("Create organization button is clicked")
    public void createOrganizationButtonIsClicked() {
       }

    @Then("Select the {string} organization template")
    public void selectTheOrganizationTemplate(String template) {
    }

    @Then("Click next")
    public void clickNext() {
    }

    @Then("Select the following products")
    public void selectTheFollowingProducts(DataTable productsTable) {
     }

    @Then("Enter description")
    public void enterDescription(DataTable descriptionTable) {
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
