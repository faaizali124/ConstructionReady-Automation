package com.example.selenium.ConstructionReady;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class StudentDetailsPage extends BasePage {

    private final By detailsPanel = By.cssSelector(".card.mb-0.h-auto");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By male = By.id("gender-male");
    private final By female = By.id("gender-female");
    private final By other = By.id("gender-other");
    private final By phoneNumber = By.id("primary_phone");
    private final By DOB = By.id("js-date-of-birth");
    private final By DOB_confirmation = By.id("date_of_birth_confirmation");
    private final By address = By.id("student-home-address");
    private final By highSchool = By.id("signup-school-input");
    private final By program_teacher = By.id("signup-teacher-program-input");
    private final By gradYear = By.id("signup-graduation-year-button");
    private final By currentlyEnrolled = By.id("current-enrollment");
    private final By linkAnotherProgramYes = By.id("link-program-yes");
    private final By linkAnotherProgramNo = By.id("link-program-no");
    private final By email = By.id("register-email");
    private final By password = By.id("register-password");
    private final By confirmPassword = By.id("register-password-confirmation");
    private final By termsAndConditions = By.id("terms-agree");
    private final By recaptchaIframe = By.xpath("//iframe[contains(@src, 'https://www.google.com/recaptcha/api2/anchor')]");
    private final By recaptchaCheckbox = By.cssSelector("#recaptcha-anchor-label");
    private final By signUpButton = By.cssSelector("button[type='submit']");
    private final By signInButton = By.linkText("Sign in");

    WebElement panel = driver.findElement(detailsPanel);

    public StudentDetailsPage(WebDriver driver)
    {
        super(driver);
    }

    public void enterStudentDetails(String first_name, String last_name, String gender, String phone_number,
    String DoB, String homeAddress, String high_school, String teacher, String program, String grad__year,
    boolean currentEnrolment, boolean linkToAnotherProgram, String Email, String Password, boolean terms)
    throws InterruptedException
    {
        WebElement panel = wait.until(ExpectedConditions.presenceOfElementLocated(detailsPanel));
        Thread.sleep(2000);

        scrollDivBy(0,340, panel);

        wait.until(ExpectedConditions.presenceOfElementLocated(firstName)).sendKeys(first_name);
        driver.findElement(lastName).sendKeys(last_name);

        switch(gender)
        {
            case "male":
                driver.findElement(male).click();
                break;
            case "female":
                driver.findElement(female).click();
                break;
            case "other":
                driver.findElement(other).click();
                break;
        }

        driver.findElement(phoneNumber).sendKeys(phone_number);
        driver.findElement(DOB).sendKeys(DoB);
        driver.findElement(DOB_confirmation).click();
        Thread.sleep(2000);

        scrollDivBy(0, 100, panel);

        wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(homeAddress);
        Thread.sleep(2000);

        scrollDivBy(0, 500, panel);

        wait.until(ExpectedConditions.elementToBeClickable(highSchool)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(highSchool)).sendKeys(high_school);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + high_school +"']"))).click();
        driver.findElement(program_teacher).sendKeys(teacher);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + teacher + " / " + program + "']"))).click();
        driver.findElement(gradYear).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + grad__year + "']"))).click();

        if(currentEnrolment)
            driver.findElement(currentlyEnrolled).click();

        scrollDivBy(0, 340, panel);

        if(!linkToAnotherProgram)
        {
            wait.until(ExpectedConditions.elementToBeClickable(linkAnotherProgramNo)).click();
        }
        else
        {
            wait.until(ExpectedConditions.elementToBeClickable(linkAnotherProgramYes)).click();
        }

        scrollDivBy(0, 370, panel);

        wait.until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys(Email);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(confirmPassword).sendKeys(Password);

        if(terms)
            driver.findElement(termsAndConditions).click();
    
        driver.switchTo().frame(driver.findElement(recaptchaIframe));
        wait.until(ExpectedConditions.elementToBeClickable(recaptchaCheckbox));
        driver.findElement(recaptchaCheckbox).click();
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        scrollDivBy(0, 300, panel);
        driver.findElement(signUpButton).click();
    }
}
