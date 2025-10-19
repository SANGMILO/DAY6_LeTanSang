package interfaces.form;

public class FormPageInterface {
    public static final String USER_FORM = "//form[@id='userForm']";

    // ===== INPUT FIELD =====
    // Dành cho input type="text" (Full Name, Email)
    public static final String INPUT_FIELD_BY_ID = USER_FORM + "//input[@id='%s']";

    // ===== TEXTAREA =====
    // Dành cho các field địa chỉ (Current, Permanent)
    public static final String TEXTAREA_BY_ID = USER_FORM + "//textarea[@id='%s']";

    // ===== NÚT SUBMIT =====
    public static final String SUBMIT_BUTTON = USER_FORM + "//button[@id='submit']";

    // ===== KHU VỰC HIỂN THỊ KẾT QUẢ SAU KHI SUBMIT =====
    public static final String OUTPUT_FIELD_BY_ID = "//p[@id='%s']";

    // ===== BORDER INPUT FIELD (để verify màu đỏ khi lỗi email) =====
    public static final String INPUT_BORDER_BY_ID = USER_FORM + "//input[@id='%s']";
}