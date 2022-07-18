package com.em2m.automation.PageObjects;

import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.GeneralHelper;
import com.em2m.automation.utility.SelenideUtil;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class VehiclesPage {

    public Logger logger = Logger.getLogger(VehiclesPage.class);
    public GeneralHelper helper = new GeneralHelper();

    public void selectSearchedDevice() {
        logger.info("Selecting searched device to install from drop-down list ");
        if(SelenideUtil.isVisible(ConfigProperties.getProperty("firstdevicewithoutVINSelect"), TimeConstant.WAIT_NORMAL)){

            SelenideUtil.click(ConfigProperties.getProperty("firstdevicewithoutVINSelect"));
        }
        else {
            logger.error("searched device is not present");
            Assert.fail();
        }
    }


}
