package com.hoangphuong.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentReportManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    //lưu report
    public static synchronized ExtentTest saveToReport(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    //tạo ảnh chụp màn hình đính kèm vào report
    public static void addScreenshot(String message) {
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) drivers.DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        getTest().log(Status.INFO, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    /*//tạo ảnh chụp màn hình kèm trạng thái (fail/pass) đính kèm vào report
    public static void addScreenshot(Status status, String message) {
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);

        getTest().log(status, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }*/

    //truyền vào 1 text
    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    }


    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }
}
