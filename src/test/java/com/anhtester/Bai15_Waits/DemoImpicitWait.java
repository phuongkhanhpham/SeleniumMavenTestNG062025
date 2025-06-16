package com.anhtester.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoImpicitWait {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Set timeout for ImplicitlyWait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void demoImpicitWait() throws InterruptedException {

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        // Set timeout for ImplicitlyWait, setup 1 nơi nhưng dùng ở nhiều nơi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(), 'Projects')]")).click();

        // Giải phóng implicitlyWait về 0 để không ảnh hưởng Test tiếp theo (chính xác là không có tác dụng ở Test tiếp theo)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

//        Thread.sleep(1000);
        driver.close();
    }

    @Test(priority = 2)
    public void demoImpicitWait2() throws InterruptedException {

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        // Set timeout for ImplicitlyWait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hrm.anhtester.com/");

        driver.findElement(By.xpath("//input[@id='iusername']")).sendKeys("admin_example");
        driver.findElement(By.xpath("//input[@id='ipassword']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Click menu dự án
        driver.findElement(By.xpath("//span[contains(text(), 'Projects')]")).click();

//        Thread.sleep(1000);
        driver.close();
    }
}
