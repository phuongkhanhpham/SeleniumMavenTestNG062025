package com.anhtester.Bai10_Annotations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoBeforeClassAndMethod2 extends SetupClass {

    @Test
    public void testLoginCRM() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
//        driver.findElement(By.linkText("Forgot Password?")).click();
//        driver.findElement(By.partialLinkText("Forgot")).click();
//        driver.findElement(By.className("btn btn-primary btn-block")).click(); // Gồm 3 class name cách nhau bởi dấu cách, chỉ hỗ trợ tìm từng class name
        driver.findElement(By.className("btn-primary")).click();
    }
}
