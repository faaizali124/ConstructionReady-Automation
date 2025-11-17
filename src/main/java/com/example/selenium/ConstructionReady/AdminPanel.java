package com.example.selenium.ConstructionReady;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class AdminPanel extends BasePage {

    private final By programsLink = By.linkText("Programs");
    private final By programsAllLink = By.cssSelector("a[href='https://staginglaravel.constructionready.org/admin/all-program']");
    private final By navBar = By.cssSelector(".dlabnav-scroll");
    private final By employerTab = By.cssSelector("a[href='https://staginglaravel.constructionready.org/admin/employer']");

    public AdminPanel(WebDriver driver) {
        super(driver);
    }

    public void openProgramsList() throws InterruptedException {
        driver.findElement(programsLink).click();
        Thread.sleep(2000);
        driver.findElement(programsAllLink).click();
        Thread.sleep(3000);
    }

    public void openEmployersTab()
    {
        WebElement navScrollBar = driver.findElement(navBar);
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop += 300",
                navScrollBar
        );

        driver.findElement(employerTab).click();
    }

}


