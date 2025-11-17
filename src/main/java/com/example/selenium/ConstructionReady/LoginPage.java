package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By emailField = By.id("email");
    private final By passwordField = By.id("dlab-password");
    private final By recaptchaIframe = By.xpath("//iframe[contains(@src, 'https://www.google.com/recaptcha/api2/anchor')]");
    private final By recaptchaCheckbox = By.cssSelector("#recaptcha-anchor-label");
    private final By signInButton = By.cssSelector("button[type='submit']");
    private final By signUpButton = By.linkText("Sign up");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);

        scrollBy(0,200);

        WebElement iframe = driver.findElement(recaptchaIframe);
        driver.switchTo().frame(iframe);
        WebElement recaptcha = wait.until(ExpectedConditions.elementToBeClickable(recaptchaCheckbox));
        recaptcha.click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        scrollBy(0, 800);
        driver.findElement(signInButton).click();
    }

    public void clickSignUpButton() throws InterruptedException
    {
        scrollBy(0, 800);
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }
}


