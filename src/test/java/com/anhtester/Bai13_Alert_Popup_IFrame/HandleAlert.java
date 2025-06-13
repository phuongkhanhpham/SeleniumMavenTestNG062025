package com.anhtester.Bai13_Alert_Popup_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {

    @Test
    public void demoHandleAlertAccept() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);

        // Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Thread.sleep(1000);

        // Khởi tạo class Alert thứ nhất
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        // Gọi anonymous
//        driver.switchTo().alert().accept();

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertDismiss() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//button[@id='confirmButton']"));

        // Scroll to Element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Element bị che nên phải di chuyển tới Element đó, dùng Actions class
//        Actions action = new Actions(driver);
//        action.moveToElement(element).perform();

        // Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
        Thread.sleep(1000);

        // Khởi tạo class Alert thứ nhất
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='confirmResult']")).isDisplayed(), "The Cancel button is not clicked");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText(), "You selected Cancel", "The message content is not matched");

        // Gọi anonymous
//        driver.switchTo().alert().dismiss();

        Thread.sleep(1000);
    }

    @Test
    public void demoHandleAlertInputText() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);

        WebElement element = driver.findElement(By.xpath("//button[@id='promtButton']"));

        // Scroll to Element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Element bị che nên phải di chuyển tới Element đó, dùng Actions class
//        Actions action = new Actions(driver);
//        action.moveToElement(element).perform();

        // Mở Alert Message, click vào nút "Click me!" thứ nhất
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Thread.sleep(1000);

        // Khởi tạo class Alert thứ nhất
        Alert alert3 = driver.switchTo().alert();

        System.out.println("Alert text: " + alert3.getText());

        alert3.sendKeys("Selenium");
        alert3.accept();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//span[@id='promptResult']")).isDisplayed(), "The Accept button is not clicked");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='promptResult']")).getText(), "You entered Selenium", "The message content is not matched");

        // Gọi anonymous
//        driver.switchTo().alert().dismiss();

        Thread.sleep(1000);
    }
}
