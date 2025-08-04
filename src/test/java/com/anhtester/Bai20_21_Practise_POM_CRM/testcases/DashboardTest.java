package com.anhtester.Bai20_21_Practise_POM_CRM.testcases;

import com.anhtester.Bai20_21_Practise_POM_CRM.pages.DashboardPage;
import com.anhtester.Bai20_21_Practise_POM_CRM.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    DashboardPage dashboardPage;
    LoginPage loginPage;

    @Test
    public void testCheckDashboardTotal() throws InterruptedException {
        loginPage = new LoginPage(driver);
//        loginPage.loginCRM(); // Chỉ Login
//
//        dashboardPage = new DashboardPage(driver);

        dashboardPage = loginPage.loginCRM();
        dashboardPage.verifyInvoicesAwaitingPayment("1 / 3");
    }
}
