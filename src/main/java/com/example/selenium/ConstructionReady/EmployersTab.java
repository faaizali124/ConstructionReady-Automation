package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmployersTab extends BasePage{

    private final By search = By.cssSelector("input[type='search']");
    private int attempts = 0;

    public EmployersTab(WebDriver driver)
    {
        super(driver);
    }

    public void selectEmployer(String employerName) throws InterruptedException
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(search));
        driver.findElement(search).sendKeys(employerName);
        By employerLink = By.linkText(employerName);
        wait.until(ExpectedConditions.presenceOfElementLocated(employerLink));
        handles.addAll(driver.getWindowHandles());
        currentHandleCount = driver.getWindowHandles().size();
        while (attempts < 3) 
        {
            try 
            {
                wait.until(ExpectedConditions.elementToBeClickable(employerLink)).click();
                break; // if click succeeds, exit loop
            } 
            catch (StaleElementReferenceException e)
            {
                System.out.println("Retrying due to stale element: " + employerName);
            }
            attempts++;
        }
        wait.until(driver -> driver.getWindowHandles().size() > currentHandleCount);

        switchToNewPage(driver, handles);
        handles.addAll(driver.getWindowHandles());
        currentHandleCount++;
        System.out.println(handles);
    }
}
