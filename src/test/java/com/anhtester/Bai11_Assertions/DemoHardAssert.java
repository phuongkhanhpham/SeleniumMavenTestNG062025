package com.anhtester.Bai11_Assertions;

import com.anhtester.common.BaseTest;
import com.anhtester.common.LocatorCRM;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {

    @Test
    public void testLoginSuccess() {
        driver.get("https://crm.anhtester.com/admin/authentication");

        // Kiểm tra đối tượng header và giá trị header
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Giá trị header không đúng.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerLogin)).getText(), "Login", "Giá trị header không đúng.");

        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Menu Dashboard is not displayed.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).getText(), "Dashboard", "Giá trị menu Dashboard không đúng.");

        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Invoices Awaiting Payment']")).getText().contains("Invoices Awaiting"));
    }

}
