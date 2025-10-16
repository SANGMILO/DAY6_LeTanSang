package actions.elements;

import actions.BasePage;
import interfaces.HomePageInterface;
import interfaces.elements.TextBoxPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;

public class TextBoxActions extends BasePage implements TextBoxPageInterface {


    public TextBoxActions(WebDriver driver) {
        super(driver);
    }
    public  void Input (String name,String email,String current,String preamaent){
        enterTextToElement(UserName,name);
        enterTextToElement(Email,email);
        enterTextToElement(Current,current);
        enterTextToElement(PermanentAddress,preamaent);
    }
    public  void submit(){
        scrollIntoView(Submit);
        waitForElementClickable(Submit);
        clickReliable(Submit);

    }
    public  boolean showOutput(){
        return  isDisplayElement(Out);
    }
    public String OutPutName() {
        return getTextElement(Out_Name);
    }

    public String OutPutEmail() {
        return getTextElement(Out_Email);
    }

    public String OutPutCurrentAddress() {
        return getTextElement(Out_Current);
    }

    public String OutPutPermanentAddress() {
        return getTextElement(Out_Permanent);
    }
    public boolean isEmailInvalid() {
        By locator = Email; // locator từ interface
        waitForElementIsVisible(locator);
        WebElement element = getElement(locator);

        String aria = element.getAttribute("aria-invalid");
        String borderColor = element.getCssValue("border-color");

        // In ra để debug
        System.out.println("Email border color: " + borderColor);
        System.out.println("aria-invalid: " + aria);

        return "true".equalsIgnoreCase(aria)
                || (borderColor != null && borderColor.contains("220, 53, 69"));
    }


}

