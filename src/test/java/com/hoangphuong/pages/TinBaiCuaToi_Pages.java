package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TinBaiCuaToi_Pages extends CommonPage{
    //khai báo driver cục bộ
    public WebDriver driver;

    //hàm xây dựng
    public TinBaiCuaToi_Pages(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //khai báo các element
    public By comboChuyenMuc = By.xpath("//span[@id='select2-DanhMucTinTuc-container']");
    public By inputSearchCombo1 = By.xpath("//div[@id='box-frm-TinTucBaiViet']/span//input");
    public By inputSearchCombo2 = By.xpath("//body/span[4]//input");
    public By comboTrangThai = By.xpath("//span[@id='select2-txtTrangThai-container']");
    public By comboNguoiGui = By.xpath("//span[@id='select2-txtNguoitao-container']");
    public By comboSuKien = By.xpath("//span[@id='select2-EventNews-container']");
    public By comboLoaiTinBai = By.xpath("//span[@id='select2-LoaiBaiViet-container']");
    public By inputTuNgay = By.xpath("//input[@id='FromDate']");
    public By inputDenNgay = By.xpath("//input[@id='ToDate']");
    public By inputTuKhoa = By.xpath("//input[@id='search-keyword-TinTucBaiViet']");
    public By buttonSearch = By.xpath("//i[@id='btn-Search']");
    public By buttonIn= By.xpath("//button[@id='InTin']");

    public By table = By.xpath("//div[@id='tableTinTucBaiViet_wrapper']");

    //hàng table đầu tiên
    public By buttonXemtruoc1 = By.xpath("(//tbody//td[6]/a)[1]");
    //public By buttonLichSu1= By.xpath("");
    public By buttonXoa1= By.xpath("");

    //khai báo các hàm xử lý
    public void enterChuyenmuc(String chuyenmuc){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboChuyenMuc);
        WebUI.setText(inputSearchCombo1,chuyenmuc);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo1).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);

    }

    public void enterNguoiGui(String nguoigui){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboNguoiGui);
        WebUI.setText(inputSearchCombo1,nguoigui);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo1).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);
    }

    public void enterSuKien(String sukien){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboSuKien);
        WebUI.setText(inputSearchCombo1,sukien);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo1).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);
    }

    public void enterTrangThai(String trangthai){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboTrangThai);
        WebUI.setText(inputSearchCombo2,trangthai);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo2).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);
    }

    public void enterLoaiTinBai(String loaitinbai){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboLoaiTinBai);
        WebUI.setText(inputSearchCombo2,loaitinbai);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo2).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);
    }

    public void enterTuKhoa(String tukhoa){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.setText(inputTuKhoa,tukhoa);
        WebUI.clickElement(buttonSearch);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);
    }

    /*public void verifySuccess(String text){
        String textResult = driver.findElement(By.xpath("//table[@id='tableTinTucBaiViet']/tbody/tr[1]")).getText();
        if (textResult.contains(text)) {
            System.out.println("Tìm kiếm thành công");
        }else {
            System.out.println("Không tìm thấy");
        }
    }*/

    public void verifyChuyenMucSuccess(String text){
        String textResult = driver.findElement(By.xpath("//table[@id='tableTinTucBaiViet']//td[3]")).getText();
        if (textResult.contains(text)) {
            System.out.println("Tìm kiếm thành công");
        }else {
            System.out.println("Không tìm thấy");
        }
    }

    public void verifyNguoiGuiSuccess(String text){
        String textResult = driver.findElement(By.xpath("//table[@id='tableTinTucBaiViet']//span")).getText();
        if (textResult.contains(text)) {
            System.out.println("Tìm kiếm thành công");
        }else {
            System.out.println("Không tìm thấy");
        }
    }

    public void verifyTrangThaiSuccess(String text){
        String textResult = driver.findElement(By.xpath("//table[@id='tableTinTucBaiViet']//td[4]")).getText();
        if (textResult.contains(text)) {
            System.out.println("Tìm kiếm thành công");
        }else {
            System.out.println("Không tìm thấy");
        }
    }

    public void verifyTuKhoaSuccess(String text){
        String textResult = driver.findElement(By.xpath("//table[@id='tableTinTucBaiViet']//a")).getText();
        if (textResult.contains(text)) {
            System.out.println("Tìm kiếm thành công");
        }else {
            System.out.println("Không tìm thấy");
        }
    }

    public void danhSachTin(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
        driver.findElement(table).isDisplayed();
    }

    public void xemtruocTin(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(3);
        WebUI.clickElement(buttonXemtruoc1);
        WebUI.waitForPageLoaded(driver);
    }

    public void inTinBai(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonIn);
        WebUI.waitForPageLoaded(driver);
    }
}
