package com.hoangphuong.testcases.module_tests;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DanhMucBaiViet_Page;
import com.hoangphuong.pages.DanhMucSuKien_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DanhMucSuKien_Test extends BaseTest {
    LoginPage loginPage;
    DanhMucSuKien_Page danhMucSuKienPage;

    @BeforeMethod
    public void setUp(){
        WebUI.driver=driver;
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        danhMucSuKienPage= new DanhMucSuKien_Page(driver);
        WebUI.clickElement(danhMucSuKienPage.iconDanhMuc);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhMucSuKienPage.menuDanhMucThuocTinBai);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhMucSuKienPage.menuDanhMucSuKien);
        WebUI.waitForPageLoaded(driver);
    }

    /*@Test
    public void addNewSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.themMoiSuKien("Sự kiện 1");
        WebUI.sleep(2);
    }

    @Test
    public void chinhSuaSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.capNhatSuKien("Sự kiện 1");
        WebUI.sleep(2);
    }*/

    @Test(priority = 1)
    public void deleteSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.xoaSuKien();
        WebUI.sleep(2);
    }

    @Test(priority = 2)
    public void pheDuyetSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.duyetSuKien();
        WebUI.sleep(2);
    }

    @Test(priority = 3)
    public void xemDanhSachSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.danhSachSuKien();
        WebUI.sleep(2);
    }

    @Test(priority = 4)
    public void xemChiTietSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.chiTietSuKien();
        WebUI.sleep(2);
    }

    @Test(priority = 5)
    public void timKiemSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.timKiemSuKien();
        WebUI.sleep(2);
    }

    @Test(priority = 6)
    public void xemBaiVietThuocSuKien(){
        WebUI.sleep(2);
        danhMucSuKienPage.baiVietThuocSuKien();
        WebUI.sleep(2);
    }
}
