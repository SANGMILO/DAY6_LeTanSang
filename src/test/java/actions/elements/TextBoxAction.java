package actions.elements;

import actions.common.BasePage;;
import interfaces.elements.TextBoxPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static interfaces.elements.TextBoxPageInterface.*;


public class TextBoxAction extends BasePage {
    WebDriver driver;
    public TextBoxAction(WebDriver driver) {
        this.driver = driver;
    }
    public void enterFullName(String value) {
        waitForElementIsVisible(driver,FULL_NAME_INPUT);
        enterTextToElement(driver, FULL_NAME_INPUT, value);
    }

    public void enterEmail(String value) {
        waitForElementIsVisible(driver,EMAIL_INPUT);
        enterTextToElement(driver, EMAIL_INPUT, value);
    }

    public void enterCurrentAddress(String value) {
        waitForElementIsVisible(driver,CURRENT_ADDRESS_TEXTAREA);
        enterTextToElement(driver, CURRENT_ADDRESS_TEXTAREA, value);
    }

    public void enterPermanentAddress(String value) {
        waitForElementIsVisible(driver,PERMANENT_ADDRESS_TEXTAREA);
        enterTextToElement(driver, TextBoxPageInterface.PERMANENT_ADDRESS_TEXTAREA, value);
    }

    public void clickSubmitButton(String value) {
        waitForElementIsVisible(driver,TextBoxPageInterface.SUBMIT_BUTTON);
        scrollIntoView(driver,TextBoxPageInterface.SUBMIT_BUTTON);
        clickToElement(driver, TextBoxPageInterface.SUBMIT_BUTTON);
    }


    public String getResult() {
        waitForElementIsVisible(driver, String.valueOf(OUTPUT_TEXT));
        String outputresult = getTextElement(driver, OUTPUT_TEXT);
        return outputresult;
    }
}
