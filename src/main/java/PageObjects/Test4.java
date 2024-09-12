package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test4 {

    @FindBy(how = How.CSS, using = "#test-4-div > button[class='btn btn-lg btn-primary']")
    public WebElement btn_primaryButton;

    @FindBy(how = How.CSS, using = "#test-4-div > button[class='btn btn-lg btn-secondary']")
    public WebElement btn_secondaryButton;
}
