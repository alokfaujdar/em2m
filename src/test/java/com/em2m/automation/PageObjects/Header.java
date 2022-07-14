package com.em2m.automation.PageObjects;

import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;


public class Header extends TestBase {
    public static GeneralHelper helper = new GeneralHelper();



    public void clickRoot(){
        logger.info("Clicking on Root Button On Header to navigating to Root Page");
        SelenideUtil.click(ConfigProperties.getProperty("rootBtn"), TimeConstant.WAIT_MEDIUM);
    }

    public void clickHamburger(){
        logger.info("Clicking on hamburger button");
        SelenideUtil.click(ConfigProperties.getProperty("hamburgerButton"));
    }

    public void clickDropDownButton()
    {
        SelenideUtil.click(ConfigProperties.getProperty("dropDown"));
    }

    public void clickLogoutButton(){
        SelenideUtil.click(ConfigProperties.getProperty("logOutBtn"), TimeConstant.WAIT_NORMAL);
    }

    public void logOut(){
        GeneralHelper.pressEscape(webDriver);
        clickDropDownButton();
        clickLogoutButton();
    }


}
