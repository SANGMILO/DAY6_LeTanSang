package actions.elements;

import actions.common.BasePage;
import interfaces.elements.CheckBoxPageInterface;
import org.openqa.selenium.WebDriver;

import static interfaces.elements.CheckBoxPageInterface.*;
import static interfaces.elements.TextBoxPageInterface.OUTPUT_TEXT;

public class CheckBoxAction extends BasePage {
    WebDriver driver;

    public CheckBoxAction(WebDriver driver) {
        this.driver = driver;
    }

    public void expandAll() {
        waitForElementIsVisible(driver, EXPAND_ALL_BUTTON);
        clickToElement(driver, EXPAND_ALL_BUTTON);
    }

    public void selectNode(String nodeName) {
        waitForElementIsVisible(driver, NODE_BY_TEXT, nodeName);
        clickToElement(driver, NODE_BY_TEXT, nodeName);
    }

    public String getResultText() {
        return getTextElement(driver, RESULT_BOX).trim();
    }
}
