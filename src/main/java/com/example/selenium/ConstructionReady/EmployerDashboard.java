package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class EmployerDashboard extends BasePage {

    private final By eventsTab = By.linkText("Events");
    private final By allEventsTab = By.linkText("All Events");
    private final By navBar = By.id("menu");

    public EmployerDashboard (WebDriver driver)
    {
        super(driver);
        
    }

    public void switchToEmployerSide()
    {
        switchToNewPage(driver, handles);
    }

    public void openAllEventsTab()
    {
        wait.until(ExpectedConditions.elementToBeClickable(eventsTab)).click();
        wait.until(ExpectedConditions.elementToBeClickable(allEventsTab)).click();
    }
}
