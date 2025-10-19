package interfaces.elements;

import org.openqa.selenium.By;
public interface RadioButtonPageInterface {
    public static final String RADIO_BY_LABEL = "//label[contains(@for,'%s')]";
    public static final String OUTPUT_RESULT = "//span[@class='text-success']";
}