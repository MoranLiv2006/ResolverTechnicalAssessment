package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Test2 {
    @FindBy(how = How.CSS, using = "#test-2-div > ul[class='list-group'] > li")
    public List<WebElement> list_listGroup;

    @FindBy(how = How.XPATH, using = "//*[@id='test-2-div']/ul/li[2]/span")
    public WebElement text_secondItemBadge;
}
