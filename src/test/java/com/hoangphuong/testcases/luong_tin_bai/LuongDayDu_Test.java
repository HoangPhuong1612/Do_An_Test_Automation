package com.hoangphuong.testcases.luong_tin_bai;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LuongDayDu_Test extends BaseTest {
    LoginPage loginPage;
    ThemMoiTinBai_Page themMoiTinBaiPage;
    CanBoBienTap_Page canBoBienTapPage;
    CanBoPheDuyet_Page canBoPheDuyetPage;
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

        canBoBienTapPage= new CanBoBienTap_Page(driver);
        canBoPheDuyetPage = new CanBoPheDuyet_Page(driver);
        daXuatBanPage = new DaXuatBan_Page(driver);
    }

    @Test
    public void xuatBanNgayTinBai(){
        WebUI.sleep(8);
        WebUI.waitForPageLoaded(driver);

        themMoiTinBaiPage.themMoiTinBai("Học viện Báo chí và Tuyên truyền hoàn thành Xuất sắc đề tài nghiên cứu cấp Quốc gia", "CNTT", "Tin hoạt động");
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(8);
        WebUI.clickElement(themMoiTinBaiPage.buttonGuiCanBoBienTap);
        WebUI.sleep(3);
        WebUI.clickElement(themMoiTinBaiPage.buttonDongY);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(10);

        WebUI.clickElement(themMoiTinBaiPage.menuCanBoBienTap);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.setText(canBoBienTapPage.inputTuKhoa, "Học viện Báo chí và Tuyên truyền hoàn thành Xuất sắc đề tài nghiên cứu cấp Quốc gia");
        WebUI.sleep(2);
        WebUI.clickElement(canBoBienTapPage.buttonSearch);
        WebUI.sleep(7);
        WebUI.clickElement(canBoBienTapPage.checkbox1);
        WebUI.sleep(3);
        WebUI.clickElement(canBoBienTapPage.buttonGuiCanBoPheDuyet);
        WebUI.sleep(3);
        WebUI.clickElement(canBoBienTapPage.buttonDongY);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(10);

        WebUI.clickElement(themMoiTinBaiPage.menuCanBoPheDuyet);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.setText(canBoPheDuyetPage.inputTuKhoa, "Học viện Báo chí và Tuyên truyền hoàn thành Xuất sắc đề tài nghiên cứu cấp Quốc gia");
        WebUI.sleep(2);
        WebUI.clickElement(canBoPheDuyetPage.buttonSearch);
        WebUI.sleep(7);
        WebUI.clickElement(canBoPheDuyetPage.check1);
        WebUI.sleep(3);
        WebUI.clickElement(canBoPheDuyetPage.buttonXuatBan);
        WebUI.sleep(3);
        WebUI.clickElement(canBoPheDuyetPage.buttonDongY);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(10);

        WebUI.clickElement(canBoPheDuyetPage.menuDaXuatBan);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.setText(daXuatBanPage.inputTuKhoa, "Học viện Báo chí và Tuyên truyền hoàn thành Xuất sắc đề tài nghiên cứu cấp Quốc gia");
        WebUI.sleep(2);
        WebUI.clickElement(daXuatBanPage.buttonSearch);
        WebUI.sleep(7);
    }
}
