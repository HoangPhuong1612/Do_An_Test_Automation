package com.hoangphuong.testcases.module_tests;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.LoginPage;
import com.hoangphuong.pages.TinNoiBat_Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TinNoiBat_Test extends BaseTest {
    LoginPage loginPage;
    TinNoiBat_Page tinNoiBatPage;

    @BeforeMethod
    public void setUp(){
        WebUI.driver=driver;
    }
    @BeforeMethod
    public void truyCapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        tinNoiBatPage= new TinNoiBat_Page(driver);
        WebUI.clickElement(tinNoiBatPage.menuQuanLyTinBai);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(tinNoiBatPage.menuTinNoiBat);
        WebUI.waitForPageLoaded(driver);
    }

    /*@Test
    public void themMoiTinNong (){
        WebUI.sleep(2);
        tinNoiBatPage.themmoiTinNoiBat();
        WebUI.sleep(2);
    }*/

    @Test(priority = 1)
    public void xoaTinNong (){
        WebUI.sleep(2);
        tinNoiBatPage.xoaTinNoiBat();
        WebUI.sleep(2);
    }

    @Test(priority = 2)
    public void sapXepThuTu(){
        WebUI.sleep(2);
        tinNoiBatPage.sapSepTinNoiBat();
        WebUI.sleep(2);
    }

    @Test(priority = 3)
    public void xuatBan(){
        WebUI.sleep(2);
        tinNoiBatPage.xuatBanTinNoiBat();
        WebUI.sleep(2);
    }

    @Test(priority = 4)
    public void anTinNong(){
        WebUI.sleep(2);
        tinNoiBatPage.anTinNoiBat();
        WebUI.sleep(2);
    }

    @Test(priority = 5)
    public void xemDanhSach(){
        WebUI.sleep(2);
        tinNoiBatPage.danhSachTinNoiBat();
        WebUI.sleep(2);
    }

    @Test(priority = 6)
    public void timKiemTinNong(){
        WebUI.sleep(2);
        tinNoiBatPage.timKiemTinNoiBat();
        WebUI.sleep(2);
    }
}
