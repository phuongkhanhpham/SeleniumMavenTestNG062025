package com.anhtester.Bai20_21_Practise_POM_CRM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    // Dùng public do đây là class chung
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    public By iconProfile = By.xpath("//li[contains(@class,'header-user-profile')]");
    public By menuTasks = By.xpath("//span[normalize-space()='Tasks']");
    public By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    public By menuSales = By.xpath("//span[@class='menu-text' and normalize-space()='Sales']");
    public By menuProposals = By.xpath("//span[normalize-space()='Proposals']");

    public CustomerPage clickMenuCustomers() {
        WebUI.waitForElementVisible(menuCustomer);
        WebUI.clickElement(menuCustomer);
        return new CustomerPage(driver);
    }
}
