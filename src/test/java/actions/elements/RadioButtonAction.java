package actions.elements;

import actions.BasePage;
import interfaces.elements.RadioButton;
import org.openqa.selenium.WebDriver;

public class RadioButtonAction extends BasePage implements RadioButton {

    public RadioButtonAction(WebDriver driver) {
        super(driver);
    }

    // Click nút Yes
    public void clickYes() {
        clickReliable(YES);
    }

    // Click nút Impressive
    public void clickImpressive() {
        clickReliable(IMPRESSIVE);
    }

    // Lấy text kết quả hiển thị ("Yes" hoặc "Impressive")
    public String getSelectedValue() {
        waitForElementIsVisible(RESULT_VALUE);
        return getTextElement(RESULT_VALUE).trim();
    }

    // Kiểm tra nút Yes đã được chọn
    public boolean isYesChecked() {
        return getElement(YES_INPUT).isSelected();
    }

    // Kiểm tra nút Impressive đã được chọn
    public boolean isImpressiveChecked() {
        return getElement(IMPRESSIVE_INPUT).isSelected();
    }
}
