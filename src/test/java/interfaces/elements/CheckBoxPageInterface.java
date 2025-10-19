package interfaces.elements;

import org.openqa.selenium.By;

public interface CheckBoxPageInterface {
    String EXPAND_ALL_BUTTON = "//button[@title='Expand all']";

    // Locator động: truyền tên node (Home / Desktop / Documents / ...)
    String NODE_BY_TEXT      = "//span[@class='rct-title' and normalize-space(text())='%s']";

    // Khu vực kết quả “You have selected”
    String RESULT_BOX        = "//div[@id='result']";
    // Các item màu xanh trong kết quả
    String RESULT_ITEMS      = "//div[@id='result']//span[@class='text-success']";
}
