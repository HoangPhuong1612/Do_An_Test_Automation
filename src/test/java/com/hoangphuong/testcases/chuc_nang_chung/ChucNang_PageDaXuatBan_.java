package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DaXuatBan_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChucNang_PageDaXuatBan_ extends BaseTest {
    LoginPage loginPage;
    DaXuatBan_Page daXuatBanPage;

    @BeforeMethod
    public void setUp(){
        WebUI.driver=driver;
    }

    @BeforeMethod
    public void truycapMenu(){
        loginPage = new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME, ConfigData.PASSWORD);
        daXuatBanPage = new DaXuatBan_Page(driver);
        WebUI.clickElement(daXuatBanPage.menuQuanLyTinBai);
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(daXuatBanPage.menuDaXuatBan);
        WebUI.sleep(5);
    }

    @Test(priority = 1, description = "Xem chi tiết tin bài ngoài cổng thành công")
    public void xemTinNgoaiCong(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        daXuatBanPage.xemTinBaiNgoaiCong();
        WebUI.sleep(3);
    }

    @Test (priority = 2,description = "Cập nhật thời gian")
    public void capNhatThoiGian(){
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.capNhatThoiGian("16/01/2025  22:54");
        WebUI.sleep(3);
    }

    @Test (priority = 3,description = "Xem lịch sử thay đổi")
    public void xemLichSuThayDoi(){
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.xemLichSu();
        WebUI.sleep(3);
    }


    @Test(priority = 4, description = "Kiểm tra tất cả check box đã được tích hay chưa")
    public  void enterCheckall(){
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.checkAll();
        WebUI.sleep(3);
    }

    @Test (priority =5,description = "Ngừng xuất bản tin bài")
    public void ngungXuatBanTinBai(){
        WebUI.waitForPageLoaded(driver);
        daXuatBanPage.ngungXuatBan();
        WebUI.sleep(3);
    }
}
