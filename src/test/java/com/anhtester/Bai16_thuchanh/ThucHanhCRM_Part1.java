package com.anhtester.Bai16_thuchanh;

import com.anhtester.common.LocatorCRM;
import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ThucHanhCRM_Part1 extends BaseTest {

    @Test
    public void testCustomerCRM() throws InterruptedException {

//        createDriver();

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.buttonLogin)).click();

        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        System.out.println(driver.findElement(By.xpath(LocatorCRM.headerCustomersPage)).getText());

        driver.findElement(By.xpath(LocatorCRM.buttonAddNewCustomer)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys("VNPT IT Ha Noi 200625001");
        driver.findElement(By.xpath(LocatorCRM.inputVat)).sendKeys("10");
        driver.findElement(By.xpath(LocatorCRM.inputPhoneNumber)).sendKeys("0123456789");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://vnptit.vn/");
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.inputSearchGroups)).sendKeys("VIP");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.itemVIP)).click();
        driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.itemVietnamese)).click();
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Ha Noi");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Hoan Kiem");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.inputsearchCountry)).sendKeys("Vietnam");
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.itemVietnamCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.buttonSave)).click();
        //Check alert message nếu có
        //Tiếp theo check item customer hiển thị tại trang Customer list
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        driver.findElement(By.xpath(LocatorCRM.searchCustomer)).sendKeys("VNPT IT Ha Noi 200625001");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).isDisplayed());
        System.out.println("Customer in List: " + driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).getText());
        //Tiếp theo check Customer đúng hết data sau khi add
        driver.findElement(By.xpath(LocatorCRM.itemCustomerFirst)).click();
        Thread.sleep(2000);
        System.out.println("Company Detail: " + driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputVat)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputPhoneNumber)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"));
        System.out.println(driver.findElement(By.xpath(LocatorCRM.dropdownGroups)).getAttribute("title"));
        System.out.println(driver.findElement(By.xpath(LocatorCRM.dropdownLanguage)).getAttribute("title"));

        //Cuối cùng phải check dạng Integration (liên kết với module khác)
        //Ví dụ customer sẽ được hiển thị bên trang project (nằm trong dropdown)
        Thread.sleep(2000);
//        closeDriver();
    }
}
