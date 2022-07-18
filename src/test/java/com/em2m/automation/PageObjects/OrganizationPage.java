package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class OrganizationPage {

    GeneralHelper helper = new GeneralHelper();
    public static TimeZone timeZoneHelper = page(TimeZone.class);
    Logger logger = Logger.getLogger(OrganizationPage.class);


    public void clickCreateOrganization() {
        SelenideUtil.click(ConfigProperties.getProperty("btn_createOrganization"), TimeConstant.WAIT_MEDIUM);
    }

    public void clickNext() {
        try {
            if ($(SelenideUtil.getLocator(ConfigProperties.getProperty("btn_next"))).getAttribute("disabled").equals("true")) {
                Assert.fail("Next Button Is Not Clickable");
            }
        } catch (NullPointerException e) {
            SelenideUtil.click(ConfigProperties.getProperty("btn_next"));
        }
    }

    public void selectTheOrganizationTemplate(String templateName) {
        String xpath = helper.updatedXPATH(ConfigProperties.getProperty("template_GenericXpath"),templateName,"%templateName%");
        SelenideUtil.click(xpath);
    }

    public void checkProducts(List<String> products) {
        By locator = SelenideUtil.getLocator(ConfigProperties.getProperty("chbx_products"));
        SelenideElement productCheckBox= null;
        for(String product:products)
        {
            productCheckBox=$$(locator).filterBy(Condition.textCaseSensitive(product)).first();
            if(!productCheckBox.isSelected())
            {
               productCheckBox.click();
            }
        }
    }

    public void addDescription(String name, String description, String timeZone){
        setCustomerName(name);
        setDescription(description);
        clickSelectTimeZone();
        timeZoneHelper.selectTimeZone(timeZone);

    }

    private void clickSelectTimeZone() {
        SelenideUtil.click(ConfigProperties.getProperty("txtfld_timeZone"));
    }

    public void setCustomerName(String name) {
        try{
            SelenideUtil.sendKeys(ConfigProperties.getProperty("txtfld_customerName"),name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setDescription(String description) {
        try{
            SelenideUtil.sendKeys(ConfigProperties.getProperty("textArea_description"),description);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectType(String type) {
        SelenideUtil.click(ConfigProperties.getProperty("txtfld_type"));
        String typeLocator="//span[@class='mat-option-text' and contains(text(),'"+type+"')]";
        $(By.xpath(typeLocator)).click();
    }

    public void clickAddTimezone() {
        try{
            SelenideUtil.click(ConfigProperties.getProperty("txtfld_timeZone"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkCreateAdminAccount() {
        SelenideElement createAdminAccountCheckBox=$(ConfigProperties.getProperty("chbx_createAdminAccount"));
        if(!createAdminAccountCheckBox.isSelected())
        {
            createAdminAccountCheckBox.click();
        }
    }

    public void setAdminFirstName(String firstName) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("txt_adminFirstName"),firstName );
    }

    public void setAdminLatsName(String lastName) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("txt_adminLastName"),lastName );
    }

    public void setAdminEmail(String email) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("txt_adminEmail"),email );
    }

    public void setAdminPhoneNo(String phoneNo) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("txt_adminPhoneNo"),phoneNo );
    }

    public void verifyPreview(String organization,List<String>organizationProducts, String adminFirstName, String adminLastName,
                              String adminEmail, String adminPhoneNumber, String description, String customerName, String timeZone, String organizationType){

        if(getTemplatePreview().contains(organization)) {
            logger.info(organization+" template got selected successfully");
        }
        else {
            logger.error(organization+" template not present in the preview");
        }

        if(organization.equals("Standard Dealership")) {
            for(String expectedProduct:organizationProducts)
            {
                if(getProductsPreview().contains(expectedProduct)) {
                    logger.info(organization+" products got selected successfully");
                }
                else {
                    logger.error(expectedProduct+" product not present in the preview");
                }
            }
            String adminAccountPreview=getAdministratorAccountPreview();
            if(adminAccountPreview.contains(adminFirstName)){
                logger.info("Admin first name " +adminFirstName+" got set successfully");
            }
            else {
                logger.error("Admin first name " +adminFirstName+" not present in the preview");
            }

            if(adminAccountPreview.contains(adminLastName)){
                logger.info("Admin last name " +adminLastName+" got set successfully");
            }
            else {
                logger.error("Admin last name " +adminLastName+" not present in the preview");
            }

            if(adminAccountPreview.contains(adminEmail)){
                logger.info("Admin email " +adminEmail+" got set successfully");
            }
            else {
                logger.error("Admin email " +adminEmail+" not present in the preview");
            }

            String phoneNumberInFormat=helper.getPhoneNumberInFormat(adminPhoneNumber);
            if(adminAccountPreview.contains(phoneNumberInFormat)) {
                logger.info("Admin phone number " +phoneNumberInFormat+" got set successfully");
            }
            else {
                logger.error("Admin phone number " +phoneNumberInFormat+" not present in the preview");
            }
        }

        String detailPreview=getOrganizationDetailsPreview();
        if(detailPreview.contains(description)){
            logger.info("Organization description " +description+" got set successfully");
        }
        else {
            logger.error("Organization description " +description+" not present in the preview");
        }

        if(detailPreview.contains(customerName)){
            logger.info("Organization customer name " +customerName+" got set successfully");
        }
        else {
            logger.error("Organization customer name " +customerName+" not present in the preview");
        }

        if(detailPreview.contains(timeZone)){
            logger.info("Organization timezone " +timeZone+" got set successfully");
        }
        else {
            logger.error("Organization timezone " +timeZone+" not present in the preview");
        }

        if(organization.equals("Basic Organization")) {
            if(getOrganizationDetailsPreview().contains(organizationType)||
                    getOrganizationDetailsPreview().contains(organizationType.toLowerCase())){
                logger.info("Organization type " +organizationType+" got set successfully");
            }
            else {
                logger.error("Organization type  " +organizationType+" not present in the preview");
            }
        }
    }

    public String getTemplatePreview() {
        return SelenideUtil.getText(ConfigProperties.getProperty("pnl_templateReview"));
    }

    public String getOrganizationDetailsPreview() {
        return SelenideUtil.getText(ConfigProperties.getProperty("pnl_organizationDetails"));
    }

    public String getProductsPreview() {
        return SelenideUtil.getText(ConfigProperties.getProperty("pnl_products"));
    }

    public String getAdministratorAccountPreview() {
        return SelenideUtil.getText(ConfigProperties.getProperty("pnl_administratorAccount"));

    }

    public void clickComplete() {
        SelenideUtil.click(ConfigProperties.getProperty("btn_complete"));
    }

    public void setNameInSettings(String name) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("txt_name"),name );

    }

    public void setDescriptionInSettings(String description) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("txt_description"),description );
    }

    public void clickUpdateInSettings(String sectionName) {
        $(By.xpath("//span[contains(text(),'"+sectionName+"')]/../..//span[contains(text(),'Update')]")).click();
    }

    public void clickRenameOrganization() {
        SelenideUtil.click(ConfigProperties.getProperty("btn_renameOrganization"));
    }

    public String getNameFromSettings() {
        return SelenideUtil.getValue(ConfigProperties.getProperty("txt_name"));
    }

    public String getDescriptionFromSettings() {
        return  SelenideUtil.getValue(ConfigProperties.getProperty("txt_description"));
    }

    public void checkPopUpAppears() {
        SelenideUtil.isVisible(ConfigProperties.getProperty("popup_createUpdateAlert"));
    }

    public void checkPopUpDisappears() {
        $(SelenideUtil.getLocator(ConfigProperties.getProperty("popup_createUpdateAlert"))).shouldBe(Condition.disappear, Duration.ofMillis(TimeConstant.WAIT_MEDIUM));
    }

    public void verifyDetailsUpdatSucessfully(String updateName,String updateDescription) {
        if(getNameFromSettings().equals(updateName)){
            logger.info("Organization name got updated successfully to: "+updateName);
        }
        else {
            logger.error("Failed to edit the organization's name");
        }
        if(getDescriptionFromSettings().equals(updateDescription)){
            logger.info("Organization description got updated successfully to: "+updateDescription);
        }
        else {
            logger.error("Failed to edit the organization's description");
        }
    }



}
