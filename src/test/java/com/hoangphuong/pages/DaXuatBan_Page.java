package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DaXuatBan_Page extends CommonPage{
    // khai báo driver cục bộ
    public WebDriver driver;

    //hàm xây dựng
    public DaXuatBan_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // khai báo các element
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

    public By buttonCheckAll= By.xpath("//div[@class='dataTables_scrollHead']//input");
    public By columCheckBox= By.xpath("//tbody//td[10]//input");


    //hàng table đầu tiên
    public By buttonXemtruoc1 = By.xpath("//a[@id='TinTucXT13229']");
    public By buttonXemNgoaiCong1 = By.xpath("//tbody/tr[1]/td[8]//a[2]");
    public By buttonLichSu1= By.xpath("//tbody/tr[1]/td[9]//a[1]");
    public By buttonNgungXuatBan1 = By.xpath("//tbody/tr[1]/td[9]//a[2]");
    public By buttonCopyChuyenMuc1 = By.xpath("//tbody/tr[1]/td[9]//a[3]");
    public By buttonThoiGian1 = By.xpath("//tbody/tr[1]/td[9]//a[4]");
    public By buttonChinhSua1 = By.xpath("//tbody/tr[1]/td[9]//a[5]");


    //form cập nhật thời gian
    public By ngayHetHan= By.xpath("//input[@id='NgayHetHan']");
    public By buttonCapNhat= By.xpath("//div[@class='modal-content']//button[normalize-space()='Cập nhật']");
    public By buttonThoat = By.xpath("//div[@class='modal-content']//button[normalize-space()='Thoát']");


    //khai báo các hàm xử lý
    public void checkAll(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(buttonCheckAll);
        WebUI.sleep(2);
        boolean checkBox = driver.findElement(columCheckBox).isSelected();
        Assert.assertEquals(checkBox,"true", "Tích chọn tất cả chưa thành công !");
        WebUI.sleep(1);
    }


    public void enterChuyenmuc(String chuyenmuc){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboChuyenMuc);
        WebUI.setText(inputSearchCombo1,chuyenmuc);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo1).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);

    }

    public void enterNguoiGui(String nguoigui){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboNguoiGui);
        WebUI.setText(inputSearchCombo1,nguoigui);
        WebUI.sleep(2);
        driver.findElement(inputSearchCombo1).sendKeys(Keys.ENTER);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(2);
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

 /*   public void clickSearchCombo2(){
        //dùng javascript executor để click element bị che khuất
        // nếu cuộn thì thay .click(); bằng .scrollIntoView(true);(trua là cuộn lên, false là cuộn xuống)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(inputSearchCombo2);
        js.executeScript("arguments[0].value='" + text + "';", element);
    }*/

    public void enterTrangThai(String trangthai){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(5);
        WebUI.clickElement(comboTrangThai);
        WebUI.sleep(4);
        WebUI.setText(inputSearchCombo2,trangthai);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(inputSearchCombo2);
        js.executeScript("arguments[0].value='" + trangthai + "';", element);
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

    public void xemTinBaiNgoaiCong(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(4);
        WebUI.clickElement(buttonXemNgoaiCong1);
        WebUI.waitForPageLoaded(driver);
        String linkQuanTri = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs(linkQuanTri)));
        String linkNgoaiCong = driver.getCurrentUrl();
        Assert.assertEquals(linkQuanTri,linkNgoaiCong,"Xem tin bài ngoài cổng không thành công!");
        WebUI.sleep(3);
    }

    public void capNhatThoiGian(String time){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonThoiGian1);
        WebUI.sleep(2);
        WebUI.clickElement(ngayHetHan);
        WebUI.setText(ngayHetHan,time);
        WebUI.sleep(2);
        driver.findElement(ngayHetHan).sendKeys(Keys.ENTER);
        WebUI.sleep(2);
        WebUI.clickElement(buttonThoat);
        WebUI.sleep(2);
    }

    public void xemLichSu(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonLichSu1);
        WebUI.sleep(5);
        /*String tieudebang= driver.findElement(By.xpath("//div[@class='caption col-md-4']")).getText();
        System.out.println(tieudebang);
        WebUI.sleep(3);*/
    }

    public void ngungXuatBan(){
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(3);
        String tieudeTinbai = driver.findElement(By.xpath("//tbody/tr[1]/td[9]//a[2]")).getText();
        WebUI.sleep(2);
        WebUI.clickElement(buttonNgungXuatBan1);
        WebUI.sleep(5);
        WebUI.setText(inputTuKhoa,tieudeTinbai);
        WebUI.sleep(3);
    }

    public void copyChuyenMuc(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonCopyChuyenMuc1);
        WebUI.sleep(5);
        String tieudebang= driver.findElement(By.xpath("//div[@id='25ac0161-2807-42e6-a73b-a3d4bb8fb03e_title']")).getText();
        System.out.println(tieudebang);
        WebUI.sleep(2);
        WebUI.clickElement(By.xpath("//button[@id='882c6389-bb14-454e-8f70-c323c9abae42']"));
        WebUI.sleep(3);
    }

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
}
