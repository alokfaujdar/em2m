package com.em2m.automation.utility;

import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import org.junit.Assert;

import java.util.List;

public class CommonMethods {

    public static GeneralHelper helper = new GeneralHelper();

    public static boolean checkVisibilityOfMultipleElement(List<String> list, boolean shouldVisible){
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

    public static void checkPageLoadedByHeader(String pageName){
        String xpath = helper.updatedXPATH(ConfigProperties.XPATH.getProperty("pageName"),pageName,"%Name%");
        Assert.assertTrue(SelenideUtil.isVisible(xpath, TimeConstant.WAIT_MEDIUM));
    }

}
