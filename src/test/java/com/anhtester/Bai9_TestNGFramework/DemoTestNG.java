package com.anhtester.Bai9_TestNGFramework;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DemoTestNG extends BaseTest {
    WebDriver driver;

    @BeforeSuite

    @BeforeTest

    @BeforeClass
    public void beforeTest() {
        //Get thông tin class name chứa các @Test
        //Record video cho tất cả các Test
    }

    @BeforeMethod
    public void createDriver() {
        //Khởi tạo trình duyệt mỗi lần cho từng @Test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    //Google page has already blocked
    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
//        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("anhtester", Keys.ENTER);
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']")).click();
//        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("(//form[@role='search']//input[@value='Tìm trên Google'])[2]")).isDisplayed());
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}
