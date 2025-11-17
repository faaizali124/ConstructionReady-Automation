package com.example.selenium.StagingTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;


public abstract class BaseUiTestStaging {


    private static final String BASE_URL = "https://staginglaravel.constructionready.org/login";
    protected WebDriver driver;

    @BeforeEach
    void setUpDriver()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
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

