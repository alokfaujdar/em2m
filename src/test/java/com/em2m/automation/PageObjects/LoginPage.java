package com.em2m.automation.PageObjects;

import com.codeborne.selenide.Selenide;
import com.em2m.automation.applicationConstansts.TimeConstant;
import com.em2m.automation.base.ConfigProperties;
import com.em2m.automation.base.TestBase;
import com.em2m.automation.utility.SelenideUtil;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends TestBase {

    public boolean  verifyLoginPageIsLoaded(){
        boolean flag1, flag2,flag3;
        flag1=SelenideUtil.isVisible(ConfigProperties.getProperty("userNameTextBox"), TimeConstant.WAIT_HIGH);
        flag2=SelenideUtil.isVisible(ConfigProperties.getProperty("passwordTextBox"), TimeConstant.WAIT_HIGH);
        flag3=SelenideUtil.isVisible(ConfigProperties.getProperty("btn_login"), TimeConstant.WAIT_HIGH);
        if(!(flag1 && flag2 && flag3)){
            return false;
        }
        return true;
    }

    public boolean logIn(String username, String password){
        try{
            SelenideUtil.sendKeys(ConfigProperties.getProperty("userNameTextBox"), username);
            SelenideUtil.sendKeys(ConfigProperties.getProperty("passwordTextBox"), password);
            Selenide.sleep(1000);
            SelenideUtil.click(ConfigProperties.getProperty("btn_login"));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean logIn(){
        String userName = ConfigProperties.getProperty("userName");
        String password = ConfigProperties.getProperty("password");
       return  logIn(userName, password);
    }

    public boolean verifyErrorMessage(){
        try{
            SelenideUtil.isVisible(ConfigProperties.getProperty("msg_loginError"));
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



}