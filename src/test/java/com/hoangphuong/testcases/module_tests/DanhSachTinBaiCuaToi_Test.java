package com.hoangphuong.testcases.module_tests;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.LoginPage;
import com.hoangphuong.pages.TinBaiCuaToi_Pages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DanhSachTinBaiCuaToi_Test extends BaseTest {
    LoginPage loginPage;
    TinBaiCuaToi_Pages tinBaiCuaToiPages;

    @BeforeMethod
    public void setUp(){
        WebUI.driver=driver;
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        tinBaiCuaToiPages= new TinBaiCuaToi_Pages(driver);
        WebUI.clickElement(tinBaiCuaToiPages.menuQuanLyTinBai);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(tinBaiCuaToiPages.menuTinBaiCuaToi);
        WebUI.waitForPageLoaded(driver);
    }

    @Test
    public void xemDanhSach(){
        WebUI.sleep(5);
        tinBaiCuaToiPages.danhSachTin();
        WebUI.sleep(2);
    }

    @Test
    public void timKiemChuyenMuc(){
        WebUI.waitForPageLoaded(driver);
        tinBaiCuaToiPages.enterChuyenmuc("Tin hoạt động");
        WebUI.sleep(3);
        WebUI.waitForPageLoaded(driver);
        tinBaiCuaToiPages.verifyChuyenMucSuccess("Tin hoạt động");
        WebUI.sleep(4);
    }

    @Test
    public void xemTruocTinBai(){
        WebUI.sleep(2);
        tinBaiCuaToiPages.xemtruocTin();
        WebUI.sleep(2);
    }

    @Test
    public void inDanhSach(){
        WebUI.sleep(2);
        tinBaiCuaToiPages.inTinBai();
        WebUI.sleep(2);
    }
}
