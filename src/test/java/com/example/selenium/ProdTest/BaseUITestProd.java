package com.example.selenium.ProdTest;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;


public abstract class BaseUITestProd {

    protected WebDriver driver;
    private static final String BASE_URL = "https://admin.constructionready.org/";

    @BeforeEach
    void setUpDriver()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("permissions.default.popups", 2);
        FirefoxProfile profile = new FirefoxProfile(
            new File("C:/Users/faaiz/AppData/Roaming/Mozilla/Firefox/Profiles/ezmey4u9.default-release")
        );
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    // @AfterEach
    // void tearDownDriver()
    // {
    //     if(driver != null)
    //     {
    //         driver.quit();
    //     }
    // }

}

