package testcase;

import actions.BaseTest;
import actions.HomePageAction;
import actions.elements.CheckBoxAction;
import actions.elements.MenuLeftAction;
import actions.elements.RadioButtonAction;
import actions.elements.TextBoxActions;
import interfaces.elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class TestPage_QA extends BaseTest {

    @Test
    public void DQ_TB_001() {

        // Khởi tạo page
        HomePageAction home = new HomePageAction(driver);
        MenuLeftAction menu = new MenuLeftAction(driver);
        TextBoxActions textBox = new TextBoxActions(driver);

        // 1. Mở trang chủ
        home.OpenHome();

        // 2. Mở module Elements -> Text Box
        home.ClickElements();
        menu.openTextBox();

        // 3. Nhập dữ liệu
        String name = "Nguyen Van A";
        String email = "user@gmail.com";
        String curr = "12 Nguyen Trai, HN";
        String perm = "34 Le Loi, HCM";

        textBox.Input(name, email, curr, perm);
        textBox.submit();

        // 4. Kiểm tra output
        Assert.assertTrue(textBox.showOutput(), "Output không hiển thị!");

        Assert.assertTrue(textBox.OutPutName().contains(name), "Tên không đúng!");
        Assert.assertTrue(textBox.OutPutEmail().contains(email), "Email không đúng!");
        Assert.assertTrue(textBox.OutPutCurrentAddress().contains(curr), "Địa chỉ hiện tại sai!");
        Assert.assertTrue(textBox.OutPutPermanentAddress().contains(perm), "Địa chỉ thường trú sai!");
    }

    @Test
    public void DQ_TB_002() {
        HomePageAction home = new HomePageAction(driver);
        MenuLeftAction menu = new MenuLeftAction(driver);
        TextBoxActions textBox = new TextBoxActions(driver);

        // 1. Mở trang chủ
        home.OpenHome();

        // 2. Mở module Elements -> Text Box
        home.ClickElements();
        menu.openTextBox();

        // 3. Nhập dữ liệu
        String name = "Nguyen Van A";
        String email = "user";
        String curr = "12 Nguyen Trai";
        String perm = "34 Le Loi";

        textBox.Input(name, email, curr, perm);
        textBox.submit();

        Assert.assertTrue(textBox.isEmailInvalid(), "Email filed should be invalid!");
        if (textBox.showOutput()) {
            Assert.assertTrue(textBox.OutPutEmail().contains("user@"), "Out put must not contain invalid email!");
        }
    }

    @Test
    public void POSITIVE_SINGLE() {
        HomePageAction home = new HomePageAction(driver);
        MenuLeftAction menu = new MenuLeftAction(driver);
        CheckBoxAction CheckBox = new CheckBoxAction(driver);

        // 1. Mở trang chủ
        home.OpenHome();

        // 2. Mở module Elements -> Text Box
        home.ClickElements();
        menu.openCheckBox();


        CheckBox.PASH();
        CheckBox.selectDesktop();


        String result = CheckBox.getOutputText();
        Assert.assertTrue(result.contains("Desktop"), "khoi dong lai  'Desktop'!' " + result);
    }

    @Test
    public void POSITIVE_PARENT_CASCADE() {
        HomePageAction home = new HomePageAction(driver);
        MenuLeftAction menu = new MenuLeftAction(driver);
        CheckBoxAction CheckBox = new CheckBoxAction(driver);

        // 1. Mở trang chủ
        home.OpenHome();

        // 2. Mở module Elements -> Text Box
        home.ClickElements();
        menu.openCheckBox();
        // an home
        CheckBox.selectHome();
        // hien thi ket qua
        String result = CheckBox.getOutputText();
        Assert.assertTrue(result.contains("Desktop"), "khoi dong lai  'Desktop'!' " + result);

    }
@Test
    public void positiveYes() {
        HomePageAction home = new HomePageAction(driver);
        MenuLeftAction menu = new MenuLeftAction(driver);
        RadioButtonAction radio = new RadioButtonAction(driver);

        // 1 Mở trang chủ
        home.OpenHome();

        // 2 Mở module Elements -> Radio Button
        home.ClickElements();
        menu.openRadioButton();

        // 3Click chọn nút "Yes"
        radio.clickYes();

        // 4 Lấy kết quả hiển thị
        String result = radio.getSelectedValue();

        // 5Xác minh kết quả
        Assert.assertTrue(result.contains("Yes"),
                " Kết quả không chứa 'Yes'. Thực tế: " + result);
        Assert.assertTrue(radio.isYesChecked(),
                " Nút 'Yes' chưa được chọn!");

    }
}




