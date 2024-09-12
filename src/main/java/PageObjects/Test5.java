package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test5 {

    @FindBy(how = How.CSS, using = "#test-5-div > h1")
    public WebElement txt_testTitle;

    @FindBy(how = How.CSS, using = "#test-5-div > button[id='test5-button']")
    public WebElement btn_test5Button;

    @FindBy(how = How.CSS, using = "#test-5-div > div[id='test5-alert']")
    public WebElement txt_test5Alert;
//
}
