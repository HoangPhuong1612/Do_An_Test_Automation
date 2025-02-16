package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DanhSachTaiLieuBieuMau_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Edit_Test extends BaseTest {
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
        danhSachTaiLieuBieuMauPage = new DanhSachTaiLieuBieuMau_Page(driver);
        WebUI.sleep(1);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.menuQuanLyTaiLieuBieuMau);
        WebUI.sleep(1);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.menuQuanLyDanhSachTaiLieuBieuMau);
    }

    @Test(priority = 1, description = "Chỉnh sửa tiêu đề bản ghi thành công")
    public void editTieuDeSuccess(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.buttonSua1);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.editTaiLieuBieuMau("Biểu mẫu 9/1/2025");
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickButtonCapNhat();
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.verifyEditSuccess("Biểu mẫu 9/1/2025");
    }

    @Test(priority = 2, description = "Chỉnh sửa thất bại với trường bắt buộc bỏ trống")
    public void editFailWithTieuDeNull(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.buttonSua1);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.editTaiLieuBieuMau("");
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickButtonCapNhat();
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.verifyFailTieuDeNull();
    }

    @Test (priority = 3)
    public void cancelEdit(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMauPage.buttonSua1);
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.editTaiLieuBieuMau("biểu mẫu");
        WebUI.sleep(2);
        danhSachTaiLieuBieuMauPage.clickButtonThoat();
        WebUI.sleep(2);
    }
}
