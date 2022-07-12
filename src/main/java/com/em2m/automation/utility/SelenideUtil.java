package com.em2m.automation.utility;

import com.codeborne.selenide.Condition;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.TestBase;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;



public class SelenideUtil{

    static Logger logger  = Logger.getLogger(SelenideUtil.class);


    public static By getLocator(String elementLocator){
        String[] temp = elementLocator.split("===");
        By byValue = null;
        switch (temp[0].trim().toUpperCase()) {
            case "ID":
                byValue = By.id(temp[1].trim());
                break;
            case "XPATH":
                byValue = By.xpath(temp[1].trim());
                break;
            case "NAME":
                byValue = By.name(temp[1].trim());
                break;
            case "LINKTEXT":
                byValue = By.linkText(temp[1].trim());
                break;
            case "CSS":
                byValue = By.cssSelector(temp[1].trim());
                break;
            case "CLASSNAME":
                byValue = By.className(temp[1].trim());
                break;
            case "TAGNAME":
                byValue = By.tagName(temp[1].trim());
                break;
            default:
                Assert.fail("Invalid XPATH type [" + temp[0] + "] is given.");
        }
        return byValue;
    }

    public static boolean isVisible(String locator, final long waitTime){
        By byValue = getLocator(locator);
        try{
            if($(byValue).shouldBe(Condition.visible,Duration.ofMillis(waitTime)).isDisplayed()){
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Step got failed while check the visibility of element { "+byValue+" }");
        }
        return false;
    }

    public static boolean isVisible(final String locator){
        long wait = TimeConstant.WAIT_NORMAL;
        return isVisible(locator, wait);
    }

    public static  void sendKeys(String locator, String valueToSend, final long waitTime){
        By byValue = getLocator(locator);
        try{
            if($(byValue).shouldBe(Condition.visible, Duration.ofMillis(waitTime)).isDisplayed()){
                $(byValue).setValue(valueToSend);
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.error("Step got failed while try to send text on element { "+byValue+" } text box.");
        }
    }

    public static void sendKeys(String locator, String valueToSend){
        long wait = TimeConstant.WAIT_NORMAL;
        sendKeys(locator, valueToSend,wait);
    }

    public static void click(String locator, final long waitTime){
        By byValue = getLocator(locator);
        try{
            if($(byValue).shouldBe(Condition.visible,Duration.ofMillis(waitTime)).isDisplayed()){
               $(byValue).click();
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Step got failed while try to clicking on element { "+byValue+" }.");
        }
    }

    public static void click(String locator){
        long wait = TimeConstant.WAIT_NORMAL;
        click(locator,wait);
    }

    public static String getText(String locator){
        By byValue = getLocator(locator);
        try{
            String text = $(byValue).shouldBe(Condition.visible).getText();
            return text;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("step got failed while try to get the text of element { "+byValue+" }");
            return null;
        }
    }

}
