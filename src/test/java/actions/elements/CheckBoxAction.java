package actions.elements;

import actions.common.BasePage;
import interfaces.elements.CheckBoxPageInterface;
import org.openqa.selenium.WebDriver;

public class CheckBoxAction extends BasePage {
    WebDriver driver;

    public CheckBoxAction(WebDriver driver) {
        this.driver = driver;
    }

    public void expandAll() {
        clickToElement(driver, CheckBoxPageInterface.EXPAND_ALL_BUTTON);
    }

    public void selectNode(String nodeName) {
        clickToElement(driver, CheckBoxPageInterface.NODE_BY_TEXT, nodeName);
    }

    public String getResultText() {
        return getTextElement(driver, CheckBoxPageInterface.OUTPUT_RESULT);
    }
}
