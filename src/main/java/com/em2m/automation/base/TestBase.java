package com.em2m.automation.base;

import com.codeborne.selenide.WebDriverRunner;
import com.em2m.automation.applicationConstansts.TimeConstant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;

public class TestBase {
    public Logger logger = Logger.getLogger(TestBase.class);
    private String browser;
    private String siteUrl;
    private boolean isHeadless;
    public static WebDriver webDriver;
    public String username;
    public String password;


    public void setGlobalVariables(){
        this.browser = ConfigProperties.getProperty("browser");
        this.siteUrl = ConfigProperties.getProperty("siteURL");
        this.isHeadless = ConfigProperties.getProperty("isHeadless").equalsIgnoreCase("true");
        this.username = ConfigProperties.getProperty("userName");
        this.password = ConfigProperties.getProperty("password");
    }

    public void launchUrl(){
        setGlobalVariables();
        try {
            if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.setHeadless(isHeadless);
                webDriver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(isHeadless);
                webDriver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
            }
            WebDriverRunner.setWebDriver(webDriver);
            webDriver.manage().window().maximize();
            webDriver.get(siteUrl);
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(TimeConstant.WAIT_MAX));
        } catch (Exception e) {
            logger.error("Exception ::" + e.getMessage());
        }

    }

    public void closeTheWindow(){
       closeWindow();
       closeWebDriver();
    }

    public static WebDriver getWebDriver(){return webDriver;}
}
