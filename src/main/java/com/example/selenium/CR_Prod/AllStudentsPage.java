package com.example.selenium.CR_Prod;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllStudentsPage extends BasePage {

    private final By searchBar = By.cssSelector("input[type='search']");

    public AllStudentsPage (WebDriver driver)
    {
        super(driver);
    }

    public void openStudentSide(String name)
    {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar)).sendKeys(name);
        
    }



}
