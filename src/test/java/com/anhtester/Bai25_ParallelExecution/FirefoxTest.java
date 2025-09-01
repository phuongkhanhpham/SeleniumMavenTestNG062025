package com.anhtester.Bai25_ParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class FirefoxTest {

    @Test
    public void FirefoxTestMethod01() {
        System.out.println("Initializing the Microsoft Firefox driver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the Firefox driver
        System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Mobile Testing']")).click();
        driver.quit();
    }

    @Test
    public void FirefoxTestMethod02() {
        System.out.println("Initializing the Microsoft Firefox driver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Initialize the Firefox driver
        System.out.println("The thread ID for Firefox is " + Thread.currentThread().getId());
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//h3[normalize-space()='Desktop Testing']")).click();
        driver.quit();
    }
}
