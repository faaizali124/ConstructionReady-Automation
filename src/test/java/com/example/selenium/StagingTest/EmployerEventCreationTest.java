package com.example.selenium.StagingTest;

import com.example.selenium.ConstructionReady.AdminPanel;
import com.example.selenium.ConstructionReady.EmployerAllEventsTab;
import com.example.selenium.ConstructionReady.EmployerDashboard;
import com.example.selenium.ConstructionReady.EmployersTab;
import com.example.selenium.ConstructionReady.LoginPage;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployerEventCreationTest extends BaseUiTestStaging {

    @Test
    @DisplayName("Creating an Event on Employer side")
    void createEvent() throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@cr.com", "123456");

        AdminPanel adminPanel = new AdminPanel(driver);
        adminPanel.openEmployersTab();

        EmployersTab employersTab = new EmployersTab(driver);
        employersTab.selectEmployer("Prod Test Emp");

        EmployerDashboard employerDashboard = new EmployerDashboard(driver);
        employerDashboard.switchToEmployerSide();
        employerDashboard.openAllEventsTab();

        EmployerAllEventsTab employerAllEventsTab = new EmployerAllEventsTab(driver);
        employerAllEventsTab.createEvent("Automation Event", "Event made via automation",
         List.of("teachers","employers"), "https://www.google.com" );
    }
    
}
