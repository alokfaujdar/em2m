package com.em2m.automation.utility;

import com.em2m.automation.base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneralHelper extends TestBase {

    public static void pressEscape(WebDriver webDriver){
        try{
            Actions action = new Actions(webDriver);
            action.sendKeys(Keys.ESCAPE).perform();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static byte[] getByteScreenshot(){
        TestBase tb=new TestBase();
        File src = ((TakesScreenshot) tb.getWebDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(src);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public String updatedXPATH(String genericLocator,String toBeUpdate, String toBeReplaced){
        String updatedXpath = null;
        try{
            updatedXpath = genericLocator.replace(toBeReplaced,toBeUpdate);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("failed to update the xpath");
        }
        return updatedXpath;
    }

    public List updatedXPATH(String genericLocator, List<String> toBeUpdate, String toBeReplaced){
        List<String> updatedList = new ArrayList<>();
        toBeUpdate.forEach(e -> updatedList.add(updatedXPATH(genericLocator,e,toBeReplaced)));
        return updatedList;
    }

}
