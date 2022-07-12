package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TimeZone
{
    By btn_timeZones=By.cssSelector("div[class*='timezone']");
    By btn_ok=By.xpath("//button[contains(text(),'Ok')]");


    public void selectTimeZone(String timeZone)
    {
        $$(btn_timeZones).filterBy(Condition.textCaseSensitive(timeZone)).first().click();
    }


    public void clickOk()
    {
        $(btn_ok).click();
    }


    //----------------------------Getters--------------------------


    public By getOkButton()
    {
      return btn_ok;
    }

}
