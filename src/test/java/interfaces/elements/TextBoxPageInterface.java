package interfaces.elements;

import org.openqa.selenium.By;

public interface TextBoxPageInterface {
    public static final String FULL_NAME_INPUT = "//input[@id='userName']";
    public static final String EMAIL_INPUT = "//input[@id='userEmail']";
    public static final String CURRENT_ADDRESS_TEXTAREA = "//textarea[@id='currentAddress']";
    public static final String PERMANENT_ADDRESS_TEXTAREA = "//textarea[@id='permanentAddress']";

    public static final String SUBMIT_BUTTON =  "//button[@id='submit']";

    public static final String OUTPUT_TEXT = "//div[@id='output']";

}

