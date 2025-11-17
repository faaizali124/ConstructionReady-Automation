package com.example.selenium.CR_Prod;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPanel extends BasePage {

    private final By studentsTab = By.linkText("Students");
    private final By studentsSubTab = By.cssSelector("a[href='https://admin.constructionready.org/admin/student']");


    public AdminPanel (WebDriver driver)
    {
        super(driver);
    }

    public void openAllStudentsPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(studentsTab));
        wait.until(ExpectedConditions.elementToBeClickable(studentsSubTab));
    }

}
