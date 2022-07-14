package com.em2m.automation.PageObjects;

import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    GeneralHelper helper = new GeneralHelper();
    Logger logger = Logger.getLogger(HomePage.class);


    public void clickOnCard(String cardName){
       String xpath = helper.updatedXPATH(ConfigProperties.getProperty("AllTiles"),cardName,"%Name%" );
        SelenideUtil.click(xpath, TimeConstant.WAIT_MEDIUM);
    }




}
