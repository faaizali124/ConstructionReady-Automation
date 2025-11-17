package com.example.selenium.ConstructionReady;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;


public class SelectUserTypePage extends BasePage {

    private final By continueButton = By.id("continue-with-selected-role");
    private final By selectUserDiv = By.cssSelector(".card.mb-0.h-auto");

    public SelectUserTypePage(WebDriver driver) {
        super(driver);
    }

    public void selectStudentOption() throws InterruptedException {
        WebElement panel = driver.findElement(selectUserDiv);
        scrollDivBy(0, 5000, panel);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(continueButton)));
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(continueButton));
        Thread.sleep(2000);
    }

}
