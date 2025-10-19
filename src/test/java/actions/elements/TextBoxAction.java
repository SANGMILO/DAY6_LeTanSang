package actions.elements;

import actions.common.BasePage;
import interfaces.CommonInterface;
import interfaces.elements.TextBoxPageInterface;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TextBoxAction extends BasePage {
    WebDriver driver;
    public TextBoxAction(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFullName(String value) {

        enterTextToElement(driver, TextBoxPageInterface.FULL_NAME_INPUT, value);
    }

    public void enterEmail(String value) {
        enterTextToElement(driver, TextBoxPageInterface.EMAIL_INPUT, value);
    }

    public void enterCurrentAddress(String value) {
        enterTextToElement(driver, TextBoxPageInterface.CURRENT_ADDRESS_TEXTAREA, value);
    }

    public void enterPermanentAddress(String value) {
        enterTextToElement(driver, TextBoxPageInterface.PERMANENT_ADDRESS_TEXTAREA, value);
    }

    public void clickSubmitButton(String value) {
        highlightElement(driver, TextBoxPageInterface.SUBMIT_BUTTON, value);
        clickToElement(driver, TextBoxPageInterface.SUBMIT_BUTTON);
    }

    public String getOutputValue(String id) {
        return getTextElement(driver, TextBoxPageInterface.OUTPUT_FIELD_BY_ID, id);
    }

    public String getBorderColor(String id) {
        return (String) ((JavascriptExecutor) driver)
                .executeScript("return window.getComputedStyle(document.getElementById('" + id + "')).borderColor;");
    }
}
