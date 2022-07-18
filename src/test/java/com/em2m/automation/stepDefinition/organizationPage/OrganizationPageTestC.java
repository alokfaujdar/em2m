package com.em2m.automation.stepDefinition.organizationPage;

import com.em2m.automation.PageObjects.OrganizationPage;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.CommonMethods;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class OrganizationPageTestC extends TestBase {

    private String organizationTemplate, organizationCustomerName, organizationDescription, organizationTimeZone,
                   organizationType, organizationAdminFirstName, organizationAdminLastName, organizationAdminEmail, organizationAdminPhoneNumber;
    private List<String> organizationProducts;
    private String updateName, updateDescription;

    public static OrganizationPage organizationPage = page(OrganizationPage.class);
    public static GeneralHelper helper = new GeneralHelper();
    CommonMethods commonMethods = new CommonMethods();


    @When("Click on Create Organization button")
    public void clickOnCreateOrganizationButton() {
        organizationPage.clickCreateOrganization();
       }

    @Then("Select the {string} organization")
    public void selectTheOrganizationTemplate(String template) {
        this.organizationTemplate = template;
        organizationPage.selectTheOrganizationTemplate(template);
    }

    @Then("Click next")
    public void clickNext() {
        organizationPage.clickNext();
    }

    @Then("Select the following products")
    public void selectTheFollowingProducts(DataTable productsTable) {
        organizationProducts = productsTable.asList();
        organizationPage.checkProducts(organizationProducts);
     }

    @Then("Enter description")
    public void enterDescription(DataTable descriptionTable) {
        List<Map<String, String>> descriptionMaps = descriptionTable.asMaps();
        organizationCustomerName = descriptionMaps.get(0).get("Customer Name");
        organizationDescription = descriptionMaps.get(0).get("Description");
        organizationTimeZone = descriptionMaps.get(0).get("Time Zone");
        organizationPage.addDescription(organizationCustomerName,organizationDescription,organizationTimeZone);
        if(organizationTemplate.equals("Basic Organization")){
            organizationType = descriptionMaps.get(0).get("Type");
            organizationPage.selectType(organizationType);
        }
      }

    @Then("Check on create organization with an administrator account")
    public void CheckOnCreateOrganizationWithAnAdministratorAccount() {
        SelenideUtil.checkCheckBox(ConfigProperties.getProperty("chbx_createAdminAccount"));
    }

    @Then("Enter first name {string}")
    public void enterFirstName(String firstName) {
        organizationAdminFirstName = firstName;
        organizationPage.setAdminFirstName(firstName);
     }

    @Then("Enter last name {string}")
    public void enterLastName(String lastName) {
        organizationAdminLastName = lastName;
        organizationPage.setAdminLatsName(lastName);
       }

    @Then("Enter unique email")
    public void enterUniqueEmail() {
        organizationAdminEmail= helper.getRandomAlphaNumericString(7)+"@gmail.com";
        organizationPage.setAdminEmail(organizationAdminEmail);
       }

    @Then("Enter phone number")
    public void enterPhoneNumber() {
        organizationAdminPhoneNumber = "1234567892";
        organizationPage.setAdminPhoneNo(organizationAdminPhoneNumber);
    }

    @Then("Verify preview")
    public void verifyPreview() {
        organizationPage.verifyPreview(organizationTemplate,organizationProducts,organizationAdminFirstName,organizationAdminLastName,
                organizationAdminEmail,organizationAdminPhoneNumber,organizationDescription,organizationCustomerName,organizationTimeZone,organizationType);
     }

    @Then("Click complete")
    public void clickComplete() {
        organizationPage.clickComplete();
    }

    @Then("Verify popup {string}")
    public void verifyPopup(String expectedMessage) {
        commonMethods.verifyPopUp(ConfigProperties.getProperty("popup_createUpdateAlert"),expectedMessage);
    }

    @When("Select Row {string} and Column {string} from organization table grid")
    public void selectRowAndColumnFromOrganizationTableGrid(String rowNumber, String columnNumber) {
        commonMethods.selectFromTableGrid("1","2");

    }

    @Then("Update name to random name")
    public void updateNameToRandomName() {
        updateName="Demo Name"+helper.getRandomAlphaNumericString(5);
        SelenideUtil.isVisible(ConfigProperties.getProperty("btn_edit"), TimeConstant.WAIT_MEDIUM);
        organizationPage.setNameInSettings(updateName);
     }

    @Then("Click RENAME ORGANIZATION button")
    public void clickRENAMEORGANIZATIONButton() {
        organizationPage.clickRenameOrganization();
     }

    @Then("Update description to random description")
    public void updateDescriptionToRandomDescription() {
        updateDescription="Demo Description"+helper.getRandomAlphaNumericString(5);
        organizationPage.setDescriptionInSettings(updateDescription);
     }

    @Then("Click {string} UPDATE button")
    public void clickUPDATEButton(String section) {
        organizationPage.clickUpdateInSettings(section);
     }

    @Then("verify the updated name and description")
    public void verifyTheUpdatedNameAndDescription() {
        organizationPage.verifyDetailsUpdatSucessfully(updateName,updateDescription);
     }

    @Then("Verify PopUp message appear")
    public void verifyPopUpMessageAppear() {
        organizationPage.checkPopUpAppears();
    }

    @Then("Verify PopUp message disappear")
    public void verifyPopUpMessageDisappear() {
        organizationPage.checkPopUpDisappears();
    }

    @AfterStep("@OrganizationPage")
    public void takeScreenShotOnFail(Scenario scenario){
    }

    @After("@OrganizationPage")
    public void closeTheBrowser(){
    }


}
