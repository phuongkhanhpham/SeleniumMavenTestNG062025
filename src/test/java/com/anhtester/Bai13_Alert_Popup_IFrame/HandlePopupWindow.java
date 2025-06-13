package com.anhtester.Bai13_Alert_Popup_IFrame;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;

public class HandlePopupWindow extends BaseTest {

    @Test
    public void testOpenNewTab() {
        driver.get("https://anhtester.com/");

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.google.com/");
    }

    @Test
    public void testOpenNewWindow() {
        driver.get("https://anhtester.com/");

        driver.switchTo().newWindow(WindowType.WINDOW);

        driver.get("https://www.google.com/");
    }

    @Test
    public void demoNotSwitchToTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);
        // Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        Thread.sleep(1000);
    }

    @Test
    public void demoPopupWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click(); // Tab
//        driver.findElement(By.xpath("//button[@id='windowButton']")).click(); // Window
        Thread.sleep(1000);
        // Lưu lại lớp Window đầu tiên - mã ID hơi dài, in ra sẽ thấy
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main Window: " + mainWindow);

        // Lấy tất cả các mã định danh Tab Window
        Set<String> windows = driver.getWindowHandles();

        // Set là 1 Collection để lưu các phần tử giá trị KHÔNG trùng lặp
        // Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!mainWindow.equals(window)) {
                // So sáng nếu thằng nào khác thằng chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                // Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                Thread.sleep(1000);
                System.out.println("Đã chuyển đến Tab Window mới");

                // Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                Thread.sleep(1000);
                // Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

                // Tắt cái Tab Window mới
                Thread.sleep(1000);
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }

    @Test
    public void demoPopupWindow_Index() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//button[@id='windowButton']"));
        action.moveToElement(element).perform();

//        driver.findElement(By.xpath("//button[@id='tabButton']")).click(); // Tab
        driver.findElement(By.xpath("//button[@id='windowButton']")).click(); // Window
        Thread.sleep(1000);
        // Lưu lại lớp Window đầu tiên - mã ID hơi dài, in ra sẽ thấy
        String mainWindow = driver.getWindowHandle();
        System.out.println("Main Window: " + mainWindow);

        // Lấy tất cả các mã định danh Tab Window
        Set<String> windows = driver.getWindowHandles();

        String firstWindow = (String)windows.toArray()[0]; // Cửa sổ đầu
        String secondWindow = (String)windows.toArray()[1]; // Cửa sổ thứ hai

        // Chuyển hướng đến cửa sổ thứ 2
        driver.switchTo().window(secondWindow);
//        driver.switchTo().window((String)windows.toArray()[1]);

        // Một số hàm hỗ trợ
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        driver.close();

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(mainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(1000);
    }
}
