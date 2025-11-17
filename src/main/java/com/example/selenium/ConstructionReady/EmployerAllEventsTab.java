package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class EmployerAllEventsTab extends BasePage {

    private final By addEventButton = By.xpath("//button[contains(@class, 'add-event-button')]");
    private final By titleField = By.cssSelector("input[name='title']");
    private final By detailsField = By.cssSelector("textarea[name='detail']");
    private final By visibilityField = By.cssSelector("textarea[type='search']");
    private final By websiteField = By.cssSelector("input[name=event_url]");
    private final By eventModal = By.xpath("//div[contains(@data-select2-id,'select2-data-20')]");
    private final By allDay = By.cssSelector("input[id='isFullDay']");
    private final By multiDay = By.cssSelector("input[id='is_multi_day']");
    public EmployerAllEventsTab(WebDriver driver)
    {
        super(driver);
    }

    public void createEvent(String title, String details, List<String> visibilityOptions, String url) throws InterruptedException
    {
        wait.until(ExpectedConditions.elementToBeClickable(addEventButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(titleField)).sendKeys(title);
        wait.until(ExpectedConditions.presenceOfElementLocated(detailsField)).sendKeys(details);

        for(String option : visibilityOptions)
        {
            wait.until(ExpectedConditions.presenceOfElementLocated(visibilityField)).sendKeys(option);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(@id, '" + option +"')]"))).click();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(websiteField)).sendKeys(url);
        Thread.sleep(1000);
        WebElement EventModal = driver.findElement(eventModal);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop +=530", EventModal);

    }
}
