package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.helpers.CaptureHelper;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.LoginPage;
import drivers.DriverManager;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @Test(priority = 1, description = "Đăng nhập thành công với thông tin hợp lệ")
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2, description = "Đăng nhập thất bại với tên đăng nhập trống")
    public void testLoginFailWithUsernameNull(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT("", ConfigData.PASSWORD);
        WebUI.sleep(3);
        loginPage.verifyLoginFail();
    }

    @Test(priority = 3, description = "Đăng nhập thất bại với mật khẩu trống")
    public void testLoginFailWithPasswordNull(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, "");
        WebUI.sleep(4);
        loginPage.verifyLoginFail();
    }

    @Test(priority = 4, description = "Đăng nhập thất bại với tên đăng nhập và mật khẩu trống")
    public void testLoginFailWithUsernameandPasswordNull(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT("", "");
        loginPage.verifyLoginFail();
    }

    @Test(priority = 5, description = "Đăng nhập thất bại với tên đăng nhập sai")
    public void testLoginFailWithUsernameIncorrect(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT("spad", ConfigData.PASSWORD);
        loginPage.verifyLoginFail();
    }

    @Test(priority = 6, description = "Đăng nhập thất bại với mật khẩu sai")
    public void testLoginFailWithPasswordIncorrect(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, "123");
        loginPage.verifyLoginFail();
    }
}
