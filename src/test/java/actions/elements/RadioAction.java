package actions.elements;

import actions.common.BasePage;
import interfaces.elements.RadioButtonPageInterface;
import org.openqa.selenium.WebDriver;

public class RadioAction extends BasePage {
    WebDriver driver;
    public RadioAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRadio(String label) {
        clickToElement(driver, RadioButtonPageInterface.RADIO_BY_LABEL, label);
    }

    public String getResultText() {
        return getTextElement(driver, RadioButtonPageInterface.OUTPUT_RESULT);
    }
}
