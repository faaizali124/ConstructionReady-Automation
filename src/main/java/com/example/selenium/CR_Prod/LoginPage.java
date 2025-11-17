package com.example.selenium.CR_Prod;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    private static By emailField = By.id("email");
    private static By passwordField = By.id("dlab-password");
    private final By recaptchaIframe = By.xpath("//iframe[contains(@src, 'https://www.google.com/recaptcha/api2/anchor')]");
    private final By recaptchaButton = By.cssSelector("#recaptcha-anchor-label");
    private static By signInButton = By.cssSelector("button[type='submit']");
    

    public LoginPage(WebDriver driver) 
    {
        super(driver);
    }

    public void signIn(String username, String password) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        scrollBy(0, 300);
        WebElement iframe = driver.findElement(recaptchaIframe);
        driver.findElement(emailField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.switchTo().frame(iframe);
        driver.findElement(recaptchaButton).click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

    }
}