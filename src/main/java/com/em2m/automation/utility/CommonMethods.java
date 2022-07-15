package com.em2m.automation.utility;

import com.codeborne.selenide.Condition;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CommonMethods {

    public Logger logger = Logger.getLogger(CommonMethods.class);
    public static GeneralHelper helper = new GeneralHelper();

    public  boolean checkVisibilityOfMultipleElement(List<String> list, boolean shouldVisible){
        boolean flag;
        try {
            if (shouldVisible) {
                flag = list.stream().allMatch(e -> SelenideUtil.isVisible(e));
                return flag;
            } else {
                flag = list.stream().allMatch(e -> !SelenideUtil.isVisible(e));
                return flag;
            }
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("fail to check the visibility of the elements { "+list+" }");
        }
        return false;
    }

    public void checkPageLoadedByHeader(String pageName){
        String xpath = helper.updatedXPATH(ConfigProperties.getProperty("pageName"),pageName,"%Name%");
        Assert.assertTrue(SelenideUtil.isVisible(xpath, TimeConstant.WAIT_MEDIUM));
    }

    public void verifyPopUp(String locator, String expectedMessage){
        By byValue = SelenideUtil.getLocator(locator);
        try{
            String messageOnUI = $(byValue).shouldBe(Condition.visible).getText();
            if(messageOnUI.equals(expectedMessage)){
                logger.info("Message got verified ");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
