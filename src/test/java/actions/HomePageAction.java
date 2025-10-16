package actions;

import interfaces.HomePageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageAction extends BasePage implements HomePageInterface{

    public HomePageAction(WebDriver driver) {
        super(driver);
    }
    public  void OpenHome(){
        getPageUrl(Home_url);
    }
    public void ClickElements() {
       waitForElementIsVisible(Elements);
        scrollIntoView(Elements);
        clickToElement(Elements);
    }




}
