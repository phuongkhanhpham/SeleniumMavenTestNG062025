package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class LoginPage {

    // Khai báo driver cục bộ trong chính class này
    private WebDriver driver;

    // Khai báo hàm xây dựng, để truyền driver từ bên ngoài vào chính class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver); // Khởi tạo giá trị driver cho class WebUI
        PageFactory.initElements(driver, this);
//        PageFactory.initElements(driver, LoginPage.class);
    }

    // Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
//    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
//    private By inputEmail = By.xpath("//input[@id='email']");
//    private By inputPassword = By.xpath("//input[@id='password']");
//    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
//    private By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
//    private By errorMessage1 = By.xpath("//div[contains(@class, 'alert-danger')][1]");
//    private By errorMessage2 = By.xpath("//div[contains(@class, 'alert-danger')][2]");

    // Khai báo các element dạng đối tượng WebElement (phương thức tìm kiếm)
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    private WebElement headerPage;

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[contains(@class, 'alert-danger')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class, 'alert-danger')][1]")
    private WebElement errorMessage1;

    @FindBy(xpath = "//div[contains(@class, 'alert-danger')][2]")
    private WebElement errorMessage2;


    // Có thể dùng hàm chung đã viết ở WebUI, tuy nhiên có thể tạo thêm hàm riêng để đặt tên rõ hơn
    private void setEmail(String email) {
//        driver.findElement(inputEmail).sendKeys(email);
//        WebUI.setText(inputEmail, email);
        inputEmail.sendKeys(email);
    }

    private void setPassword(String password) {
        inputPassword.sendKeys(password);
    }

    private void clickLoginButton() {
        buttonLogin.click();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Content of error massage NOT match.");
    }

    public void verifyLoginFail(String message) {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(errorMessage.getText(), message, "Content of error massage NOT match.");
    }

    public void verifyLoginFailWithNullFields() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(errorMessage1.isDisplayed(), "Error message 1 NOT displays");
        Assert.assertTrue(errorMessage2.isDisplayed(), "Error message 2 NOT displays");

        Assert.assertEquals(errorMessage1.getText(), "The Password field is required.", "Content of error massage 1 NOT match.");
        Assert.assertEquals(errorMessage2.getText(), "The Email Address field is required.", "Content of error massage 2 NOT match.");
    }

    public void verifyLoginFailWithNullFields_ArrayList(int totalNullFields) {

        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");

        List<String> messageString = new ArrayList<>();
        messageString.add("The Password field is required.");
        messageString.add("The Email Address field is required.");

        boolean check = false;

        for (int i = 1; i <= totalNullFields; i++) {
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')][" + i + "]")).isDisplayed(), "Error message " + i + " NOT displays");

            for (int j = 0; j < messageString.size(); j++) {
                if (WebUI.getElementText(By.xpath("//div[contains(@class, 'alert-danger')][" + i + "]")).equals(messageString.get(j))) {
                    check = true;
                    break;
                }
            }
            Assert.assertTrue(check, "The content of error message " + i + " not matched.");
        }
    }

    //Các hàm xử lý cho chính trang này
    public void loginCRM(String email, String password) {
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
//        WebUI.setText(inputEmail, email);
//        WebUI.setText(inputPassword, password);
//        WebUI.clickElement(buttonLogin);

        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    public void loginCRM() {
        WebUI.openURL("https://crm.anhtester.com/admin/authentication");
//        WebUI.setText(inputEmail, "admin@example.com");
//        WebUI.setText(inputPassword, "123456");
//        WebUI.clickElement(buttonLogin);

        setEmail("admin@example.com");
        setPassword("123456");
        clickLoginButton();
        verifyLoginSuccess();
    }
}
