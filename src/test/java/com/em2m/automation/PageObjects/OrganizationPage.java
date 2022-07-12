package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class OrganizationPage {

    GeneralHelper helper = new GeneralHelper();
    public static  TimeZone timeZoneHelper = page(TimeZone.class);


    public void clickCreateOrganization() {
        SelenideUtil.click(ConfigProperties.XPATH.getProperty("btn_createOrganization"), TimeConstant.WAIT_MEDIUM);
    }

    public void clickNext() {
        SelenideUtil.click(ConfigProperties.XPATH.getProperty("btn_next"));
    }

    public void selectTheOrganizationTemplate(String templateName) {
        String xpath = helper.updatedXPATH(ConfigProperties.XPATH.getProperty("template_GenericXpath"),templateName,"%templateName%");
        SelenideUtil.click(xpath);
    }

    public void checkProducts(List<String> products) {
        By locator = SelenideUtil.getLocator(ConfigProperties.XPATH.getProperty("chbx_products"));
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
        timeZoneHelper.selectTimeZone(timeZone);

    }

    public void setCustomerName(String name) {
        try{
            SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txtfld_customerName"),name);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setDescription(String description) {
        try{
            SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("textArea_description"),description);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void selectType(String type) {
        SelenideUtil.click(ConfigProperties.XPATH.getProperty("txtfld_type"));
        String typeLocator="//span[@class='mat-option-text' and contains(text(),'"+type+"')]";
        $(By.xpath(typeLocator)).click();
    }


    public void clickAddTimezone() {
        try{
            SelenideUtil.click(ConfigProperties.XPATH.getProperty("txtfld_timeZone"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public void checkCreateAdminAccount() {
        SelenideElement createAdminAccountCheckBox=$(ConfigProperties.XPATH.getProperty("chbx_createAdminAccount"));
        if(!createAdminAccountCheckBox.isSelected())
        {
            createAdminAccountCheckBox.click();
        }
    }


    public void setAdminFirstName(String firstName) {
        SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txt_adminFirstName"),firstName );
    }


    public void setAdminLatsName(String lastName) {
        SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txt_adminLastName"),lastName );
    }


    public void setAdminEmail(String email) {
        SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txt_adminEmail"),email );
    }


    public void setAdminPhoneNo(String phoneNo) {
        SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txt_adminPhoneNo"),phoneNo );
    }


    public String getTemplatePreview() {
        return SelenideUtil.getText(ConfigProperties.XPATH.getProperty("pnl_templateReview"));
    }


    public String getOrganizationDetailsPreview() {
        return SelenideUtil.getText(ConfigProperties.XPATH.getProperty("pnl_organizationDetails"));
    }


    public String getProductsPreview() {
        return SelenideUtil.getText(ConfigProperties.XPATH.getProperty("pnl_products"));
    }


    public String getAdministratorAccountPreview() {
        return SelenideUtil.getText(ConfigProperties.XPATH.getProperty("pnl_administratorAccount"));

    }


    public void clickComplete() {
        SelenideUtil.click(ConfigProperties.XPATH.getProperty("btn_complete"));
    }


    public void setNameInSettings(String name) {
        SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txt_name"),name );

    }


    public void setDescriptionInSettings(String description) {
        SelenideUtil.sendKeys(ConfigProperties.XPATH.getProperty("txt_description"),description );
    }


    public void clickUpdateInSettings(String sectionName) {
        $(By.xpath("//span[contains(text(),'"+sectionName+"')]/../..//span[contains(text(),'Update')]")).click();
    }


    public void clickRenameOrganization() {
        SelenideUtil.click(ConfigProperties.XPATH.getProperty("btn_renameOrganization"));
    }


    public String getNameFromSettings() {
        return SelenideUtil.getValue(ConfigProperties.XPATH.getProperty("txt_name"));
    }


    public String getDescriptionFromSettings() {
        return  SelenideUtil.getValue(ConfigProperties.XPATH.getProperty("txt_description"));
    }



}
