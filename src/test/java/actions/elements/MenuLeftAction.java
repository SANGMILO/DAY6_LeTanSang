package actions.elements;

import actions.BasePage;
import interfaces.elements.Menu_Left;
import org.openqa.selenium.WebDriver;

public class MenuLeftAction extends BasePage implements Menu_Left {

    public MenuLeftAction(WebDriver driver) {
        super(driver);
    }

    public void openTextBox() {
        waitForElementIsVisible(TextBox_menu);
        scrollIntoView(TextBox_menu);
        clickReliable(TextBox_menu);

    }

    public void openCheckBox() {
        waitForElementIsVisible(CheckBox_menu);
        scrollIntoView(CheckBox_menu);
        clickReliable(CheckBox_menu);

    }
    public void openRadioButton() {
        clickReliable(RadioButton);
    }

}
