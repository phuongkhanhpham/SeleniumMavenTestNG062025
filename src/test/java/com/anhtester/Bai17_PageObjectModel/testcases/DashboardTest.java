package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.DashboardPage;
import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    DashboardPage dashboardPage;
    LoginPage loginPage;

    @Test
    public void testCheckDashboardTotal() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM(); // Chỉ Login

//        **************************************************************

        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyInvoicesAwaitingPayment("0 / 2");
    }
}
