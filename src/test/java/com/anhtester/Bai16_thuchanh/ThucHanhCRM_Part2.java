package com.anhtester.Bai16_thuchanh;

import com.anhtester.common.BaseTest;
import com.anhtester.common.LocatorCRM;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ThucHanhCRM_Part2 extends BaseTest {

    @Test
    public void testCustomerCRM() throws InterruptedException {
        String CUSTOMER_NAME = "VNPT IT Ha Noi 230625010";

        new WebUI(driver); // Khởi tạo class WebUI để truyền driver vào

        driver.get("https://crm.anhtester.com/admin/authentication");

        WebUI.clearText(By.xpath(LocatorCRM.inputEmail));
        WebUI.clearText(By.xpath(LocatorCRM.inputPassword));
//        driver.findElement(By.xpath(LocatorCRM.inputEmail)).clear();
//        driver.findElement(By.xpath(LocatorCRM.inputPassword)).clear();

        WebUI.setText(By.xpath(LocatorCRM.inputEmail), "admin@example.com");
        WebUI.setText(By.xpath(LocatorCRM.inputPassword), "123456");
//        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
//        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");

        WebUI.clickElement(By.xpath(LocatorCRM.buttonLogin));
//        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        WebUI.clickElement(By.xpath(LocatorCRM.menuCustomer));
//        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();

        System.out.println(WebUI.getTextElement(By.xpath(LocatorCRM.headerCustomersPage)));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText());

        WebUI.clickElement(By.xpath(LocatorCRM.buttonAddNewCustomer));
//        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
//        Thread.sleep(2000);

        WebUI.setText(By.xpath(LocatorCRM.inputCompany), CUSTOMER_NAME);
//        driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys(CUSTOMER_NAME);

        WebUI.setText(By.xpath(LocatorCRM.inputVat), "10");
//        driver.findElement(By.xpath(LocatorCRM.inputVat)).sendKeys("10");

        WebUI.setText(By.xpath(LocatorCRM.inputPhoneNumber), "0123456789");
//        driver.findElement(By.xpath(LocatorCRM.inputPhoneNumber)).sendKeys("0123456789");

        WebUI.setText(By.xpath(LocatorCRM.inputWebsite), "https://vnptit.vn/");
//        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://vnptit.vn/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//label[text()='Groups']")));

        WebUI.clickElement(By.xpath(LocatorCRM.dropdownGroups));
//        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
//        Thread.sleep(1000);

        WebUI.setText(By.xpath(LocatorCRM.inputSearchGroups), "VIP");
//        driver.findElement(By.xpath(LocatorCRM.inputSearchGroups)).sendKeys("VIP");
        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorCRM.itemVIP));
//        driver.findElement(By.xpath(LocatorCRM.itemVIP)).click();

        WebUI.clickElement(By.xpath(LocatorCRM.dropdownGroups));
//        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
//        Thread.sleep(2000);

        WebUI.clickElement(By.xpath(LocatorCRM.dropdownLanguage));
//        driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorCRM.itemVietnamese));
//        driver.findElement(By.xpath(LocatorCRM.itemVietnamese)).click();

        WebUI.setText(By.xpath(LocatorCRM.inputAddress), "Ha Noi");
//        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Ha Noi");

        WebUI.setText(By.xpath(LocatorCRM.inputCity), "Ha Noi");
//        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Ha Noi");

        WebUI.setText(By.xpath(LocatorCRM.inputState), "Hoan Kiem");
//        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Hoan Kiem");

        WebUI.setText(By.xpath(LocatorCRM.inputZipCode), "123456");
//        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("123456");
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorCRM.dropdownCountry));
//        driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
//        Thread.sleep(1000);

        WebUI.setText(By.xpath(LocatorCRM.inputsearchCountry), "Vietnam");
//        driver.findElement(By.xpath(LocatorCRM.inputsearchCountry)).sendKeys("Vietnam");
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorCRM.itemVietnamCountry));
//        driver.findElement(By.xpath(LocatorCRM.itemVietnamCountry)).click();
//        Thread.sleep(1000);

        WebUI.clickElement(By.xpath(LocatorCRM.buttonSave));
//        driver.findElement(By.xpath(LocatorCRM.buttonSave)).click();
        //Check alert message nếu có
        //Tiếp theo check item customer hiển thị tại trang Customer list
//        Thread.sleep(1000);

        // Search and check first data
        WebUI.clickElement(By.xpath(LocatorCRM.menuCustomer));
//        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();

        WebUI.setText(By.xpath(LocatorCRM.searchCustomer), CUSTOMER_NAME);
//        driver.findElement(By.xpath(LocatorCRM.searchCustomer)).sendKeys(CUSTOMER_NAME);
        Thread.sleep(2000);

        WebUI.waitForElementVisible(By.xpath(LocatorCRM.itemCustomerFirst));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).isDisplayed());

        Assert.assertEquals(WebUI.getTextElement(By.xpath(LocatorCRM.itemCustomerFirst)), CUSTOMER_NAME, "The customer name is not matched.");

//        System.out.println(WebUI.getTextElement(By.xpath(LocatorCRM.itemCustomerFirst)));
//        System.out.println("Customer in List: " + driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).getText());
        //Tiếp theo check Customer đúng hết data sau khi add

        WebUI.clickElement(By.xpath(LocatorCRM.itemCustomerFirst));
//        driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).click();
//        Thread.sleep(2000);

        // Verify data in customer detail
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"), CUSTOMER_NAME, "The company name is not matched.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVat)).getAttribute("value"), "10", "The VAT value is not matched.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhoneNumber)).getAttribute("value"), "0123456789", "The phone number is not matched.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "https://vnptit.vn/", "The website is not matched.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).getText(), "VIP", "The group value is not matched.");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).getText(), "Vietnamese", "The language value is not matched.");
//        System.out.println("Company Detail: " + driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputVat)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputPhoneNumber)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).getAttribute("title"));
//        System.out.println(driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).getAttribute("title"));

        //Cuối cùng phải check dạng Integration (liên kết với module khác)
        //Ví dụ customer sẽ được hiển thị bên trang project (nằm trong dropdown)
    }
}
