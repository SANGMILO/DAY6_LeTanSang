package actions.elements;

import actions.BasePage;
import interfaces.elements.CheckBoxPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxAction  extends BasePage implements CheckBoxPageInterface {
    public CheckBoxAction(WebDriver driver) {
        super(driver);
    }

    public void PASH(){
            clickToElement(Pash_ALL);
        }
        public void selectDesktop(){
            clickToElement(Desktop);
        }
        public  void KQ() {
        clickToElement(Home);
        }
        public void selectHome(){
            clickToElement(Full);
        }
        public String getOutputText() {
            By output = By.xpath("//*[@id='result']");
            waitForElementIsVisible(output);
            return getTextElement(output);
        }

    }

