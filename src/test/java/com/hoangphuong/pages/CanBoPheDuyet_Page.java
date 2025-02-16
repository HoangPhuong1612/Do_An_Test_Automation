package com.hoangphuong.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CanBoPheDuyet_Page extends CommonPage{
    //khai báo driver cục bộ chính cho class
    public WebDriver driver;

    //Hàm xây dựng
    public CanBoPheDuyet_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //khai báo các element dưới đối tượng By
    public By comboChuyenMuc = By.xpath("//span[@id='select2-DanhMucTinTuc-container']");
    public By inputSearchCombo1 = By.xpath("//div[@id='box-frm-TinTucBaiViet']/span//input");
    public By inputSearchCombo2 = By.xpath("//body/span[5]//input");
    public By comboTrangThai = By.xpath("//span[@id='select2-txtTrangThai-container']");
    public By comboNguoiGui = By.xpath("//span[@id='select2-txtNguoitao-container']");
    public By comboSuKien = By.xpath("//span[@id='select2-EventNews-container']");
    public By comboLoaiTinBai = By.xpath("//span[@id='select2-LoaiBaiViet-container']");
    public By inputTuNgay = By.xpath("//input[@id='FromDate']");
    public By inputDenNgay = By.xpath("//input[@id='ToDate']");
    public By inputTuKhoa = By.xpath("//input[@id='search-keyword-TinTucBaiViet']");
    public By buttonSearch = By.xpath("//i[@id='btn-Search']");
    public By buttonXuatBan= By.xpath("//button[@id='btnXuatBanNhieu']");



    //Form xác nhận
    public By buttonDongY =By.xpath("//div[@class='modal-dialog']//button[normalize-space()='Đồng ý!']");
    public By buttonHuy = By.xpath("//button[normalize-space()='Hủy']");


    //đối tượng đầu trong bảng
    public By buttonDuyet1 = By.xpath("(//tbody//td[8]//a[1])[1]");
    public By tieuDe1 = By.xpath("(//tbody//td[2]/a)[1]");
    public  By check1= By.xpath("//tbody//tr[1]//td[9]//input");

    //khai báo các hàm xử lý

}
