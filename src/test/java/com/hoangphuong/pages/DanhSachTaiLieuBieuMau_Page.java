package com.hoangphuong.pages;

import com.hoangphuong.keywords.WebUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.security.PublicKey;

public class DanhSachTaiLieuBieuMau_Page extends CommonPage {
    //khai báo driver cục bộ chính cho class
    private WebDriver driver;

    //hàm xây dựng
    public DanhSachTaiLieuBieuMau_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    //Khai báo các element dạng đối tượng by
    public By portletTitle = By.xpath("//div[@class='caption']");
    public By searchTaiLieuBieuMau =By.xpath("//input[@id='search-keyword-TaiLieuBieuMau']");
    public By buttonSearch = By.xpath("//input[@id='btn-find-TaiLieuBieuMau']");
    public By buttonAddNew = By.xpath("//button[@id='btnAddTaiLieuBieuMau']");
    public By butttonExportExcel = By.xpath("//button[@id='btnExcelTaiLieuBieuMau']");
    public By checkAll = By.xpath("//input[@class='checked-all']");
    public By checkItem = By.xpath("//input[@class='check-item']");
    public By buttonDeleteAll= By.xpath("//table[@id='tableTaiLieuBieuMau']/thead//th[4]/a");

    //hàng table đầu tiên
    public By buttonDuyet1 = By.xpath("//tbody/tr[1]/td[2]/a");
    public By buttonSua1 = By.xpath("//tbody/tr[1]/td[3]/a");
    public By buttonXoa1 = By.xpath("//tbody/tr[1]/td[4]/a");
    public By checkbox1 = By.xpath("//tbody/tr[1]/td[5]/input");
    public By buttonSapXepTieuDe = By.xpath("//thead/tr[1]/th[1]");
    public By tieudeBanghi1 = By.xpath("//table[@id='tableTaiLieuBieuMau']/tbody//td[1]");

    //form thêm mới
    public By inputTieuDe= By.xpath("//input[@id='Title']");
    public By comboDanhMucTaiLieu = By.xpath("//select[@id='DanhMucTaiLieu']/following::span[1]");
    public By searchCombobox = By.xpath("//form[@id='frm-TaiLieuBieuMau']/following-sibling::span//input");
    public By inputMoTa= By.xpath("//div[@id='editor-container']//div/p");
    public By buttonCapNhat = By.xpath("//button[normalize-space()='Cập nhật']");
    public By buttonThoat =  By.xpath("//button[normalize-space()='Thoát']");
    public By titleError = By.xpath("//label[@id='Title-error']");
    public By danhMucError = By.xpath("//label[@id='DanhMucTaiLieu-error']");

    //Form xác nhận
    public By buttonDongY =By.xpath("//div[@class='modal-dialog']//button[normalize-space()='Đồng ý!']");
    public By buttonHuy = By.xpath("//button[normalize-space()='Hủy']");

    //form thông báo
    public By messageThongBao = By.xpath("//div[@class='bootstrap-dialog-message']");
    public By buttonThoatThongBao= By.xpath("//button[normalize-space()='Thoát']");


    //khai báo hàm xử lý
    public void clickbuttonAddNew(){
        WebUI.waitForPageLoaded(driver);
        System.out.println(WebUI.checkElementExist(driver,buttonAddNew));
        driver.findElement(buttonAddNew).click();
    }

    public void addNewTaiLieuBieuMau(String tieude, String danhmuc, String mota){

        WebUI.waitForPageLoaded(driver);
        WebUI.setText(inputTieuDe, tieude);
        driver.findElement(comboDanhMucTaiLieu).click();
        WebUI.setText(searchCombobox,danhmuc);
        WebUI.sleep(2);
        driver.findElement(searchCombobox).sendKeys(Keys.ENTER);
       // WebUI.clickElement(inputMoTa);
        WebUI.sleep(1);
        //chuyển sang iframe thứ 1
        driver.switchTo().frame(0);
        WebUI.setText(inputMoTa, mota);
        //chuyển về nội dung chính, ko thuộc iframe nào (quay về trang ban đầu, ko làm việc trong iframe nữa)
        driver.switchTo().parentFrame();
        WebUI.sleep(1);
    }

    /*public void deleteTaiLieuBieuMau(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonXoa1);
        WebUI.sleep(2);
    }*/

    public void editTaiLieuBieuMau(String tieude){
        WebUI.waitForPageLoaded(driver);
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).keyDown(Keys.BACK_SPACE).keyUp(Keys.BACK_SPACE).build().perform();
        WebUI.setText(inputTieuDe, tieude);
    }
    public  void verifyEditSuccess(String tieude){
        WebUI.waitForPageLoaded(driver);
        String tieude1= driver.findElement(tieudeBanghi1).getText();
        Assert.assertEquals(tieude1, tieude, "Chỉnh sửa tiêu đề chưa thành công");
        WebUI.sleep(3);
        WebUI.waitForPageLoaded(driver);
    }

    public void duyetTaiLieuBieuMau(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonDuyet1);
        WebUI.sleep(3);
        String trangthai = driver.findElement(buttonDuyet1).getText();
        Assert.assertEquals(trangthai, "Hủy duyệt", "Bản ghi chưa được duyệt!");
    }

    public void huyDuyetTaiLieuBieuMau(){
        WebUI.waitForPageLoaded(driver);
        WebUI.clickElement(buttonDuyet1);
        WebUI.sleep(2);
        String trangthai = driver.findElement(buttonDuyet1).getText();
        Assert.assertEquals(trangthai, "Duyệt", "Bản ghi chưa được hủy duyệt!");
    }

    public void clickButtonCapNhat(){
        //dùng javascript executor để click button cập nhật do bị footer che khuất
        // nếu cuộn thì thay .click(); bằng .scrollIntoView(true);(true là cuộn lên, false là cuộn xuống)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(buttonCapNhat);
        js.executeScript("arguments[0].click();", element);
    }
    public void clickButtonThoat(){
        //dùng javascript executor để click button thoats do bị footer che khuất
        // nếu cuộn thì thay .click(); bằng .scrollIntoView(true);(trua là cuộn lên, false là cuộn xuống)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(buttonThoat);
        js.executeScript("arguments[0].click();", element);
    }

    public void verifyFailTieuDeNull (){
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(driver.findElement(titleError).isDisplayed(),"Chưa hiển thị thông báo lỗi");
        String errorMessage = driver.findElement(titleError).getText();
        Assert.assertEquals(errorMessage, "Vui lòng nhập tiêu đề","Nội dung thông báo lỗi chưa đúng hoặc chưa hiển thị");
    }

    public void verifyAddFailDanhMucNull (){
        WebUI.waitForPageLoaded(driver);
        Assert.assertTrue(driver.findElement(danhMucError).isDisplayed(),"Chưa hiển thị thông báo lỗi");
        String errorMessage = driver.findElement(danhMucError).getText();
        Assert.assertEquals(errorMessage, "Vui lòng chọn danh mục","Nội dung thông báo lỗi chưa đúng hoặc chưa hiển thị");
    }
}
