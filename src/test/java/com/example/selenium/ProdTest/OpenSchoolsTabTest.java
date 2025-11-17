package com.example.selenium.ProdTest;

import com.example.selenium.CR_Prod.AdminPanel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
    
class OpenSchoolsTabTest extends BaseUITestProd {

    @Test
    @DisplayName("Opening Schools Tab")
    void openSchools()
    {
        AdminPanel adminPanel = new AdminPanel(driver);
    }
}