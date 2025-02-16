package com.hoangphuong.listeners;

import com.aventstack.extentreports.Status;
import com.hoangphuong.helpers.CaptureHelper;
import com.hoangphuong.reports.ExtentReportManager;
import com.hoangphuong.reports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext arg0) {
        System.out.println("\uD83C\uDF1F onStart");
    }

    @Override
    public void onFinish(ITestContext arg0) {
        System.out.println("\uD83C\uDF1F onFinish");
        //Kết thúc và thực thi Extents Report
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("\uD83C\uDF1F onTestStart");
        CaptureHelper.startRecord(iTestResult.getName());
        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(iTestResult), getTestDescription(iTestResult));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("✅ onTestSuccess");
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, getTestName(iTestResult) + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("❌ onTestFailure");
        CaptureHelper.screenshot(iTestResult.getName());
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.addScreenshot(iTestResult.getName());
        ExtentTestManager.logMessage(Status.FAIL, iTestResult.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, getTestName(iTestResult) + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("\uD83C\uDF1FonTestSkipped");
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, iTestResult.getThrowable().toString());
    }
}
