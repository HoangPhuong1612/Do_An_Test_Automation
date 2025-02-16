package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DanhMucBaiViet_Page extends CommonPage{
    //Khai báo driver cục bộ chính cho class
    public WebDriver driver;

    //Hàm xây dựng
    public DanhMucBaiViet_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //khai báo các element dưới dối tượng By
    public By buttonThemMoi = By.xpath("//button[@id='btnAddDanhMucTinTuc']");
    public By buttonXoa = By.xpath("//table[@id='tableDanhMucTinTuc']/thead//a");
    public By buttonTimKiem = By.xpath("//input[@id='btn-find-DanhMucTinTuc']");
    public By inputTuKhoa = By.xpath("//input[@id='search-keyword-DanhMucTinTuc']");
    public By checkAll = By.xpath("//table[@id='tableDanhMucTinTuc']//thead//input");
    public By table= By.xpath("//table[@id='tableDanhMucTinTuc']");

    //khai báo vị trí đầu tiên của bảng
    public By buttonXemNgoaiCong1 = By.xpath("(//tbody//td[5]/a)[1]");
    public By buttonDuyet1 = By.xpath("(//tbody//td[4]/a)[1]");
    public By buttonXoa1 = By.xpath("(//tbody//td[7]/a)[1]");
    public By buttonSua1 = By.xpath("(//tbody//td[6]/a)[1]");
    public By tieudeTinbai1= By.xpath("(//tbody//td[2]/a)[1]");

    //form thêm mới
    public By inputTieuDe = By.xpath("//input[@id='Title']");
    public By buttonCapNhat = By.xpath("//button[@id='742177db-4b5e-45c5-be00-500a2db66d81']");
    public By buttonThoat= By.xpath("//button[@id='a0184ee7-a71f-49de-9856-6e81b6d1a79d']");

    //Form xác nhận
    public By buttonDongY =By.xpath("//div[@class='modal-dialog']//button[normalize-space()='Đồng ý!']");
    public By buttonHuy = By.xpath("//button[normalize-space()='Hủy']");

    //Tiêu đề bảng thông tin chi tiết
    public By tieuDeBangChiTiet = By.xpath("//div[contains(text(),'Hiển thị thông tin')]");

    //khai báo các hàm xử lý

    public void themMoiDanhMuc(String tieude){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonThemMoi);
        WebUI.sleep(2);
        WebUI.setText(inputTieuDe,tieude);
        WebUI.sleep(1);
        WebUI.clickElement(buttonCapNhat);
    }

    public void capNhatDanhMuc(String tieude){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonSua1);
        WebUI.sleep(2);
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
        WebUI.setText(inputTieuDe, tieude);
    }

    public void xoaDanhMuc(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXoa1);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDongY);
    }

    public void duyetDanhMuc(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonDuyet1);
        WebUI.sleep(2);
    }

    public void danhSachDanhMuc(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(table).isDisplayed();
    }

    public void timKiemDanhMuc(){
        WebUI.waitForPageLoaded(driver);
        WebUI.setText(inputTuKhoa,"1");
        WebUI.sleep(1);
        WebUI.clickElement(buttonTimKiem);
        WebUI.sleep(2);
    }

    public void chiTietDanhMuc(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(tieudeTinbai1);
        WebUI.sleep(2);
        driver.findElement(tieuDeBangChiTiet).isDisplayed();
    }

}
