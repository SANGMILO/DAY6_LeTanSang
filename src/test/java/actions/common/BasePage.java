package actions.common;

import common.GlobalVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * BasePage - Class cơ sở cho toàn bộ Page Object
 * Chứa toàn bộ hàm xử lý Locator, Element, Actions, Alert, Frame, Dropdown, Tab...
 */
public class BasePage {

    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    // Constructor

    //1. getXpath
    public By getXpath(String xpath) {
        return By.xpath(xpath);
    }

    //2. getDynamicXpath
    public By getDynamicXpath(String pattern, String... params) {
        return By.xpath(String.format(pattern, (Object[]) params));
    }

    //3. getElement
    public WebElement getElement(WebDriver driver, String xpath) {
        return driver.findElement(getXpath(xpath));
    }

    //4. getElements
    public List<WebElement> getElements(WebDriver driver, String xpath) {
        return driver.findElements(getXpath(xpath));
    }

    //5. getElements (params)
    public List<WebElement> getElements(WebDriver driver, String xpath, String... params) {
        return driver.findElements(getDynamicXpath(xpath, params));
    }

    //6. getDynamicLocator
    public String getDynamicLocator(String pattern, String... params) {
        return String.format(pattern, (Object[]) params);
    }


    //7. getDynamicElement
    public WebElement getDynamicElement(WebDriver driver, String xpath, String... params) {
        return driver.findElement(getDynamicXpath(xpath, params));
    }

    //8. clickToElement
    public void clickToElement(WebDriver driver, String xpath) {
        waitForElementClickable(driver, xpath);
        getElement(driver, xpath).click();
    }

    //9. clickToElement (params)
    public void clickToElement(WebDriver driver, String xpath, String... params) {
        waitForElementClickable(driver, xpath, params);
        getDynamicElement(driver, xpath, params).click();
    }

    //10. enterTextToElement
    public void enterTextToElement(WebDriver driver, String xpath, String value) {
        waitForElementIsVisible(driver, xpath);
        getElement(driver, xpath).clear();
        getElement(driver, xpath).sendKeys(value);
    }

    //11. enterTextToElement (params)
    public void enterTextToElement(WebDriver driver, String xpath, String value, String... params) {
        waitForElementIsVisible(driver, xpath, params);
        getDynamicElement(driver, xpath, params).clear();
        getDynamicElement(driver, xpath, params).sendKeys(value);
    }

    //12. enterTextToElementUsingActions
    public void enterTextToElementUsingActions(WebDriver driver, String xpath, String value) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        getElement(driver, xpath).clear();

        actions.sendKeys(getElement(driver, xpath), value).perform();
    }

    //13. enterTextToElementUsingActions (params)
    public void enterTextToElementUsingActions(WebDriver driver, String xpath, String value, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath, params);
        getDynamicElement(driver, xpath).clear();
        actions.sendKeys(getDynamicElement(driver, xpath, params), value).perform();
    }

    //14. clickToElementByJS
    public void clickToElementByJS(WebDriver driver, String xpath) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, xpath));
    }

    //14. clickToElementByJS
    public void clickToElementByJS(WebDriver driver, String xpath, String... params) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getDynamicElement(driver, xpath, params));
    }


    //15. waitForElementIsVisible
    public void waitForElementIsVisible(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(getElement(driver, xpath)));
    }

    //16. waitForElementIsVisible (params)
    public void waitForElementIsVisible(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(getDynamicElement(driver, xpath, params)));
    }

    //17. waitForElementClickable
    public void waitForElementClickable(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(driver, xpath)));
    }

    //18. waitForElementClickable (params)
    public void waitForElementClickable(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(getDynamicElement(driver, xpath, params)));
    }

    //19. highLightElement
    public void highlightElement(WebDriver driver, String xpath) {
        waitForElementIsVisible(driver, xpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getElement(driver, xpath));
    }

    //20. highLightElement (params)
    public void highlightElement(WebDriver driver, String xpath, String... params) {
        waitForElementIsVisible(driver, xpath, params);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getDynamicElement(driver, xpath, params));
    }

    //21. SleepInSecond
    public void SleepInSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {
        }
    }

    //22. hoverToElement
    public void hoverOverElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        actions.moveToElement(getElement(driver, xpath)).perform();
    }

    //23. hoverToElement (params)
    public void hoverOverElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath, params);
        actions.moveToElement(getDynamicElement(driver, xpath)).perform();
    }

//    //24. rightClickOnElement
//    public void rightClickOnElement(By locator) {
//        actions.contextClick(getElement(locator)).perform();
//    }
//
//    //25. rightClickOnElement (params)
//    public void rightClickOnElement(String pattern, String... params) {
//        actions.contextClick(getDynamicElement(pattern, params)).perform();
//    }
//
//    //26. doubleClickOnElement
//    public void doubleClickOnElement(By locator) {
//        actions.doubleClick(getElement(locator)).perform();
//    }
//
//    //27. doubleClickOnElement (params)
//    public void doubleClickOnElement(String pattern, String... params) {
//        actions.doubleClick(getDynamicElement(pattern, params)).perform();
//    }
//
//    //28. dragAndDropElement
//    public void dragAndDropElement(By source, By target) {
//        actions.dragAndDrop(getElement(source), getElement(target)).perform();
//    }

//    //29. pressKeyToElement
//    public void pressKeyToElement(By locator, Keys key) {
//        getElement(locator).sendKeys(key);
//    }

//    //30. pressKeyToElement (params)
//    public void pressKeyToElement(String pattern, Keys key, String... params) {
//        getDynamicElement(pattern, params).sendKeys(key);
//    }

    //31. getTextElement
    public String getTextElement(WebDriver driver, String xpath) {
        waitForElementIsVisible(driver, xpath);
        return getElement(driver, xpath).getText().trim();
    }

    //32. getTextElement (params)
    public String getTextElement(WebDriver driver, String xpath, String... params) {
        waitForElementIsVisible(driver, xpath, params);
        return getDynamicElement(driver, xpath, params).getText().trim();
    }

//    //33. getElementAttributeValue
//    public String getElementAttributeValue(By locator, String attribute) {
//        return getElement(locator).getAttribute(attribute);
//    }
//
//    //34. getElementAttributeValue (params)
//    public String getElementAttributeValue(String pattern, String attribute, String... params) {
//        return getDynamicElement(pattern, params).getAttribute(attribute);
//    }
//
//    //35. getListElementSize
//    public int getListElementSize(By locator) {
//        return getElements(locator).size();
//    }

//    //36. getListElementSize (params)
//    public int getListElementSize(String pattern, String... params) {
//        return getElements(pattern, params).size();
//    }
//
//    //37. isDisplayElement
//    public boolean isDisplayElement(By locator) {
//        try {
//            return getElement(locator).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }

    //38. isDisplayElement (params)
//    public boolean isDisplayElement(String pattern, String... params) {
//        try {
//            return getDynamicElement(pattern, params).isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    //39. isDisplayElements
//    public boolean isDisplayElements(By locator) {
//        List<WebElement> list = getElements(locator);
//        return !list.isEmpty() && list.stream().allMatch(WebElement::isDisplayed);
//    }

    //40. isDisplayElements (params)
//    public boolean isDisplayElements(String pattern, String... params) {
//        List<WebElement> list = getElements(pattern, params);
//        return !list.isEmpty() && list.stream().allMatch(WebElement::isDisplayed);
//    }
//
//    //41. getPageUrl
//    public void getPageUrl(String url) {
//        driver.get(url);
//    }

//    //42. getPageTitle
//    public String getPageTitle() {
//        return driver.getTitle();
//    }
//
//    //43. getPageSourceCode
//    public String getPageSourceCode() {
//        return driver.getPageSource();
//    }
//
//    //44. getCurrentUrl
//    public String getCurrentUrl() {
//        return driver.getCurrentUrl();
//    }
//
//    //45. backToPage
//    public void backToPage() {
//        driver.navigate().back();
//    }
//
//    //46. forwardToPage
//    public void forwardToPage() {
//        driver.navigate().forward();
//    }
//
//    //47. refreshPage
//    public void refreshPage() {
//        driver.navigate().refresh();
//    }
//
//    //48. waitForAlertPresence
//    public Alert waitForAlertPresence() {
//        return wait.until(ExpectedConditions.alertIsPresent());
//    }

//    //49. acceptAlert
//    public void acceptAlert() {
//        waitForAlertPresence().accept();
//    }
//
//    //50. cancelAlert
//    public void cancelAlert() {
//        waitForAlertPresence().dismiss();
//    }
//
//    //51. getTextAlert
//    public String getTextAlert() {
//        return waitForAlertPresence().getText();
//    }
//
//    //52. enterTextToAlert
//    public void enterTextToAlert(String text) {
//        waitForAlertPresence().sendKeys(text);
//    }
//
//    //53. switchWindowByID
//    public void switchWindowByID(String parentID) {
//        Set<String> ID = driver.getWindowHandles();
//        for (String id : ID) {
//            if (!id.equals(parentID)) {
//                driver.switchTo().window(id);
//                break;
//            }
//        }
//    }
//
//    //54. switchWindowByTitle
//    public void switchWindowByTitle(String expectedTitle) {
//        for (String id : driver.getWindowHandles()) {
//            driver.switchTo().window(id);
//            if (driver.getTitle().equals(expectedTitle)) {
//                return;
//            }
//        }
//    }
//
//    //55. closeAllWindowsWithoutParent
//    public void closeAllWindowsWithoutParent(String parentID) {
//        for (String id : driver.getWindowHandles()) {
//            if (!id.equals(parentID)) {
//                driver.switchTo().window(id);
//                driver.close();
//            }
//        }
//        driver.switchTo().window(parentID);
//    }
//
//    //56. selectItemInDefaultDropdown
//    public void selectItemInDefaultDropdown(By locator, String text) {
//        new Select(getElement(locator)).selectByVisibleText(text);
//    }
//
//    //57. selectItemInDefaultDropdown (params)
//    public void selectItemInDefaultDropdown(String pattern, String text, String... params) {
//        new Select(getDynamicElement(pattern, text)).selectByVisibleText(text);
//    }
//
//    //58. getFirstSelectedTextItem
//    public String getFirstSelectedTextItem(By locator) {
//        return new Select(getElement(locator)).getFirstSelectedOption().getText();
//    }
//
//    //59. getFirstSelectedTextItem (params)
//    public String getFirstSelectedTextItem(String pattern, String... params) {
//        return new Select(getDynamicElement(pattern, params)).getFirstSelectedOption().getText();
//    }
//
//    //60. isDropdownMultiple
//    public boolean isDropdownMultiple(By locator) {
//        return new Select(getElement(locator)).isMultiple();
//    }
//
//    //61. isDropdownMultiple (params)
//    public boolean isDropdownMultiple(String pattern, String... params) {
//        return new Select(getDynamicElement(pattern, params)).isMultiple();
//    }
//
//    //62. checkToCheckboxOrRadio
//    public void checkToCheckboxOrRadio(By locator) {
//        WebElement e = getElement(locator);
//        if (!e.isSelected()) {
//            e.click();
//        }
//    }
//
//    //63. checkToCheckboxOrRadio (params)
//    public void checkToCheckboxOrRadio(String pattern, String... params) {
//        WebElement e = getDynamicElement(pattern, params);
//        if (!e.isSelected()) {
//            e.click();
//        }
//    }
//
//    //64. unCheckToCheckbox
//    public void unCheckToCheckbox(By locator) {
//        WebElement e = getElement(locator);
//        if (e.isSelected()) {
//            e.click();
//        }
//    }
//
//    //65. unCheckToCheckbox (params)
//    public void unCheckToCheckbox(String pattern, String... params) {
//        WebElement e = getDynamicElement(pattern, params);
//        if (!e.isSelected()) {
//            e.click();
//        }
//    }
//
//    //66. setImplicitTime
//    public void setImplicitTime(long seconds) {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
//    }
//
//    //67. switchToFrame
//    public void switchToFrame(By locator) {
//        driver.switchTo().frame(getElement(locator));
//    }
//
//    //68. switchToDefaultContent
//    public void switchToDefaultContent() {
//        driver.switchTo().defaultContent();
//    }
//
//    69.ScrollInToView
    public void scrollIntoView(WebDriver driver, String xpath, String... params) {
        WebElement el = getDynamicElement(driver, xpath, params);
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'center'});", el
            );
        } catch (JavascriptException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        }
    }
//
//    //70. clickReliable
//    public void clickReliable(By locator) {
//        try {
//            waitForElementClickable(locator);
//            scrollIntoView(locator);
//            clickToElement(locator);
//        } catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(locator));
//        }
//    }
//
//    //71. Dismiss Sticky Overlays (ẩn quảng cáo, popup che khuất)
//    public void dismissStickyOverlaysIfAny() {
//        try {
//            List<WebElement> overlays = driver.findElements(By.xpath("//*[contains(@style,'position: fixed') or contains(@style,'position: absolute')]"));
//            for (WebElement overlay : overlays) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlay);
//            }
//        } catch (Exception e) {
//            // Bỏ qua nếu không có overlay
//        }
//    }
//
//    //72. Safe Click (click an toàn)
//    public void safeClick(By locator) {
//        for (int i = 0; i < 3; i++) {
//            try {
//                waitForElementClickable(locator);
//                getElement(locator).click();
//                return;
//            } catch (ElementClickInterceptedException e) {
//                dismissStickyOverlaysIfAny();
//                SleepInSeconds(1);
//            } catch (StaleElementReferenceException e) {
//                SleepInSeconds(1);
//            }
//        }
//        clickToElementByJS(locator);
//    }
//
//    //73. Scroll to Bottom
//    public void scrollToBottom() {
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//    }
//
//    //74. Scroll to Top
//    public void scrollToTop() {
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
//    }
//
//    //75. Wait for Page Loaded (JS readyState = complete)
//    public void waitForPageLoaded() {
//        new WebDriverWait(driver, Duration.ofSeconds(15)).until(webDriver ->
//                ((JavascriptExecutor) webDriver)
//                        .executeScript("return document.readyState").equals("complete"));
//    }
//
//    //76. Click To Element By Action (cho button khó click)
//    public void clickToElementByAction(By locator) {
//        waitForElementClickable(locator);
//        actions.moveToElement(getElement(locator)).click().perform();
//    }
//
//    //77. Get all text in list elements
//    public List<String> getElementsText(By locator) {
//        List<String> texts = new ArrayList<>();
//        for (WebElement e : getElements(locator)) {
//            texts.add(e.getText().trim());
//        }
//        return texts;
//    }
}










