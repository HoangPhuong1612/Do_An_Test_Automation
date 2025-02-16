package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.listeners.TestListener;
import com.hoangphuong.pages.BanLamViec_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class BanLamViec_Test extends BaseTest {
    LoginPage loginPage;
    BanLamViec_Page banLamViecPage;

    @Test(priority = 1)
    public void truyCapTrangChu(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        WebUI.sleep(2);
        banLamViecPage = new BanLamViec_Page(driver);
        banLamViecPage.clickbuttonTruyCapTrangChu();
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(15);
        banLamViecPage.checkGoToHomeSuccess();
    }

    @Test(priority = 2)
    public void tinTucDangBienTap(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        WebUI.sleep(2);

        banLamViecPage = new BanLamViec_Page(driver);
        banLamViecPage.clickbuttonTinTucDangBienTap();
        WebUI.sleep(5);
        banLamViecPage.checkSuccess("Cán bộ biên tập");
    }

    @Test(priority = 3)
    public void TinTucChoDuyet(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        WebUI.sleep(2);

        banLamViecPage = new BanLamViec_Page(driver);
        banLamViecPage.clickbuttonTinTucChoDuyet();
        WebUI.sleep(5);
        banLamViecPage.checkSuccess("Cán bộ phê duyệt");
    }

    @Test(priority = 4)
    public void TinTucBiTuChoiDuyet(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        WebUI.sleep(2);

        banLamViecPage = new BanLamViec_Page(driver);
        banLamViecPage.clickbuttonTinTucBiTuChoiDuyet();
        WebUI.sleep(5);
        banLamViecPage.checkSuccess("Ngừng xuất bản");
    }


    @Test(priority = 5)
    public void DuThaoSapHetHan(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        WebUI.sleep(2);

        banLamViecPage = new BanLamViec_Page(driver);
        banLamViecPage.clickbuttonDuThaoSapHetHan();
        WebUI.sleep(5);
        banLamViecPage.checkSuccess("Danh sách dự thảo");
    }
}
