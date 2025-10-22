package testcase;

import actions.HomePageAction;
import actions.common.AssertUtils;
import actions.common.BaseTest;
import actions.elements.*;
import common.Log;
import interfaces.HomePageInterface;
import interfaces.form.FormPageInterface;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FlowToElementTestCase extends BaseTest {
    private WebDriver driver;
    private HomePageAction homePage;
    private MenuLeftAction menuLeft;
    private TextBoxAction textBox;
    private CheckBoxAction checkBox;
    private RadioAction radioButton;


    @BeforeMethod
    public void init() {
        driver = getBrowserDriver("chrome", "https://demoqa.com/");
        homePage = new HomePageAction(driver);
        menuLeft = new MenuLeftAction(driver);
        textBox = new TextBoxAction(driver);
        checkBox = new CheckBoxAction(driver);
        radioButton = new RadioAction(driver);
    }

    @Test(priority = 1, description = "DQ-TB-001 | Elements > Text Box | Positive E2E",groups = {"DQ-TB-001"})
    public void DQ_TB_001_PositiveE2E() {
        Log.info("Step 1: Click menu Elements man hinh HomePage");
        homePage.clickOnMenu("Elements");

        Log.info("Step 2: Click menu Text-box man hinh Elements");
        menuLeft.clickOnMenuLeft("Text Box");

        Log.info("Step 3: Nhap fullName vao Text-Box FullName");
        textBox.enterFullName("Nguyen Van A");
        Log.info("Step 4: Nhap Email vao Text-Box Email");
        textBox.enterEmail("user@example.com");
        Log.info("Step 5: Nhap Address vao Text-Box Address");
        textBox.enterCurrentAddress("12 Nguyen Trai, HN");
        Log.info("Step 6: Nhap PermanentAddress vao Text-Box PermanentAddress");
        textBox.enterPermanentAddress("34 Le Loi, HCM");
        Log.info("Step 7: Click button submit o Text-Box");
        textBox.clickSubmitButton(FormPageInterface.SUBMIT_BUTTON);

        Log.info("Step 8: Verify Result hien thi man hinh !");
//        AssertUtils.assertEquals(getResult() + "Result ");
    }

//    @Test(priority = 2, description = "DQ-TB-002 | Elements > Text Box | Email sai định dạng → hiển thị lỗi, không có output")
//    public void DQ_TB_002_NegativeEmail() throws InterruptedException {
//        homePage.clickOnMenu("Elements");
//        menuLeft.clickOnMenuLeft("Text Box");
//
//        textBox.enterFullName("Nguyen Van A");
//        textBox.enterEmail("user@");
//        textBox.enterCurrentAddress("12 Nguyen Trai");
//        textBox.enterPermanentAddress("34 Le Loi");
//        textBox.clickSubmitButton(FormPageInterface.SUBMIT_BUTTON);
//        Thread.sleep(2000);
//
//        String emailClass = textBox.getElementAttributeValue(driver, "//input[@id='userEmail']", "class");
//        Assert.assertTrue(emailClass.contains("error") || emailClass.contains("invalid"),
//                "Email sai định dạng nhưng ô email không hiển thị lỗi.");
//
//        Assert.assertFalse(textBox.isDisplayElement(driver, "//div[@id='output']"),
//                "Không nên hiển thị output khi email sai định dạng.");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ignored) {}
//    }
//
//    // CHECK BOX TEST CASES
//    @Test(priority = 3, description = "DQ-CB-001 | Elements > Check Box | Positive Single Node")
//    public void DQ_CB_001_SingleDesktop() {
//        homePage.clickOnMenu("Elements");
//        menuLeft.clickOnMenuLeft("Check Box");
//
//        checkBox.expandAll();
//        checkBox.selectNode("Desktop");
//
//        Assert.assertTrue(checkBox.getResultText().toLowerCase().contains("desktop"),
//                "Kết quả không chứa từ 'desktop'");
//
//        String result = checkBox.getResultText();
//        System.out.println(System.lineSeparator()+"Result: "+ result);
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ignored) {}
//    }
//
//    @Test(priority = 4, description = "DQ-CB-002 | Elements > Check Box | Positive Parent Cascade")
//    public void DQ_CB_002_ParentCascade() {
//        homePage.clickOnMenu("Elements");
//        menuLeft.clickOnMenuLeft("Check Box");
//
//        checkBox.expandAll();
//        checkBox.selectNode("Home");
//
//        String result = checkBox.getResultText().toLowerCase();
//        Assert.assertTrue(result.contains("home"));
//        Assert.assertTrue(result.contains("documents"));
//        Assert.assertTrue(result.contains("downloads"));
//
//        String resultt = checkBox.getResultText();
//        System.out.println(System.lineSeparator()+"Result: "+ resultt);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ignored) {}
//    }
//
//    // RADIO BUTTON TEST CASE
//    @Test(priority = 5, description = "DQ-RB-001 | Elements > Radio Button | Positive Yes")
//    public void DQ_RB_001_YesSelected() {
//        homePage.clickOnMenu("Elements");
//        menuLeft.clickOnMenuLeft("Radio Button");
//
//        radioButton.clickRadio("yes");
//        Assert.assertTrue(radioButton.getResultText().contains("Yes"),
//                "Kết quả không hiển thị 'Yes' như mong đợi");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ignored) {}
//
//        String result = radioButton.getResultText();
//        System.out.println(System.lineSeparator()+"Result: "+ result);
//    }
}
