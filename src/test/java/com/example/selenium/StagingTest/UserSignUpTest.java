package com.example.selenium.StagingTest;

import com.example.selenium.ConstructionReady.LoginPage;
import com.example.selenium.ConstructionReady.SelectUserTypePage;
import com.example.selenium.ConstructionReady.StudentDetailsPage;
import com.example.selenium.ConstructionReady.VerificationOptionPage;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserSignUpTest extends BaseUiTestStaging {

    @Test
    @DisplayName("Sign Up New User in Staging")
    void userSignUp() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignUpButton();

        SelectUserTypePage selectUserType = new SelectUserTypePage(driver);
        selectUserType.selectStudentOption();

        StudentDetailsPage studentDetails = new StudentDetailsPage(driver);
        studentDetails.enterStudentDetails("Test New", "Signup Flow", "male",
        "2566266652", "11-9-2001", "Georgia Ave, Silver Spring, MD, USA",
        "Adairsville High School","John Ford","Construction","2027",
        true, false,
        "testnewsignupflow100@yopmail.com", "A123456@", true);

        VerificationOptionPage verificationOption = new VerificationOptionPage(driver);
        verificationOption.selectVerificationOption("sms");
    }

}



