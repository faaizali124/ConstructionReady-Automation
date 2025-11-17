package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;

public class ProgramsPage extends BasePage {
    
    private final By searchInput = By.cssSelector("input[type='search']");
    private final By scrollContainer = By.cssSelector(".card.m-b30.author-card.author-card-master.px-0");

    public ProgramsPage(WebDriver driver)
    {
        super(driver);
    }

    public void searchProgram(String text) {
        driver.findElement(searchInput).sendKeys(text);
    }

    public void scrollResults() throws InterruptedException {
        scrollBy(0, 1000);
        WebElement scrollDiv = driver.findElement(scrollContainer);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[0].scrollTop + 500;",
                scrollDiv
        );

        Thread.sleep(2000);
        scrollBy(0, -1000);
    }
}
