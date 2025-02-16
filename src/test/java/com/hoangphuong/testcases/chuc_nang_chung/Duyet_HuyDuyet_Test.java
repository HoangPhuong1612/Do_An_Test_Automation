package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DanhSachTaiLieuBieuMau_Page;
import com.hoangphuong.pages.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Duyet_HuyDuyet_Test extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(Duyet_HuyDuyet_Test.class);
    LoginPage loginPage;
    DanhSachTaiLieuBieuMau_Page danhSachTaiLieuBieuMau_page;

    @BeforeMethod
    public void setUp (){
        WebUI.driver=driver; //gán driver cho WebUI
    }
    @BeforeMethod
    public void truyCapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        danhSachTaiLieuBieuMau_page = new DanhSachTaiLieuBieuMau_Page(driver);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.menuQuanLyTaiLieuBieuMau);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.menuQuanLyDanhSachTaiLieuBieuMau);
        WebUI.sleep(2);
    }

    @Test(priority = 1, description = "Duyệt thành công một bản ghi")
    public void duyetSuccess(){
        WebUI.waitForPageLoaded(driver);
        danhSachTaiLieuBieuMau_page.duyetTaiLieuBieuMau();
        WebUI.sleep(2);
    }

    @Test(priority = 2, description = "Hủy duyệt thành công một bản ghi")
    public void huyDuyetSuccess (){
        WebUI.waitForPageLoaded(driver);
        danhSachTaiLieuBieuMau_page.huyDuyetTaiLieuBieuMau();
        WebUI.sleep(2);
    }
}
