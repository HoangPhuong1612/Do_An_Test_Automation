package com.hoangphuong.testcases.module_tests;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DanhMucBaiViet_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DanhMucBaiViet_Test extends BaseTest {
    LoginPage loginPage;
    DanhMucBaiViet_Page danhMucBaiVietPage;

    @BeforeMethod
    public void setUp(){
        WebUI.driver=driver;
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        danhMucBaiVietPage= new DanhMucBaiViet_Page(driver);
        WebUI.clickElement(danhMucBaiVietPage.iconDanhMuc);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhMucBaiVietPage.menuDanhMucThuocTinBai);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhMucBaiVietPage.menuDanhMucBaiViet);
        WebUI.waitForPageLoaded(driver);
    }
    // bổ sung xem danh sách, xem chi tiết

    @Test(priority = 1)
    public void addNewDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.themMoiDanhMuc("Danh mục 2025");
        WebUI.sleep(2);
    }

    @Test(priority = 2)
    public void chinhSuaDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.capNhatDanhMuc("Danh mục bài viết 1");
        WebUI.sleep(2);
    }

    @Test(priority = 3)
    public void deleteDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.xoaDanhMuc();
        WebUI.sleep(2);
    }

    @Test(priority = 4)
    public void pheDuyetDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.duyetDanhMuc();
        WebUI.sleep(2);
    }

    @Test(priority = 5)
    public void xemDanhSachDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.danhSachDanhMuc();
        WebUI.sleep(2);
    }

    @Test(priority = 6)
    public void timKiemDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.timKiemDanhMuc();
        WebUI.sleep(2);
    }

    @Test(priority = 7)
    public void xemChiTietDanhMuc(){
        WebUI.sleep(2);
        danhMucBaiVietPage.chiTietDanhMuc();
        WebUI.sleep(2);
    }

}
