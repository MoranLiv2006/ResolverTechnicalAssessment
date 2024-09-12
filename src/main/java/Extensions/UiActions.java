package Extensions;

import Utilities.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UiActions extends Base {

    public static void clickWebElement(WebElement webElement) {
        //The elementToBeClickable expected wait condition is containing the expected wait condition of
        // ExpectedConditions.visibilityOf, that means the element will be clickable ONLY once when that element
        // will be visible and enable
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public static void writeTextToWebElement(WebElement webElement, String text) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    public static String getTextFromElement(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public static void scrollToElement(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).perform();
    }

    public static void chooseDropdownMenuOptionByValue(WebElement dropdownWebElement, WebElement optionToChoose) {
        Actions mouse = new Actions(webDriver);
        mouse.moveToElement(dropdownWebElement).click().moveToElement(optionToChoose).click().build().perform();
    }
}
