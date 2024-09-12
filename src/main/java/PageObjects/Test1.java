package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test1 {
    @FindBy(how = How.XPATH, using = "//div[@id='test-1-div']//form[@class='form-signin']//input[@type='email']")
    public WebElement input_email;

    @FindBy(how = How.XPATH, using = "//div[@id='test-1-div']//form[@class='form-signin']//input[@type='password']")
    public WebElement input_password;

    @FindBy(how = How.CSS, using = "#test-1-div > form > button[type='submit']")
    public WebElement btn_signInButton;
}