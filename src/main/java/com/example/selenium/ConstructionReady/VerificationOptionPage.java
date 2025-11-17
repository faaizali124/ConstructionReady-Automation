package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class VerificationOptionPage extends BasePage {

    private final By sms = By.cssSelector("input[value='sms']");
    private final By email = By.cssSelector("input[value='email']");
    private final By continueButton = By.id("continueBtn");

    public VerificationOptionPage(WebDriver driver)
    {
        super(driver);
    }

    public void selectVerificationOption(String option)
    {
        wait.until(ExpectedConditions.elementToBeClickable(sms));

        if(option.equals("SMS") || option.equals("sms"))
        {
            driver.findElement(sms).click();
        }
        else if(option.equals("email"))
        {
            driver.findElement(email).click();
        }

        driver.findElement(continueButton).click();
    }
}
