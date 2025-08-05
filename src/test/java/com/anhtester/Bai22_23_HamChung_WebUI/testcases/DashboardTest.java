package com.anhtester.Bai22_23_HamChung_WebUI.testcases;

import com.anhtester.Bai22_23_HamChung_WebUI.pages.DashboardPage;
import com.anhtester.Bai22_23_HamChung_WebUI.pages.LoginPage;
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
