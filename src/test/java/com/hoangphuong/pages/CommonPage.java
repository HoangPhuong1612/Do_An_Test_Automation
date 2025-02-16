package com.hoangphuong.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    //khai báo diver cục bộ
    public WebDriver driver;

    //hàm xây dựng
    public CommonPage (WebDriver driver){
        this.driver = driver;
    }

    //khai báo các element dạng đối tượng By

    //Menu trái
    public By menuBanLamViec= By.xpath("//ul[@id='nav-sider-left']/li[1]");
    public By menuQuanLyTinBai= By.xpath("//ul[@id='nav-sider-left']/li[2]");
    public By menuQuanLyBinhLuanTinBai= By.xpath("//ul[@id='nav-sider-left']/li[3]");
    public By menuTongHopGiongNoi= By.xpath("//ul[@id='nav-sider-left']/li[4]");
    public By menuQuanLyAnhVideo= By.xpath("//ul[@id='nav-sider-left']/li[5]");
    public By menuQuanLyThongBao= By.xpath("//ul[@id='nav-sider-left']/li[6]");
    public By menuQuanLyAnhQuangCaoLogo= By.xpath("//ul[@id='nav-sider-left']/li[7]");
    public By menuQuanLyTaiLieuBieuMau= By.xpath("//ul[@id='nav-sider-left']/li[8]");
    public By menuBaoCaoThongKe= By.xpath("//ul[@id='nav-sider-left']/li[15]");

        //menu con của menuQuanLyTaiLieuBieuMau
        //public By menuDanhMucTaiLieuBieuMau= By.xpath("//ul[@id='nav-sider-left']/li[8]/ul/li[1]");
        public By menuQuanLyDanhSachTaiLieuBieuMau = By.xpath("//ul[@id='nav-sider-left']/li[8]/ul/li[2]");
        //public By menuQuanLyBinhLuan = By.xpath("//ul[@id='nav-sider-left']/li[8]/ul/li[3]");

        //menu con của menuQuanLyTinBai
        public By menuThemMoiTinBai = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[1]");
        public By menuTinBaiCuaToi = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[2]");
        public By menuDaXuatBan = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[6]");
        public By menuCanBoPheDuyet = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[5]");
        public By menuCanBoBienTap = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[4]");
        public By menuNgungXuatBan = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[7]");
        public By menuTinNoiBat = By.xpath("//ul[@id='nav-sider-left']/li[2]/ul/li[9]");

    //Menu trên
    public By iconDanhMuc = By.xpath("//nav[@id='menuNgang']/ul/li[1]");
    public By iconHeThong = By.xpath("//nav[@id='menuNgang']/ul/li[2]");
    public By iconTienIch = By.xpath("//nav[@id='menuNgang']/ul/li[3]");

        //Menu con của menu danh mục
        public By menuDanhMucThuocTinBai = By.xpath("//div[@id='nav-left']/ul[2]/li[3]");
        public By menuDanhMucSuKien = By.xpath("//div[@id='nav-left']/ul[2]/li[3]/ul/li[2]");
        public By menuDanhMucBaiViet = By.xpath("//div[@id='nav-left']/ul[2]/li[3]/ul/li[3]");


    //khai báo các hàm xử lý
    public void clickmenuBanLamViec(){
        driver.findElement(menuBanLamViec).click();
    }

    public void clickmenuQuanLyTinBai(){
        driver.findElement(menuQuanLyTinBai).click();
    }

    public void clickmenuDaXuatBan(){
        driver.findElement(menuDaXuatBan).click();
    }
    public void clickmenuQuanLyTaiLieuBieuMau(){
        driver.findElement(menuQuanLyTaiLieuBieuMau).click();
    }

    public void clickmenuQuanLyDanhSachTaiLieuBieuMau(){
        driver.findElement(menuQuanLyDanhSachTaiLieuBieuMau).click();
    }


}
