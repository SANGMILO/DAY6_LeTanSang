package interfaces.elements;

import org.openqa.selenium.By;

public interface TextBoxPageInterface {

    // ===== FORM CHÍNH =====
    public static final String USER_FORM = "//form[@id='userForm']";

    // ===== CÁC INPUT TRONG FORM =====
    public static final String FULL_NAME_INPUT = USER_FORM + "//input[@id='userName']";
    public static final String EMAIL_INPUT = USER_FORM + "//input[@id='userEmail']";
    public static final String CURRENT_ADDRESS_TEXTAREA = USER_FORM + "//textarea[@id='currentAddress']";
    public static final String PERMANENT_ADDRESS_TEXTAREA = USER_FORM + "//textarea[@id='permanentAddress']";

    // ===== NÚT SUBMIT =====
    public static final String SUBMIT_BUTTON = USER_FORM + "//button[@id='submit']";

    // ===== KHU VỰC OUTPUT SAU KHI SUBMIT =====
    public static final String OUTPUT_SECTION = "//div[@id='output']";
    public static final String OUTPUT_FIELD_BY_ID = OUTPUT_SECTION + "//p[@id='%s']";

    // ===== MÀU VIỀN INPUT (KIỂM TRA LỖI EMAIL) =====
    public static final String INPUT_BORDER_BY_ID = USER_FORM + "//*[@id='%s']";

    // ===== LABEL HIỂN THỊ (Full Name, Email, v.v.) =====
    public static final String LABEL_BY_TEXT = USER_FORM + "//label[contains(text(),'%s')]";
}

