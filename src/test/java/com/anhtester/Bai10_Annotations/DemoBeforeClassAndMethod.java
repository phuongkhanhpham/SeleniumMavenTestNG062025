package com.anhtester.Bai10_Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DemoBeforeClassAndMethod extends SetupClass {

    @Test(priority = 1, description = "Testcase check blog")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
        Assert.fail();
    }

    //Google page has already blocked
    @Test(priority = 2, description = "Testcase search data on Google")
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        Assert.assertTrue(driver.findElement(By.xpath("(//form[@role='search']//input[@value='Tìm trên Google'])[2]")).isDisplayed());
    }
}
