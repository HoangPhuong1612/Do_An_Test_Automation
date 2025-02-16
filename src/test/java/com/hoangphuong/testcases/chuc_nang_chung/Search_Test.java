package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DaXuatBan_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search_Test extends BaseTest {
    LoginPage loginPage;
    //private TinBaiCuaToi_Pages tinBaiCuaToiPages;
    DaXuatBan_Page daXuatBanPage;
    @BeforeMethod
    public void setUp() {
        WebUI.driver = driver; // Gán driver cho WebUI
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME,ConfigData.PASSWORD);

        daXuatBanPage = new DaXuatBan_Page(driver);
        WebUI.clickElement(daXuatBanPage.menuQuanLyTinBai);
        WebUI.clickElement(daXuatBanPage.menuDaXuatBan);
    }

    @Test(priority = 1, description = "Tìm kiếm theo chuyên mục")
    public void searchByChuyenMuc()  {
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.enterChuyenmuc("Tin hoạt động");
        WebUI.sleep(3);
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.verifyChuyenMucSuccess("Tin hoạt động");
        WebUI.sleep(4);
    }

    @Test(priority = 2, description = "Tìm kiếm theo người gửi")
    public void searchByNguoiGui()  {
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.enterNguoiGui("Admin Sharepoint");
        WebUI.clickElement(daXuatBanPage.buttonSearch);
        WebUI.sleep(3);
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.verifyNguoiGuiSuccess("Admin Sharepoint");
        WebUI.sleep(2);
    }

    @Test(priority = 3, description = "Tìm kiếm theo sự kiện")
    public void searchBySuKien() {
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.enterSuKien("Danh mục sự kiện mới");
        WebUI.clickElement(daXuatBanPage.buttonSearch);
        WebUI.sleep(2);
        WebUI.waitForPageLoaded(driver);
        //daXuatBanPage.verifySuKienSuccess("Danh mục sự kiện mới");
        WebUI.sleep(2);
    }


    @Test(priority = 4, description = "Tìm kiếm theo từ khóa")
    public void searchByTuKhoa() {
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.enterTuKhoa("Hội nghị");
        WebUI.sleep(3);
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.verifyTuKhoaSuccess("Hội nghị");
        WebUI.sleep(3);
    }
}
