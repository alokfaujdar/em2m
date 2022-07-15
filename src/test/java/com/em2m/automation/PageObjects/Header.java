package com.em2m.automation.PageObjects;

import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.junit.Assert;


public class Header extends TestBase {

    GeneralHelper helper = new GeneralHelper();

    public void clickRoot(){
        logger.info("Clicking on Root Button On Header to navigating to Root Page");
        SelenideUtil.click(ConfigProperties.getProperty("rootBtn"), TimeConstant.WAIT_NORMAL);
    }

    public void clickHamburger(){
        logger.info("Clicking on hamburger button");
        SelenideUtil.click(ConfigProperties.getProperty("hamburgerButton"));
    }

    public void selectMenuElement(String pName){
        logger.info("Navigating on workspace from menu");
        String pageLocator = helper.updatedXPATH(ConfigProperties.getProperty("hamburgerElements"),pName,"%Name%");
        if(SelenideUtil.isVisible(pageLocator)) {

            SelenideUtil.click(pageLocator);
        }
        else{
            logger.error("Workspace is not selected from menu");
        }
    }

    public void clickDropDownButton() {
        SelenideUtil.click(ConfigProperties.getProperty("dropDown"));
    }

    /*public void checkOrganizationNameOnHeader(String orgNameHeader) {
        String xpath = helper.updatedXPATH(ConfigProperties.getProperty("organizationNameText"),orgNameHeader,"%Name%");
        if(SelenideUtil.isVisible(xpath,TimeConstant.WAIT_NORMAL)) {
            logger.info("user is on selected organization Page" + orgNameHeader);
        }
        else {
            logger.error("user is not on selected organization Page");
            Assert.fail();
        }
    }*/

    public void clickLogoutButton(){
        SelenideUtil.click(ConfigProperties.getProperty("logOutBtn"), TimeConstant.WAIT_NORMAL);
    }

    public void logOut(){
        GeneralHelper.pressEscape(webDriver);
        clickDropDownButton();
        clickLogoutButton();
    }

    public void checkWorkspaceNameOnHeader(String pageHeaderName) {
        logger.info("Checking workspace name on header ");
        String pName =  helper.updatedXPATH(ConfigProperties.getProperty("pageName"),pageHeaderName,"%Name%");
        if(SelenideUtil.isVisible(pName,TimeConstant.WAIT_MEDIUM)){
            logger.info("user is on desired workspace");
        }
        else {
            logger.error("user is not on desired workspace");
            Assert.fail();
        }
    }


}
