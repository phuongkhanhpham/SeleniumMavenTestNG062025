package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import com.anhtester.common.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {

    @Test
    public void testLoginSuccess() {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://crm.anhtester.com/admin/authentication");

        // Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Header value is not correct.");

        // SoftAssert nên dù failed vẫn chạy tiếp, sẽ trả lỗi tại dòng softAssert.assertAll();
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLogin)).getText(), "Login1", "Header value is not correct.");

        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        softAssert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed.");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).getText(), "Dashboard", "Menu Dashboard value is not correct.");

        softAssert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Invoices Awaiting Payment']")).getText().contains("Invoices Awaiting"), "The content of label is not matched.");

        softAssert.assertAll();
    }
}
