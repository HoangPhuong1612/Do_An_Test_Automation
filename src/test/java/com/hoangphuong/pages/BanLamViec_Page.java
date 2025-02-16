package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BanLamViec_Page extends CommonPage {
    //khai báo driver cục bộ
    private WebDriver driver;

    //hàm xây dựng
    public BanLamViec_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //khai báo các element
    public By buttonTruyCapTrangChu= By.xpath("//div[@id='gotoHome']");
    public By buttonTinTucDangBienTap= By.xpath("//div[@id='tindangbientap']");
    public By buttonTinTucChoDuyet= By.xpath("//div[@id='tinchoduyet']");
    public By buttonTinTucBiTuChoiDuyet= By.xpath("//div[@id='tintuchoi']");
    public By buttonBinhLuanMoi= By.xpath("//div[@id='binhluan']");
    public By buttonDuThaoSapHetHan= By.xpath("//div[@id='duthao']");

    public By phanTichTrang =By.xpath("//a[normalize-space()='Phân tích trang web']");
    public By itemNguoiDung= By.xpath("//div[@id='s4-workspace']//a[1][@href='/Pages/home.aspx']");
    public By portletTitle = By.xpath("//div[@class='caption']");
    //khai báo các hàm xử lý
    public void clickphanTichTrang(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,phanTichTrang));
        driver.findElement(phanTichTrang).click();
        WebUI.waitForPageLoaded(driver);
    }
    public void clickbuttonTruyCapTrangChu(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonTruyCapTrangChu));
        driver.findElement(buttonTruyCapTrangChu).click();
    }

    public void checkGoToHomeSuccess(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        String urlQuanTri = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(urlQuanTri)));
        String urlTrangChu = driver.getCurrentUrl();
        Assert.assertEquals(urlQuanTri,urlTrangChu,"Truy cập trang chủ không thành công");
    }

    public void clickbuttonTinTucDangBienTap(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonTinTucDangBienTap));
        driver.findElement(buttonTinTucDangBienTap).click();
    }

    public void checkSuccess(String expectedPortletTitle){
        WebUI.waitForPageLoaded(driver);
        Assert.assertEquals(driver.findElement(portletTitle).getText(),expectedPortletTitle,"Truy cập chưa thành công!");
    }

    public void clickbuttonTinTucChoDuyet(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonTinTucDangBienTap));
        driver.findElement(buttonTinTucChoDuyet).click();
    }

    public void clickbuttonTinTucBiTuChoiDuyet(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonTinTucBiTuChoiDuyet));
        driver.findElement(buttonTinTucBiTuChoiDuyet).click();
    }

    public void clickbuttonBinhLuanMoi(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonBinhLuanMoi));
        driver.findElement(buttonBinhLuanMoi).click();
    }

    public void clickbuttonDuThaoSapHetHan(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonDuThaoSapHetHan));
        driver.findElement(buttonDuThaoSapHetHan).click();
    }


}
