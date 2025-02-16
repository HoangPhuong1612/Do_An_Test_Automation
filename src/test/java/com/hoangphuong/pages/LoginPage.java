package com.hoangphuong.pages;

import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;



public class LoginPage {

    //khai báo driver cục bộ chính cho class
    private WebDriver driver;

    //hàm xây dựng cho từng class trong Page
    public LoginPage(WebDriver driver) {
        this.driver = driver;//nhận giá trị từ bên ngoài (BaseTest) khi khởi tạo class
    }

    //khai báo các element dạng đối tượng By
    public By inputUsername =By.xpath("//input[@id='ctl00_PlaceHolderMain_signInControl_UserName']");
    public By inputPasword = By.xpath("//input[@id='ctl00_PlaceHolderMain_signInControl_password']");
    public By buttonLogin = By.xpath("//input[@id='ctl00_PlaceHolderMain_signInControl_login']");
    public By errorMessage = By.xpath("//span[@id='ctl00_PlaceHolderMain_signInControl_FailureText']");

    public By mainTitle = By.xpath("//div[@class='main-title']");

    //khai báo các hàm xử lý
    public void enterUsername(String username){
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(inputPasword).sendKeys(password);
    }

    public void clickButtonLogin(){
        driver.findElement(buttonLogin).click();
    }

    public void LoginCTT(String username, String password){
        driver.get(ConfigData.URL);
        enterUsername(username);
        enterPassword(password);
        WebUI.sleep(2);
        clickButtonLogin();
    }

    public void verifyLoginSuccess(){
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(driver.findElement(mainTitle).isDisplayed(),"Đăng nhập chưa thành công!");
        String originalTitle = driver.findElement(mainTitle).getText();
        Assert.assertEquals(originalTitle, "HỌC VIỆN BÁO CHÍ VÀ TUYÊN TRUYỀN","Tiêu đề hiển thị không đúng!");
    }

    public void verifyLoginFail(){
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(),"Chưa hiển thị thông báo lỗi!");
        String originalTitle = driver.findElement(errorMessage).getText();
        Assert.assertEquals(originalTitle, "The server could not sign you in. Make sure your user name and password are correct, and then try again.","Nội dung thông báo lỗi chưa đúng hoặc chưa hiển thị!");
    }

}
