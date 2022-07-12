package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class OrganizationPage
{
    private final Logger logger = Logger.getLogger(OrganizationPage.class);

    //create organization pop up
    private final By btn_createOrganization=By.xpath("//span[contains(text(),'Create Organization')]");
    private final By btn_next=By.xpath("//span[contains(text(),'NEXT')]");

    private final By template_MarineDemoDealership=By.xpath("//h5[contains(text(),'Marine Demo Dealership')]");
    private final By template_AutoDemoDealership=By.xpath("//h5[contains(text(),'Auto Demo Dealership')]");
    private final By template_StandardDealership=By.xpath("//h5[contains(text(),'Standard Dealership')]");
    private final By template_basicOrganization=By.xpath("//h5[contains(text(),'Basic Organization')]");

    private final By chbx_products=By.xpath("//div[contains(text(),'Products')]/../../../..//span[@class='mat-checkbox-label']");

    private final By txtfld_customerName=By.id("name");
    private final By textArea_description=By.id("description");
    private final By txtfld_timeZone=By.id("timeZone");
    private final By txtfld_type=By.xpath("//*[@role='combobox']//span[starts-with(@class,'mat-select-placeholder')]");

    private final By chbx_createAdminAccount=By.name("includeRole");
    private final By txt_adminFirstName=By.id("firstName");
    private final By txt_adminLastName=By.id("lastName");
    private final By txt_adminEmail=By.id("email");
    private final By txt_adminPhoneNo=By.id("phoneNumber");

    private final By pnl_templateReview=By.xpath("(//h5[contains(text(),'Template')]/../..//div)[2]");
    private final By pnl_organizationDetails=By.xpath("(//h5[contains(text(),'Organization Details')]/../..//div)[2]");
    private final By pnl_products=By.xpath("(//h5[contains(text(),'Products')]/../..//div)[2]");
    private final By pnl_administratorAccount=By.xpath("(//h5[contains(text(),'Administrator Account')]/../..//div)[2]");

    private final By btn_complete=By.xpath("//span[contains(text(),'COMPLETE')]");

    //organization grid
    private final By row_firstOrganization=By.xpath("//tbody//tr[1]");

    //settings
    private final By btn_edit=By.xpath("//i[contains(text(),'edit')]");
    private final By txt_name=By.xpath("//input[@id='name']");
    private final By txt_description=By.xpath("//textarea[contains(@id,'mat-input')]");
    private final By btn_renameOrganization=By.xpath("//span[contains(text(),'Rename Organization')]");
    private final By popup_createUpdateAlert=By.xpath("//div[@class='cdk-overlay-container']//simple-snack-bar");


    public void clickCreateOrganization()
    {
        $(btn_createOrganization).click();
    }


    public void clickNext()
    {
        $(btn_next).click();
    }


    public void selectTemplate(String templateName)
    {
        SelenideElement templateLocator=null;
        switch(templateName.toLowerCase())
        {
            case "marine demo dealership" :
                templateLocator=$(template_MarineDemoDealership);
                break;
            case "Auto Demo Dealership" :
                templateLocator=$(template_AutoDemoDealership);
                break;
            case "standard dealership" :
                templateLocator=$(template_StandardDealership);
                break;
            case "basic organization" :
                templateLocator=$(template_basicOrganization);
                break;
            default:
                logger.assertLog(false,templateName +" is not a valid template name");
        }
        templateLocator.click();
    }


    public void checkProducts(List<String> products)
    {
        SelenideElement productCheckBox=null;
        for(String product:products)
        {
            productCheckBox=$$(chbx_products).filterBy(Condition.textCaseSensitive(product)).first();
            if(!productCheckBox.isSelected())
            {
               productCheckBox.click();
            }
        }
    }


    public void setCustomerName(String name)
    {
        $(txtfld_customerName).setValue(name);
    }


    public void setDescription(String description)
    {
        $(textArea_description).setValue(description);
    }


    public void selectType(String type)
    {
        $(txtfld_type).click();
        String typeLocator="//span[@class='mat-option-text' and contains(text(),'"+type+"')]";
        $(By.xpath(typeLocator)).click();
    }


    public void clickAddTimezone()
    {
        $(txtfld_timeZone).click();
    }


    public void checkCreateAdminAccount()
    {
        SelenideElement createAdminAccountCheckBox=$(chbx_createAdminAccount);
        if(!createAdminAccountCheckBox.isSelected())
        {
            createAdminAccountCheckBox.click();
        }
    }


    public void setAdminFirstName(String firstName)
    {
        $(txt_adminFirstName).setValue(firstName);
    }


    public void setAdminLatsName(String lastName)
    {
        $(txt_adminLastName).setValue(lastName);
    }


    public void setAdminEmail(String email)
    {
        $(txt_adminEmail).setValue(email);
    }


    public void setAdminPhoneNo(String phoneNo)
    {
        $(txt_adminPhoneNo).setValue(phoneNo);
    }


    public String getTemplatePreview()
    {
        return $(pnl_templateReview).getText();
    }


    public String getOrganizationDetailsPreview()
    {
        return $(pnl_organizationDetails).getText();
    }


    public String getProductsPreview()
    {
        return $(pnl_products).getText();
    }


    public String getAdministratorAccountPreview()
    {
        return $(pnl_administratorAccount).getText();
    }


    public void clickComplete() {
        $(btn_complete).click();
    }


    public void setNameInSettings(String name) {
        $(txt_name).setValue(name);
    }


    public void setDescriptionInSettings(String description) {
        $(txt_description).setValue(description);
    }


    public void clickUpdateInSettings(String sectionName) {
        $(By.xpath("//span[contains(text(),'"+sectionName+"')]/../..//span[contains(text(),'Update')]")).click();
    }


    public void clickRenameOrganization() {
        $(btn_renameOrganization).click();
    }


    public String getNameFromSettings() {
        return $(txt_name).getValue();
    }


    public String getDescriptionFromSettings() {
        return $(txt_description).getValue();
    }

    //----------------------------Getters--------------------------
    public By getNextButton()
    {
        return btn_next;
    }


    public By getCreateOrganizationButton()
    {
        return btn_createOrganization;
    }


    public By getFirstOrganization()
    {
        return row_firstOrganization;
    }


    public By getEditButton()
    {
        return btn_edit;
    }


    public By getRenameOrganizationButton()
    {
        return btn_renameOrganization;
    }


    public By getUpdateOrganizationButton(String sectionName)
    {
        return By.xpath("//span[contains(text(),'"+sectionName+"')]/../..//span[contains(text(),'Update')]");
    }


    public By getAlertPopUp()
    {
        return popup_createUpdateAlert;
    }


}
