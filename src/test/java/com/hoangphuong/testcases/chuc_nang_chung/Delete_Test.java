package com.hoangphuong.testcases.chuc_nang_chung;

import com.hoangphuong.common.BaseTest;
import com.hoangphuong.constains.ConfigData;
import com.hoangphuong.keywords.WebUI;
import com.hoangphuong.pages.DanhSachTaiLieuBieuMau_Page;
import com.hoangphuong.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Delete_Test extends BaseTest {
    LoginPage loginPage;
    DanhSachTaiLieuBieuMau_Page danhSachTaiLieuBieuMau_page;

    @BeforeMethod
    public void setUp(){
        WebUI.driver=driver; //gán driver cho WebUI
    }

    @BeforeMethod
    public void truyCapMenu(){
        loginPage= new LoginPage(driver);
        loginPage.LoginCTT(ConfigData.USERNAME,ConfigData.PASSWORD);
        danhSachTaiLieuBieuMau_page= new DanhSachTaiLieuBieuMau_Page(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.menuQuanLyTaiLieuBieuMau);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.menuQuanLyDanhSachTaiLieuBieuMau);
    }

    @Test(priority = 1, description = "Xóa thành công 1 bản ghi ở trạng thái chưa duyệt")
    public void deleteSuccess(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonXoa1);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonDongY);
        WebUI.sleep(4);
    }

    @Test(priority = 2, description = "Hủy bỏ thao tác xóa 1 bản ghi ở trạng thái chưa duyệt")
    public void deleteCancel(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonXoa1);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonHuy);
        WebUI.sleep(2);
    }

    @Test(priority = 3, description = "Xóa thất bại 1 bản ghi ở trạng thái đã duyệt")
    public void deleteFail(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonXoa1);
        WebUI.sleep(1);
        String noidungThongBao= driver.findElement(danhSachTaiLieuBieuMau_page.messageThongBao).getText();
        Assert.assertEquals(noidungThongBao, "Bạn cần hủy duyệt trước khi xóa", "Nội dung thống báo sai hoặc trống");
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonThoatThongBao);
        WebUI.sleep(3);
    }

    @Test(priority = 4, description = "Xóa thất bại nhiều bản ghi bao gồm bản ghi ở trạng thái đã duyệt") //bổ sung kiểm tra
    public void deleteAllFail(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.checkAll);
        WebUI.sleep(1);
        driver.findElement(danhSachTaiLieuBieuMau_page.checkItem).isSelected();
        WebUI.sleep(1);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonDeleteAll);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonDongY);
        WebUI.sleep(1);
        String noidungThongBao= driver.findElement(danhSachTaiLieuBieuMau_page.messageThongBao).getText();
        Assert.assertEquals(noidungThongBao, "Bạn cần hủy duyệt trước khi xóa", "Nội dung thống báo sai hoặc trống");
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonThoatThongBao);
        WebUI.sleep(3);
    }

    @Test(priority = 5, description = "Xóa thành công nhiều bản ghi ở trạng thái chưa duyệt") //bổ sung kiểm tra
    public void deleteAllSuccess(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.checkAll);
        WebUI.sleep(1);
        driver.findElement(danhSachTaiLieuBieuMau_page.checkItem).isSelected();
        WebUI.sleep(1);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonDeleteAll);
        WebUI.sleep(2);
        WebUI.clickElement(danhSachTaiLieuBieuMau_page.buttonDongY);
        WebUI.sleep(2);
    }
}
