package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Condition;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.utility.SelenideUtil;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TimeZone {

    public void selectTimeZone(String timeZone) {

        $$(SelenideUtil.getLocator("btn_timeZones")).filterBy(Condition.textCaseSensitive(timeZone)).first().click();
        SelenideUtil.click(ConfigProperties.getProperty("btn_ok"));
    }




}
