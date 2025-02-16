package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TinNoiBat_Page extends CommonPage{
    //khai báo driver cục bộ chính cho class
    public WebDriver driver;

    //hàm xây dựng
    public TinNoiBat_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //khai báo các element dưới dạng đói tượng by
    public By buttonThemMoi= By.xpath("//button[@id='btnAddTinNongMoi']");
    public By buttonDeleteAll = By.xpath("//thead//th/a");
    public By buttonTimKiem= By.xpath("//button[@id='btn-find-TinNongMoi']");
    public By buttonXuatExcel = By.xpath("//button[@id='btn-excel-TinNongMoi']");
    public By inputTuKhoa= By.xpath("//input[@id='search-keyword-TinNongMoi']");

    public By table = By.xpath("//table[@id='tableTinNongMoi']");

    //khai báo đối tượng đầu tiên của table
    public By buttonXoa1= By.xpath("(//tbody//td[9]/a)[1]");
    public By buttonSua1= By.xpath("(//tbody//td[8]/a)[1]");
    public By buttonDuyet1= By.xpath("(//tbody//td[7]/a)[1]");
    public By buttonXuong1 = By.xpath("(//tbody//td[6]/a)[1]");
    public By buttonLen1 = By.xpath("(//tbody//td[5]/a)[1]");

    //form thêm mới
    public By checkitem1= By.xpath("(//tbody//td[6]/input)[1]");
    public By buttonthem = By.xpath("//button[@id='btnThemTinTucBaiViet']");

    //Form xác nhận
    public By buttonDongY =By.xpath("//div[@class='modal-dialog']//button[normalize-space()='Đồng ý!']");
    public By buttonHuy = By.xpath("//button[normalize-space()='Hủy']");


    //khai báo các hàm xử lý
    public void themmoiTinNoiBat(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonThemMoi);
        WebUI.sleep(3);
        WebUI.clickElement(checkitem1);
        WebUI.clickElement(buttonthem);
    }

    public void xoaTinNoiBat(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXoa1);
        WebUI.sleep(2);
        WebUI.clickElement(buttonDongY);
    }

    public void sapSepTinNoiBat(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXuong1);
    }

    public void xuatBanTinNoiBat(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXuatExcel);
    }

    public void anTinNoiBat(){

    }

    public void danhSachTinNoiBat(){
        WebUI.waitForPageLoaded(driver);
        driver.findElement(table).isDisplayed();
    }

    public void timKiemTinNoiBat(){
        WebUI.waitForPageLoaded(driver);
        WebUI.setText(inputTuKhoa, "Hội nghị");
        WebUI.sleep(1);
        WebUI.clickElement(buttonTimKiem);
    }

}
