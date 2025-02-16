package com.hoangphuong.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();


    //config giá trị cứng
    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("exports/Extentreport/Extentreport.html");
        reporter.config().setReportName("Extent Report | Hoang Phuong");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Đồ án Tốt nghiệp");
        extentReports.setSystemInfo("Author", "Hoàng Phương");
        return extentReports;
    }

}