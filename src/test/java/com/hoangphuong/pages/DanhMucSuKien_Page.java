package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DanhMucSuKien_Page extends CommonPage{
    //Khai báo driver cục bộ chính cho class
    public WebDriver driver;

    //Hàm xây dựng
    public DanhMucSuKien_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Khai báo các  element dạng đối tượng By

    public By buttonThemMoi = By.xpath("//button[@id='btnAddSuKienTinTuc']");
    public By buttonXoa = By.xpath("//div[@id='tableSuKienTinTuc_wrapper']//thead//a");
    public By buttonTimKiem = By.xpath("//input[@id='btn-find-SuKienTinTuc']");
    public By inputTuKhoa = By.xpath("//input[@id='search-keyword-SuKienTinTuc']");
    public By checkAll = By.xpath("//div[@id='tableSuKienTinTuc_wrapper']//thead//input");
    public By table= By.xpath("//table[@id='tableSuKienTinTuc']");

    //hàng đầu tiên của table danh sách
    public By buttonDuyet1 = By.xpath("(//tbody//td[4]/a)[1]");
    public By buttonSua1 = By.xpath("(//tbody//td[5]/a)[1]");
    public By buttonXoa1 = By.xpath("(//tbody//td[6]/a)[1]");
    public By tieuDe1 = By.xpath("(//tbody//td[1]/a)[1]");
    public By checkitem1 = By.xpath("(//tbody//td[7]//input)[1]");
    public By buttonXemBaiVietThuocSuKien1 = By.xpath("(//tbody//td[3]/a)[1]");

    //form thêm mới
    public By inputTieuDe = By.xpath("//input[@id='Title']");
    public By buttonCapNhat = By.xpath("//button[@id='38a1a46a-21e0-4385-bd90-02de2a01f657']");
    public By buttonThoat= By.xpath("//button[@id='a0184ee7-a71f-49de-9856-6e81b6d1a79d']");

    //Form xác nhận
    public By buttonDongY =By.xpath("//div[@class='modal-dialog']//button[normalize-space()='Đồng ý!']");
    public By buttonHuy = By.xpath("//button[normalize-space()='Hủy']");

    //Tiêu đề bảng thông tin chi tiết
    public By tieuDeBangChiTiet = By.xpath("//div[contains(text(),'Hiển thị thông tin')]");

    //Tiêu đề bảng danh sách thuộc tin sự kiện
    public By tieudeBangDanhSachTinThuocSuKien = By.xpath("//div[contains(text(),'Danh sách tin theo sự kiện')]");


    //Khai báo các hàm xử lý
    public void themMoiSuKien(String tieude){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonThemMoi);
        WebUI.sleep(2);
        WebUI.setText(inputTieuDe,tieude);
        WebUI.sleep(1);
        WebUI.clickElement(buttonCapNhat);
    }

    public void capNhatSuKien(String tieude){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonSua1);
        WebUI.sleep(2);
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
        WebUI.setText(inputTieuDe, tieude);
    }

    public void xoaSuKien(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXoa1);
        WebUI.sleep(1);
        WebUI.clickElement(buttonDongY);
    }

    public void duyetSuKien(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonDuyet1);
        WebUI.sleep(2);
    }

    public void danhSachSuKien(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(table).isDisplayed();
    }

    public void chiTietSuKien(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(tieuDe1);
        WebUI.sleep(2);
        driver.findElement(tieuDeBangChiTiet).isDisplayed();
    }

    public void timKiemSuKien(){
        WebUI.waitForPageLoaded(driver);
        WebUI.setText(inputTuKhoa,"1");
        WebUI.sleep(1);
        WebUI.clickElement(buttonTimKiem);
        WebUI.sleep(2);
    }

    public void baiVietThuocSuKien(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXemBaiVietThuocSuKien1);
        WebUI.sleep(2);
        driver.findElement(tieudeBangDanhSachTinThuocSuKien).isDisplayed();
    }

}
