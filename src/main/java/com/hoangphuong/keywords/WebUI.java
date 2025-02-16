package com.hoangphuong.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {
    public static WebDriver driver;

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
    //thời gian nghỉ cho từng thao tác
    public static void sleep (double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    /*public static void srcollElement(){
        WebElement element = driver.findElement(By.id("id_of_element"));

        JavascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }*/
    public static void waitForElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitForElementTobeClickable( By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement until = wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //click 1 element
    public static void clickElement(By by){
        waitForElementVisible(by);
        driver.findElement(by).click();
    }
    //nhập dữ liệu vào 1 element
    public static void setText(By by, String text){
        waitForElementTobeClickable(by);
        driver.findElement(by).sendKeys(text);
    }

    //chờ đợi 1 element hiển thị
    public static void waitForElementVisible(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //chờ đợi 1 element hiển thị (tính đa hình)
    public static void waitForElementVisible(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    //chờ đợi 1 element click được
    public static void waitForElementTobeClickable(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    //kiểm tra element có tồn tại trong DOM hay ko ( hiển thị hoặc ko đều đc)
    public static Boolean checkElementExist(WebDriver driver, By by) {
        List<WebElement> listElement = driver.findElements(by);
        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }


    /**
     * Wait for Page loaded
     * Chờ đợi trang load xong (Javascript tải xong)
     */
    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }
}
