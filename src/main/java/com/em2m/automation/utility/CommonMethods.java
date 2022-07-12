package com.em2m.automation.utility;

import org.junit.Assert;

import java.util.List;

public class CommonMethods {

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

}
