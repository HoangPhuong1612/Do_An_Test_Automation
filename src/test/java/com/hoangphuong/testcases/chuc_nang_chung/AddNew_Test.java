package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DanhSachTaiLieuBieuMau_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNew_Test extends BaseTest {
    LoginPage loginPage;
    DanhSachTaiLieuBieuMau_Page danhSachTaiLieuBieuMauPage;
    @BeforeMethod
    public void setUp() {
        WebUI.driver = driver; // Gán driver cho WebUI
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        danhSachTaiLieuBieuMauPage=new DanhSachTaiLieuBieuMau_Page(driver);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.menuQuanLyTaiLieuBieuMau);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.menuQuanLyDanhSachTaiLieuBieuMau);
    }

    @Test(priority = 1, description = "Thêm mới thành công với thông tin hợp lệ")
    public void addNewSuccess(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickbuttonAddNew();
        danhSachTaiLieuBieuMauPage.addNewTaiLieuBieuMau("Biểu mẫu 14/2", "Tài liệu","Nội dung biểu mẫu 12345");
        WebUI.sleep(3);
        danhSachTaiLieuBieuMauPage.clickButtonCapNhat();
        WebUI.sleep(3);
    }

    @Test(priority = 2, description = "Thêm mới thất bại với tiêu dề để trống")
    public void addNewFailWithTieuDeNull(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickbuttonAddNew();
        danhSachTaiLieuBieuMauPage.addNewTaiLieuBieuMau("", "Tài liệu","Nội dung biểu mẫu tháng 8");
        WebUI.sleep(3);
        danhSachTaiLieuBieuMauPage.clickButtonCapNhat();
        WebUI.sleep(3);
        danhSachTaiLieuBieuMauPage.verifyFailTieuDeNull();
    }
    @Test(priority = 3, description = "Thêm mới thất bại với danh mục tài liệu để trống")
    public void addNewFailWithDanhMucNull(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickbuttonAddNew();
        //danhSachTaiLieuBieuMauPage.addNewTaiLieuBieuMau("Biểu mẫu tháng 8", "","Nội dung biểu mẫu tháng 8");
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        driver.findElement(danhSachTaiLieuBieuMauPage.inputTieuDe).sendKeys("Biểu mẫu tháng 10");
        danhSachTaiLieuBieuMauPage.clickButtonCapNhat();
        WebUI.sleep(3);
        danhSachTaiLieuBieuMauPage.verifyAddFailDanhMucNull();
    }
    @Test(priority = 4, description = "Hủy bỏ thao tác thêm mới")
    public void addNewCancel(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickbuttonAddNew();
        danhSachTaiLieuBieuMauPage.addNewTaiLieuBieuMau("Biểu mẫu 12345", "Tài liệu","Nội dung biểu ẫu 12345");
        danhSachTaiLieuBieuMauPage.clickButtonThoat();
        WebUI.sleep(3);
    }
}
