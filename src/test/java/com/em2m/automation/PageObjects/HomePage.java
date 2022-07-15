package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Selenide;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.apache.log4j.Logger;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    GeneralHelper helper = new GeneralHelper();
    Logger logger = Logger.getLogger(HomePage.class);

    public void clickOnTile(String tileName){
       String xpath = helper.updatedXPATH(ConfigProperties.getProperty("AllTiles"),tileName,"%Name%" );
        SelenideUtil.click(xpath, TimeConstant.WAIT_MEDIUM);
    }

    public void checkOrganizationNameOnHomePage(String orgNameOnHome) {
        String xpath = helper.updatedXPATH(ConfigProperties.getProperty("organizationNameText"),orgNameOnHome,"%Name%");
        if(SelenideUtil.isVisible(xpath,TimeConstant.WAIT_NORMAL)) {
            Selenide.sleep(2000);
            logger.info("user is on selected organization Page" + orgNameOnHome);
        }
        else {
            logger.error("user is not on selected organization Page");
            Assert.fail();
        }
    }



}
