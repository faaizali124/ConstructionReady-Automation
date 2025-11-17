package com.example.selenium.ConstructionReady;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.ArrayList;
import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected int currentHandleCount;

    List<String> handles = new ArrayList<String>();

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        currentHandleCount = 1;
    }

    protected void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "window.scrollBy({ top: arguments[1], left: arguments[0], behavior: 'smooth' });",
            x, y
        );
    }

        protected void scrollDivBy(int x, int y, WebElement div) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                "arguments[0].scrollBy({ top: arguments[2], left: arguments[1], behavior: 'smooth' });",
                div, x, y
            );
        }
    

    public void switchToNewPage(WebDriver driver, List<String> handles) {
        for (String handle : driver.getWindowHandles()) {
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }
        }
    }
}


