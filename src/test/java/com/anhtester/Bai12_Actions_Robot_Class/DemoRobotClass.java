package com.anhtester.Bai12_Actions_Robot_Class;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DemoRobotClass extends BaseTest {

    @Test
    public void inputText() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");

        Thread.sleep(1000);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = new Robot();
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_L);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_N);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_I);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_U);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);

        // Đè 3 phím liên tục
//        robot.keyPress(KeyEvent.VK_FINAL);
//        robot.keyPress(KeyEvent.VK_PRINTSCREEN);
//        robot.keyPress(KeyEvent.VK_WINDOWS);

        // Tháo 3 phím ra
//        robot.keyRelease(KeyEvent.VK_FINAL);
//        robot.keyRelease(KeyEvent.VK_PRINTSCREEN);
//        robot.keyRelease(KeyEvent.VK_WINDOWS);

        Thread.sleep(2000);
    }

    @Test
    public void mousePress() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        Robot robot = new Robot();
        //Di chuyển trỏ chuột đến vị trí x,y
        robot.mouseMove(1272, 210);
        //Dalay giống sleep
        robot.delay(1000);
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thả chuột trái ra
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(2000);
    }

    @Test
    public void createScreenCapture() throws InterruptedException, AWTException, IOException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        Robot robot = new Robot();

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File("TestImageRobot.png");
        ImageIO.write(image, "png", file);

        Thread.sleep(1000);
    }
}
