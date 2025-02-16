package com.hoangphuong.common;

import com.hoangphuong.helpers.CaptureHelper;
import com.hoangphuong.listeners.TestListener;
import drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;


    @BeforeMethod
    public void createDriver(){
        ChromeOptions options = new ChromeOptions();

        // Bỏ qua cảnh báo SSL
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.setDriver(driver);
    }


        @AfterMethod
    public void closeDriver(ITestResult iTestResult){
        /*if (ITestResult.FAILURE == iTestResult.getStatus()) {
            CaptureHelper.screenshot(iTestResult.getName());
        }*/
        driver.quit();
    }
}
