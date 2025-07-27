package com.anhtester.Bai18_PageFactory.testcases;

import com.anhtester.Bai18_PageFactory.pages.DashboardPage;
import com.anhtester.Bai18_PageFactory.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    DashboardPage dashboardPage;
    LoginPage loginPage;

    @Test
    public void testCheckDashboardTotal() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM(); // Chỉ Login

        dashboardPage = new DashboardPage(driver);

        dashboardPage.getListMenu();

        dashboardPage.verifyInvoicesAwaitingPayment("1 / 3");
    }
}
