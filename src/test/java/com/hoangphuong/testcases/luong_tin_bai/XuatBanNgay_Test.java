package com.hoangphuong.testcases.luong_tin_bai;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DaXuatBan_Page;
import com.hoangphuong.pages.LoginPage;
import com.hoangphuong.pages.ThemMoiTinBai_Page;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class XuatBanNgay_Test extends BaseTest {
    LoginPage loginPage;
    ThemMoiTinBai_Page themMoiTinBaiPage;
    DaXuatBan_Page daXuatBanPage;

    @BeforeMethod
    public void setUp() {
        WebUI.driver = driver; // Gán driver cho WebUI
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME,ConfigData.PASSWORD);

        themMoiTinBaiPage = new ThemMoiTinBai_Page(driver);
        WebUI.clickElement(themMoiTinBaiPage.menuQuanLyTinBai);
        WebUI.clickElement(themMoiTinBaiPage.menuThemMoiTinBai);

        daXuatBanPage = new DaXuatBan_Page(driver);
    }

    @Test
    public void xuatBanNgayTinBai(){
        WebUI.sleep(8);
        WebUI.waitForPageLoaded(driver);

        themMoiTinBaiPage.themMoiTinBai("Học viện Báo chí và Tuyên truyền hoàn thành Xuất sắc đề tài nghiên cứu cấp Quốc gia(ngay13/2)", "CNTT", "Tin hoạt động");
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(8);
        WebUI.clickElement(themMoiTinBaiPage.buttonXuatBanNgay);
        WebUI.sleep(3);
        WebUI.clickElement(themMoiTinBaiPage.buttonDongY);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(10);
        WebUI.clickElement(themMoiTinBaiPage.menuDaXuatBan);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.setText(daXuatBanPage.inputTuKhoa, "Học viện Báo chí và Tuyên truyền hoàn thành Xuất sắc đề tài nghiên cứu cấp Quốc gia");
        WebUI.sleep(2);
        WebUI.clickElement(daXuatBanPage.buttonSearch);
        WebUI.sleep(7);
    }
}
