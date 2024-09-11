package Utilities;

import PageObjects.TestsPage;
import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {

    public static void initPages() {
        testsPage = PageFactory.initElements(webDriver, TestsPage.class);
    }
}
