package com.em2m.automation.PageObjects;


import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.apache.log4j.Logger;


public class DevicePage  {

    public Logger logger = Logger.getLogger(VehiclesPage.class);
    public GeneralHelper helper = new GeneralHelper();

    public void searchForText(String text) {
        SelenideUtil.sendKeys(ConfigProperties.getProperty("searchBar"),text, TimeConstant.WAIT_NORMAL);
        SelenideUtil.click(ConfigProperties.getProperty("searchiconBtn"));
    }





}
