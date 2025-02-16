package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class ThemMoiTinBai_Page extends CommonPage{
    //khai báo driver cục bộ chính cho class
    public WebDriver driver;

    //hàm xây dựng
    public ThemMoiTinBai_Page(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //khai báo các element dưới đối tượng by
    public By inputTieuDe = By.xpath("//textarea[@id='Title']");
    public By inputTacGia = By.xpath("//input[@id='TacGia']");
    public By inputChuyenMuc= By.xpath("//span[@id='select2-ChuyenMucChinh-container']");
    public By searchChuyenMuc = By.xpath("//form[@id='frm-TinTucBaiViet']//span[@class='select2-search select2-search--dropdown']/input");
    public By buttonLuuLai = By.xpath("//button[contains(text(),'Lưu lại')]");
    public By buttonGuiCanBoBienTap = By.xpath("//button[contains(text(),'Gửi cán bộ biên tập')]");
    public By buttonGuiCanBoPheDuyet = By.xpath("//button[contains(text(),'Gửi cán bộ phê duyệt')]");
    public By buttonXuatBanNgay = By.xpath("//button[contains(text(),'Xuất bản ngay')]");
    public By buttonThoat = By.xpath("//button[normalize-space()='Thoát']");

    //Form xác nhận
    public By buttonDongY =By.xpath("//div[@class='modal-dialog']//button[normalize-space()='Đồng ý!']");
    public By buttonHuy = By.xpath("//button[normalize-space()='Hủy']");

    //hàm xử lý

    public void nhapTacGia(String tacgia){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(inputTacGia);
        js.executeScript("arguments[0].value='" + tacgia + "';", element);
        WebUI.sleep(2);
    }

    public void nhapChuyenMuc(String chuyenmuc){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //click đối tượng
        WebElement element = driver.findElement(inputChuyenMuc);
        js.executeScript("arguments[0].click();", element);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        //nhập vào giá trị
        /*WebElement element1 = driver.findElement(searchChuyenMuc);
        js.executeScript("arguments[0].value='" + chuyenmuc + "';", element1);
        WebUI.sleep(2);*/
        //driver.findElement(inputChuyenMuc).sendKeys(Keys.ENTER);
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();

    }

    public void themMoiTinBai(String tieude, String tacgia, String chuyenmuc){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(3);
        WebUI.setText(inputTieuDe, tieude);
        WebUI.sleep(1);
        nhapTacGia(tacgia);
        WebUI.sleep(1);
        nhapChuyenMuc(chuyenmuc);
        WebUI.sleep(1);
        WebUI.clickElement(buttonLuuLai);
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
        WebUI.clickElement(buttonLuuLai);
    }

}
