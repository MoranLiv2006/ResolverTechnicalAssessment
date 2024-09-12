package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Test3 {
    @FindBy(how = How.CSS, using = "div[class='dropdown'] > button[id='dropdownMenuButton']")
    public WebElement btn_dropdownMenu;

    @FindBy(how = How.XPATH, using = "//a[text()='Option 3']")
    public WebElement btn_option3Button;
}
