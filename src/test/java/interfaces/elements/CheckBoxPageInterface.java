package interfaces.elements;

import org.openqa.selenium.By;

public interface CheckBoxPageInterface {
    String EXPAND_ALL_BUTTON = "//button[@title='Expand all']";
    String NODE_BY_TEXT      = "//span[@class='rct-title' and normalize-space(text())='%s']";
    String RESULT_BOX        = "//div[@id='result']";
}
